package com.liu.service;

import com.alibaba.fastjson.JSON;
import com.liu.pojo.Content;
import com.liu.utils.JsoupUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-31 - 16:32
 */
@Service
public class ContentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    // 解析爬取的数据插入到es当中
    public boolean parseContent(String keyword) throws Exception {
        // 拿取到所有的数据信息
        List<Content> goodsList = JsoupUtils.getGoodsList(keyword);
        // 把数据批量插入到es当中
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");
        for (int i = 0; i < goodsList.size(); i++) {
            bulkRequest.add(new IndexRequest("jd_goods")
                    .source(JSON.toJSONString(goodsList.get(i)), XContentType.JSON));
        }
        // 将数据进行插入到es中
        BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !response.hasFailures();
    }


    // 获取es中的数据，实现搜索的功能（无高亮）
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws Exception {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        // 实现条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        // 创建条件构造器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 构建分页条件
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);

        // 精准匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", keyword);
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 执行搜索的操作
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 将数据封装在list中
        List<Map<String, Object>> list = new ArrayList<>();
        // 所有的数据信息都封装在hits中
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            // 将取出来的每个数据信息封装成为map对象
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }


    // 获取es中的数据，实现搜索的功能（无高亮）
    public List<Map<String, Object>> searchPageHighLight(String keyword, int pageNo, int pageSize) throws Exception {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        // 实现条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        // 创建条件构造器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 构建分页条件
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);

        // 高亮设置
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        // 需要高亮的字段
        highlightBuilder.field("name");
        // 给字段添加样式以及颜色
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        // 添加到条件构造器中
        sourceBuilder.highlighter(highlightBuilder);

        // 精准匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", keyword);
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 执行搜索的操作
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 将数据封装在list中
        List<Map<String, Object>> list = new ArrayList<>();
        // 所有的数据信息都封装在hits中
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            // 将设置了高亮的字段取出来替换原来的数据
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            // 获取高亮的字段信息
            Map<String, HighlightField> highlightFields = documentFields.getHighlightFields();
            HighlightField name = highlightFields.get("name");

            // 替换原数据信息
            if (name != null){
                Text[] fragments = name.getFragments();
                StringBuilder new_name = new StringBuilder();
                for (Text text : fragments) {
                    new_name.append(text);
                }
                sourceAsMap.put("name", new_name.toString());
            }
            list.add(sourceAsMap);
        }
        return list;
    }

}

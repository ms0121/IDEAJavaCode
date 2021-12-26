package com.liu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-10-26 - 14:52
 */
public class EsClientSearchQuery {
    public static void main(String[] args) throws IOException {

        // 获取连接
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 查询索引中全部的数据信息
        SearchRequest request = new SearchRequest();
        // 表示查询的是哪个索引表
        request.indices("user");
        // 查询所有的数据信息
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        // 查询数据
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 数据主体
        SearchHits hits = response.getHits();
        System.out.println("hits.getTotalHits() = " + hits.getTotalHits());
        System.out.println("response.getTook() = " + response.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        // 关闭连接
        client.close();

    }
}

package com.liu.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-10-26 - 12:52
 */
public class EsClientBatchInsertUser {

    public static void main(String[] args) throws IOException {

        // 创建连接
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 批量插入数据信息
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan1","num","0002","age","20"));
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan2","num","0003","age","21"));
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan3","num","0004","age","22"));
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan4","num","0005","age","23"));
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan5","num","0006","age","24"));
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan6","num","0007","age","25"));

        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);

        System.out.println(responses.getIngestTook());
        // 释放连接
        client.close();
    }
}
















package com.liu.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
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
public class EsClientQueryUser {

    public static void main(String[] args) throws IOException {

        // 创建连接
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 查询指定的index
        GetRequest request = new GetRequest();
        // 删除指定的index
        // DeleteRequest request = new DeleteRequest();
        // 设置查询的条件
        request.index("user").id("1001");

        // 进行查询操作
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println("response.toString() = " + response.toString());

        // 释放连接
        client.close();
    }

}

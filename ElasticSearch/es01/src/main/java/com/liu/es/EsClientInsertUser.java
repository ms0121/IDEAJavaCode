package com.liu.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
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
public class EsClientInsertUser {

    public static void main(String[] args) throws IOException {

        // 创建连接
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");

        User user = new User();
        user.setName("zhangsan");
        user.setNum("00001");
        user.setAge(20);

        // 向es中插入数据，但是必须转为json形式的数据
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        // 向es中插入json数据信息
        request.source(userJson, XContentType.JSON);

        // 添加到es当中
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println("response.getResult() = " + response.getResult());

        // 释放连接
        client.close();
    }

}

package com.liu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-10-26 - 9:29
 */
public class EsClientIndexQuery {
    public static void main(String[] args) throws IOException {

        // 创建连接
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引index，类似于创建mysql中的数据表
        // 查询索引的请求对象
        GetIndexRequest user = new GetIndexRequest("user");
        // 发送查询的请求
        GetIndexResponse response = client.indices().get(user, RequestOptions.DEFAULT);
        // 获取创建的响应状态
        System.out.println("response.getAliases() = " + response.getAliases());
        System.out.println("response.getSettings() = " + response.getSettings());
        System.out.println("response.getMappings() = " + response.getMappings());

        // 关闭连接
        client.close();
    }
}

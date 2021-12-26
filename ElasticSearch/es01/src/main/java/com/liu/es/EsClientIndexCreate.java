package com.liu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-10-26 - 9:29
 */
public class EsClientIndexCreate {
    public static void main(String[] args) throws IOException {

        // 创建连接
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引index，类似于创建mysql中的数据表
        // 创建索引的请求对象
        CreateIndexRequest user = new CreateIndexRequest("user");
        // 发送创建的请求
        CreateIndexResponse createIndexResponse = client.indices().create(user, RequestOptions.DEFAULT);
        // 获取创建的响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("acknowledged = " + acknowledged);

        // 关闭连接
        client.close();
    }
}

package com.liu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-10-26 - 9:22
 */
public class EsClient {
    public static void main(String[] args) throws IOException {

        // 创建客户端对象
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        restHighLevelClient.close();

    }
}

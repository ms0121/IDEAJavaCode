package com.liu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
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
public class EsClientIndexUpdate {
    public static void main(String[] args) throws IOException {

        // 创建连接
        RestHighLevelClient client =
                new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建索引index，类似于创建mysql中的数据表
        // 删除索引的请求对象
        DeleteIndexRequest user = new DeleteIndexRequest("user");
        // 发送删除的请求
        AcknowledgedResponse response = client.indices().delete(user, RequestOptions.DEFAULT);
        // 获取创建的响应状态
        System.out.println("response.isAcknowledged() = " + response.isAcknowledged());
        // 关闭连接
        client.close();
    }
}

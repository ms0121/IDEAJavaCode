package com.liu.es02;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liu.es02.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Es02ApplicationTests {

	@Autowired
	@Qualifier("restHighLevelClient")
	private RestHighLevelClient client;

	@Test
	void createTest() throws IOException {
		// 创建索引请求对象
		CreateIndexRequest request = new CreateIndexRequest("lms");
		CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
		boolean acknowledged = response.isAcknowledged();
		System.out.println("acknowledged = " + acknowledged);
	}

	@Test
	void getTest() throws IOException {
		// 查询索引请求对象
		GetIndexRequest request = new GetIndexRequest("lms");
		GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
		System.out.println("response = " + response);
	}

	@Test
	void deleteTest() throws IOException {
		// 删除索引请求对象
		DeleteIndexRequest request = new DeleteIndexRequest("lms");
		AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
		boolean acknowledged = response.isAcknowledged();
		System.out.println("acknowledged = " + acknowledged);
	}


	// 添加文档
	// put: http://localhost:9200/lms_index/_doc/1001(下面代码实现)
	@Test
	public void addDocTest() throws IOException {
		// 创建索引请求对象
		IndexRequest request = new IndexRequest("lms_index");

		// 创建对象，并将其放入到指定的索引中
		User user = new User();
		user.setName("lisi");
		user.setId(1);

		// 给添加到索引中的user对象进行编号
		request.id("1001");
		request.timeout(TimeValue.timeValueSeconds(1));

		// 添加到索引中的对象必须转为json数据
		String userJson = JSONObject.toJSONString(user);
		// 将user json形式的数据添加到request中作为主体
		request.source(userJson, XContentType.JSON);

		// 将添加的请求发送到客户端
		IndexResponse response = client.index(request, RequestOptions.DEFAULT);

		System.out.println("response.status() = " + response.status());
		System.out.println("response.toString() = " + response.toString());
	}


	// 查询文档信息
	@Test
	public void getDocTest() throws IOException {
		// 设置查询的请求信息
		GetRequest request = new GetRequest("lms_index", "1001");
		GetResponse response = client.get(request, RequestOptions.DEFAULT);
		System.out.println(response.getSourceAsString());
		System.out.println("response = " + response);
	}

	// 更新文档信息
	@Test
	public void updateDocTest() throws IOException {
		// 获取更新请求对象（更新的索引表和对应的记录）,
		UpdateRequest request = new UpdateRequest("lms_index", "1001");
		request.timeout(TimeValue.timeValueSeconds(1));

		User user = new User();
		user.setId(1);
		user.setName("zhangsan");
		// 设置文档的主体为json数据
		request.doc(JSON.toJSON(user), XContentType.JSON);

		// 更新数据信息
		UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
		System.out.println("response.status() = " + response.status());

	}


	// 删除文档信息
	@Test
	public void deleteDocTest() throws IOException {
		// 设置查询的请求信息
		DeleteRequest request = new DeleteRequest("lms_index", "1001");
		DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
		System.out.println("response.toString() = " + response.toString());
		System.out.println("response = " + response);
	}
}

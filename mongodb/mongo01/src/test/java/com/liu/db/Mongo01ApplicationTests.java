package com.liu.db;

import com.liu.db.entity.Comment;
import com.liu.db.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class Mongo01ApplicationTests {

	@Resource
	private CommentService commentService;

	@Test
	void contextLoads() {
		Comment comment = new Comment();
		comment.setId("2");
		comment.setArticleid("1002");
		comment.setContent("你好,生活！");
		comment.setLikenum(999);
		comment.setPublishtime(new Date());
		comment.setReplynum(200);
		commentService.saveComment(comment);
	}

	@Test
	void test() {
		Comment comment = commentService.findCommentById("2");
		System.out.println("comment = " + comment);
	}


	@Test
	void test1() {
		commentService.updateComment("1");
	}



}

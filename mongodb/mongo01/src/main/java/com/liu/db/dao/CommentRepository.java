package com.liu.db.dao;

import com.liu.db.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lms
 * @date 2021-10-03 - 16:26
 */
public interface CommentRepository extends MongoRepository<Comment, String> {

}

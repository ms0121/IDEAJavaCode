package com.liu.db.service;

import com.liu.db.dao.CommentRepository;
import com.liu.db.entity.Comment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-03 - 16:27
 */
@Service
public class CommentService {

    @Resource
    private CommentRepository commentRepository;

    @Resource
    private MongoTemplate mongoTemplate;


    /**
     *     * 保存一个评论
     *     * @param comment
     *    
     */
    public void saveComment(Comment comment) {
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
        //设置一些默认初始值。。。
        //调用dao
        commentRepository.save(comment);
    }

    /**
      * 更新评论
      * @param comment
      */
    public void updateComment(Comment comment) {
        //调用dao
        commentRepository.save(comment);
    }

    /**
      * 根据id删除评论
      * @param id
      */
    public void deleteCommentById(String id) {
        //调用dao
        commentRepository.deleteById(id);
    }

    /**
      * 查询所有评论
      * @return
      */
    public List<Comment> findCommentList() {
        //调用dao
        return commentRepository.findAll();
    }

    /**
      * 根据id查询评论
      * @param id
      * @return
      */
    public Comment findCommentById(String id) {
        //调用dao
        return commentRepository.findById(id).get();
    }

    // 实现评论数的加 1 操作，使用template的效率高于repository
    public void updateComment(String id){
        // 设置查询的条件语句，更新指定id的数据评论数
        Query query = Query.query(Criteria.where("_id").is(id));
        // 创建更新对象
        Update update = new Update();
        // 如何更新,表示给哪个字段进行更新，inc表示给当前指定的字段进行自增操作
        update.inc("likenum");
        //参数1：查询对象
        //参数2：更新对象
        //参数3：集合的名字或实体类的类型Comment.class
        mongoTemplate.updateFirst(query,update,"comment");
    }


}

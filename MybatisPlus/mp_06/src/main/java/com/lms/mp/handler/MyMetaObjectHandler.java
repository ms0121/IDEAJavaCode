package com.lms.mp.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lms
 * @date 2021-07-16 - 15:05
 * 实现元数据处理器接口
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 执行添加的操作执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime",new Date(), metaObject);

        // 乐观锁的实现，表示
        this.setFieldValByName("version",1, metaObject);

        // 逻辑删除的初始化实现,0有效，1无效
        this.setFieldValByName("deleted",0, metaObject);
    }

//    mp执行修改操作的时候执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(), metaObject);
    }


}

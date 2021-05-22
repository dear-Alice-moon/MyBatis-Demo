package com.moon.plus.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        boolean hasSetter = metaObject.hasSetter("createTime");  // 自动填充优化：当实体类中含"createTime"属性时，传值插入.
        if (hasSetter) {

            System.out.println("--------------- insertFill ---------------");
            setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {

        Object val = getFieldValByName("updateTime", metaObject);  // 自动填充优化：当传递过来的实体类中"updateTime" 含值，这里就不再填充。
//        setUpdateFieldValByName("createTime", LocalDateTime.now(), metaObject);
        if (val == null) {

            System.out.println("--------------- updateFill ---------------");
            setUpdateFieldValByName("updateTime", new Date(), metaObject);
        }
    }
}

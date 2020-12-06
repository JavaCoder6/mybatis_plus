package com.example.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class datetimeHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill");
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("creatTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update fill start..");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}

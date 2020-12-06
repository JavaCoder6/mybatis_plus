package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class EfficientDemoTests {
    @Autowired
    UserMapper userMapper;
    //多ID查询
    @Test
    public void testdeleteByBatchId(){
        int i = userMapper.deleteBatchIds(Arrays.asList(5));
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }}



package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class DeleteDemoTests {
    @Autowired
    UserMapper userMapper;
    //多ID查询
    @Test
    public void testdeleteByBatchId(){
        int i = userMapper.deleteBatchIds(Arrays.asList(5));
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    //按条件查询
    @Test
    public void testdeleteByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询
        map.put("name","我不是无情");
        int i = userMapper.deleteByMap(map);
        userMapper.selectList(null).forEach(System.out::println);
    }}


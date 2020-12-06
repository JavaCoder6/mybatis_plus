package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    void userInster() {
        User user = new User();
        user.setName("超级无敌aaaaaaaa");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }
    @Test
    void userUpdate() {
        User user = new User();
        user.setId(6l);
        user.setName("我是神");
        int insert = userMapper.updateById(user);
        System.out.println(insert);
        System.out.println(user);
    }
    @Test
    void testOptimisticLockerTrue() {
        User user = userMapper.selectById(6l);
        //修改
        user.setName("我是无情");
        int i = userMapper.updateById(user);

    }
    @Test
    void testOptimisticLockerFlase() {
        //查询
        User user = userMapper.selectById(6l);
        //修改
        user.setName("我是无情");
        User user1 = userMapper.selectById(6l);
        user1.setName("我不是无情");
        int t = userMapper.updateById(user1);
        int i = userMapper.updateById(user);//如果没有乐观锁 就会插队

    }

}

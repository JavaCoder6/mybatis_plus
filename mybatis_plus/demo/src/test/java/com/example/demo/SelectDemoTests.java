package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class SelectDemoTests {
    @Autowired
    UserMapper userMapper;
    //多ID查询
    @Test
    public void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    //按条件查询
    @Test
    public void testSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询
        map.put("name","我不是无情");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //分页查询
    @Test
    public void testSelectLimit(){
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    //Wrapper查询
    @Test
    public void testSelectWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",20)
                .eq("name","Tom");
        userMapper.selectList(wrapper).forEach(System.out::println);

    }
    //Wrapper查询
    @Test
    public void testSelectWrapper01(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .between("age",21,30);
        System.out.println(userMapper.selectCount(wrapper));
        userMapper.selectList(wrapper).forEach(System.out::println);

    }
    //Wrapper模糊查询
    @Test
    public void testSelectWrapper02(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .between("age",21,30)
                .notLike("name","e")
                .likeRight("email","t");
        userMapper.selectMaps(wrapper).forEach(System.out::println);
        System.out.println(userMapper.selectCount(wrapper));
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
    //Wrapper多表查询
    @Test
    public void testSelectWrapper03(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .inSql("id","select id from user where id < 3");

        userMapper.selectMaps(wrapper).forEach(System.out::println);
        System.out.println(userMapper.selectCount(wrapper));
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
    //Wrapper排序查询
    @Test
    public void testSelectWrapper04(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .orderByDesc("age")
                .orderByAsc("age");

        userMapper.selectMaps(wrapper).forEach(System.out::println);
        System.out.println(userMapper.selectCount(wrapper));
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

}

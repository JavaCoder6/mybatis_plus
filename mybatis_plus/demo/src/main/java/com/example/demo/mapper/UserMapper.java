package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;




//实现一个基础mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}

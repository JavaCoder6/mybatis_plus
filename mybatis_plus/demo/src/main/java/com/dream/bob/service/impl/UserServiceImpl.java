package com.dream.bob.service.impl;

import com.dream.bob.entity.User;
import com.dream.bob.mapper.UserMapper;
import com.dream.bob.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李司繁
 * @since 2020-12-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

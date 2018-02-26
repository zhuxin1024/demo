package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User selectById(Long id) {
        if (id == null) {
            return null;
        }
        User user = null;
        try {
            user = userMapper.selectById(id);
            return user;
        } catch (Exception e) {
            logger.error("根据用户id：" + id + "获取用户失败", e);
        }
        return user;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(Long id) {
        return userMapper.delete(id);
    }
}

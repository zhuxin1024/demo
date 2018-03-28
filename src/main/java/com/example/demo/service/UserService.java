package com.example.demo.service;

import com.example.demo.domain.User;

/**
 * Created by zhuxin5 on 2018/2/26.
 */
public interface UserService {
    User selectById(Long id);

    int insert(User user);

    int update(User user);

    int delete(Long id);

    User check(String number, String password, int type);
}

package com.weilai.sec.service;

import com.weilai.sec.entity.User;

import java.util.List;

public interface UserService {
    void saveUserDetails(User user);

    List<User> findAll();
}
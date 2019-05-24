package com.yuyuyzl.SSS.service;

import com.yuyuyzl.SSS.model.User;

import java.util.List;

public interface TestUserService {
    User getUser(int id);
    List<User> getAllUser();
    boolean addUser(User user);
}

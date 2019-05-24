package com.yuyuyzl.SSS.dao;

import com.yuyuyzl.SSS.model.User;

import java.util.List;

public interface TestUserDao {
    User getUser(int id);
    List<User> getAllUser();
    boolean addUser(User user);
}

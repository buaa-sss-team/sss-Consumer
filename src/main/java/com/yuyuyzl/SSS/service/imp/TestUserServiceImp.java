package com.yuyuyzl.SSS.service.imp;

import com.yuyuyzl.SSS.dao.TestUserDao;
import com.yuyuyzl.SSS.model.User;
import com.yuyuyzl.SSS.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserServiceImp implements TestUserService {

    @Autowired
    private TestUserDao ud;

    public User getUser(int id){
        return ud.getUser(id);
    }
    public List<User> getAllUser(){
        List<User> list = ud.getAllUser();
        return list;
    }
    public boolean addUser(User user){
        if (ud.addUser(user))
            return true;
        else return false;
    }
}

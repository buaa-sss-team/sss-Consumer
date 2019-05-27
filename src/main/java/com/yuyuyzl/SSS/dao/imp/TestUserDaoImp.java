package com.yuyuyzl.SSS.dao.imp;

import com.yuyuyzl.SSS.dao.TestUserDao;
import com.yuyuyzl.SSS.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TestUserDaoImp implements TestUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public User getUser(int id){
        User user =(User) sessionFactory.getCurrentSession().get(User.class,id);
        return user;
    }

    public List<User> getAllUser(){
        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public boolean addUser(User user){
        sessionFactory.getCurrentSession().save(user);
        return true;
    }
}

package com.cms.service.user;

import javax.mail.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cms.dao.user.UserDao;
import com.cms.model.user.User;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;

    
    @Override
    public boolean saveUser(User user) {
        User userR = userDao.saveUser(user);
        return userR!=null?true:false;
    }

}

package com.cms.dao.user;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cms.model.user.User;
import com.cms.utils.ServiceObject;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    HttpServletRequest     request;

    private static Logger  logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public User saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            logger.error("Error while registering user", e);
            try {
                if (session != null && session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
            } catch (Exception ee) {
                logger.error("Error while closing session", e);
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = null;
            }
        }

        return user;
    }
}

package com.example.ss19.repository;


import com.example.ss19.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    public void delete(Integer id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public List<User> findByName(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User where firstName like :name or lastName like :name", User.class)
                .setParameter("name", "%" + name + "%")
                .list();
    }
}

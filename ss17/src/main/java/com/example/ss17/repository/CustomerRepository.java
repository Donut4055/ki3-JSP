package com.example.ss17.repository;


import com.example.ss17.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    public Customer findByUsername(String username) {
        String hql = "FROM Customer WHERE username = :username";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Customer.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    public Customer findByEmail(String email) {
        String hql = "FROM Customer WHERE email = :email";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Customer.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    public void update(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    public Customer findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    public List<Customer> findAllWithPagination(int page, int size, String search) {
        String hql = "FROM Customer WHERE (:search IS NULL OR :search = '' OR username LIKE :searchPattern OR email LIKE :searchPattern) ORDER BY id DESC";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Customer.class)
                .setParameter("search", search)
                .setParameter("searchPattern", search != null ? "%" + search + "%" : null)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public long countWithSearch(String search) {
        String hql = "SELECT COUNT(*) FROM Customer WHERE (:search IS NULL OR :search = '' OR username LIKE :searchPattern OR email LIKE :searchPattern)";
        return (Long) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter("search", search)
                .setParameter("searchPattern", search != null ? "%" + search + "%" : null)
                .uniqueResult();
    }

    public long countAll() {
        String hql = "SELECT COUNT(*) FROM Customer";
        return (Long) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .uniqueResult();
    }
}


package com.example.ss17.repository;


import com.example.ss17.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> findAll() {
        String hql = "FROM Product";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Product.class)
                .getResultList();
    }

    public Product findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    public void delete(Integer id) {
        Product product = findById(id);
        if (product != null) {
            sessionFactory.getCurrentSession().delete(product);
        }
    }

    public List<Product> findAllWithPagination(int page, int size, String search) {
        String hql = "FROM Product WHERE (:search IS NULL OR :search = '' OR productName LIKE :searchPattern) ORDER BY id DESC";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Product.class)
                .setParameter("search", search)
                .setParameter("searchPattern", search != null ? "%" + search + "%" : null)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public long countWithSearch(String search) {
        String hql = "SELECT COUNT(*) FROM Product WHERE (:search IS NULL OR :search = '' OR productName LIKE :searchPattern)";
        return (Long) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter("search", search)
                .setParameter("searchPattern", search != null ? "%" + search + "%" : null)
                .uniqueResult();
    }

    public long countAll() {
        String hql = "SELECT COUNT(*) FROM Product";
        return (Long) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .uniqueResult();
    }
}


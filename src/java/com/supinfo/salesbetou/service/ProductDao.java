/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.service;

import com.supinfo.salesbetou.entity.Customer;
import com.supinfo.salesbetou.entity.Product;
import com.supinfo.salesbetou.entity.Product_;
import com.supinfo.salesbetou.entity.Sale;
import com.supinfo.salesbetou.entity.Sale_;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yannick
 */
@Stateless
public class ProductDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public Product addProduct(Product product) {
        em.persist(product);
        return product;
    }

    public List<Product> getAllProducts() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        
        
        Root<Product> product = query.from(Product.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        query.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        List<Product> result = null;
        
        TypedQuery<Product> realQuery = em.createQuery(query);
        realQuery.setMaxResults(50);
        try {
            result = realQuery.getResultList();
        } finally {
            return result;	
        }
    }

    public Product findProductById(Long productId) {
        return em.find(Product.class, productId);
    }

    public void removeProduct(Product product) {
        em.remove(product);
    }

    public List getBestSellingProducts(Map<String, String> filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Product> product = cq.from(Product.class);
        Join<Product, Sale> sale = product.join(Product_.sales, JoinType.LEFT);
        Join<Sale, Customer> customer = sale.join(Sale_.customer, JoinType.LEFT);
        
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (filter.get("country") != null) {
            predicates.add(cb.or(cb.equal(customer.get("country"), Long.valueOf(filter.get("country"))), cb.isNull(sale.get("id"))));
        }
        if (filter.get("gender") != null) {
            predicates.add(cb.or(cb.equal(customer.get("gender"), filter.get("gender")), cb.isNull(sale.get("id"))));
        }
        if (filter.get("maritalstatus") != null) {
            predicates.add(cb.or(cb.equal(customer.get("maritalStatus"), filter.get("maritalstatus")), cb.isNull(sale.get("id"))));
        }
        if (filter.get("incomelevel") != null) {
            predicates.add(cb.or(cb.equal(customer.get("incomeLevel"), filter.get("incomelevel")), cb.isNull(sale.get("id"))));
        }
        
        cq.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        Expression<BigDecimal> sum = cb.sum(sale.get(Sale_.amountSold));
        Expression<Long> count = cb.count(sale.get(Sale_.id));
        cq.multiselect(product ,sum, count);
        cq.groupBy(product.get("id"));
        cq.orderBy(cb.desc(count),cb.desc(sum));
        
        TypedQuery<Object[]> query = em.createQuery(cq);
        query.setMaxResults(10);
        return query.getResultList();
    }
    
    public List getLessSoldProducts(Map<String, String> filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Product> product = cq.from(Product.class);
        Join<Product, Sale> sale = product.join(Product_.sales, JoinType.LEFT);
        Join<Sale, Customer> customer = sale.join(Sale_.customer, JoinType.LEFT);
        
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (filter.get("country") != null) {
            predicates.add(cb.or(cb.equal(customer.get("country"), Long.valueOf(filter.get("country"))), cb.isNull(sale.get("id"))));
        }
        if (filter.get("gender") != null) {
            predicates.add(cb.or(cb.equal(customer.get("gender"), filter.get("gender")), cb.isNull(sale.get("id"))));
        }
        if (filter.get("maritalstatus") != null) {
            predicates.add(cb.or(cb.equal(customer.get("maritalStatus"), filter.get("maritalstatus")), cb.isNull(sale.get("id"))));
        }
        if (filter.get("incomelevel") != null) {
            predicates.add(cb.or(cb.equal(customer.get("incomeLevel"), filter.get("incomelevel")), cb.isNull(sale.get("id"))));
        }
        
        cq.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        Expression<BigDecimal> sum = cb.sum(sale.get(Sale_.amountSold));
        Expression<Long> count = cb.count(sale.get(Sale_.id));
        cq.multiselect(product ,sum, count);
        cq.groupBy(product.get("id"));
        cq.orderBy(cb.asc(count),cb.asc(sum));
        
        TypedQuery<Object[]> query = em.createQuery(cq);
        query.setMaxResults(10);
        return query.getResultList();
    }
}

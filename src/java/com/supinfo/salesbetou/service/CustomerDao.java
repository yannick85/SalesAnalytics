/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.service;

import com.supinfo.salesbetou.entity.Customer;
import com.supinfo.salesbetou.entity.Customer_;
import com.supinfo.salesbetou.entity.Sale;
import com.supinfo.salesbetou.entity.Sale_;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class CustomerDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public Customer addCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        
        
        Root<Customer> customer = query.from(Customer.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        query.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        List<Customer> result = null;
        
        TypedQuery<Customer> realQuery = em.createQuery(query);
        realQuery.setMaxResults(50);
        try {
            result = realQuery.getResultList();
        } finally {
            return result;	
        }
    }

    public Customer findCustomerById(Long customerId) {
        return em.find(Customer.class, customerId);
    }

    public void removeCustomer(Customer customer) {
        em.remove(customer);
    }
    
    public List<String> getGenders() {
        Query query = em.createQuery("SELECT DISTINCT(c.gender) AS e FROM Customer c");
        query.setMaxResults(50);
        return query.getResultList();
    }
    
    public List<String> getMaritalStatus() {
        Query query = em.createQuery("SELECT DISTINCT(c.maritalStatus) AS e FROM Customer c ORDER BY e");
        query.setMaxResults(50);
        return query.getResultList();
    }
    
    public List<String> getIncomeLevels() {
        Query query = em.createQuery("SELECT DISTINCT(c.incomeLevel) AS e FROM Customer c ORDER BY e");
        query.setMaxResults(50);
        return query.getResultList();
    }
    
    public List getBreakDownByGender(Map<String,String> filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Customer> customer = cq.from(Customer.class);
        Join<Customer, Sale> sale = customer.join(Customer_.sales, JoinType.LEFT);
        
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
        cq.multiselect(customer.get("gender") ,sum, count);
        cq.groupBy(customer.get("gender"));
        cq.orderBy(cb.desc(sum));
        
        TypedQuery<Object[]> query = em.createQuery(cq);
        query.setMaxResults(100);
        return query.getResultList();
    }
    
    public List getBreakDownByMaritalstatus(Map<String,String> filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Customer> customer = cq.from(Customer.class);
        Join<Customer, Sale> sale = customer.join(Customer_.sales, JoinType.LEFT);
        
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
        cq.multiselect(customer.get("maritalStatus") ,sum, count);
        cq.groupBy(customer.get("maritalStatus"));
        cq.orderBy(cb.desc(sum));
        
        TypedQuery<Object[]> query = em.createQuery(cq);
        query.setMaxResults(100);
        return query.getResultList();
    }
    
    public List getBreakDownByIncomelevel(Map<String,String> filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Customer> customer = cq.from(Customer.class);
        Join<Customer, Sale> sale = customer.join(Customer_.sales, JoinType.LEFT);
        
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
        cq.multiselect(customer.get("incomeLevel") ,sum, count);
        cq.groupBy(customer.get("incomeLevel"));
        cq.orderBy(cb.desc(sum));
        
        TypedQuery<Object[]> query = em.createQuery(cq);
        query.setMaxResults(100);
        return query.getResultList();
    }
    
    public List getBestCustomers(Map<String,String> filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Customer> customer = cq.from(Customer.class);
        Join<Customer, Sale> sale = customer.join(Customer_.sales, JoinType.LEFT);
        
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
        cq.multiselect(customer ,sum, count);
        cq.groupBy(customer.get("id"));
        cq.orderBy(cb.desc(sum));
        
        TypedQuery<Object[]> query = em.createQuery(cq);
        query.setMaxResults(10);
        return query.getResultList();
    }
}

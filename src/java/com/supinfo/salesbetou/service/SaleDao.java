/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.service;

import com.supinfo.salesbetou.entity.Customer;
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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yannick
 */
@Stateless
public class SaleDao {
    
    @PersistenceContext
    private EntityManager em;

    public Sale addSale(Sale sale) {
        em.persist(sale);
        return sale;
    }

    public List<Sale> getAllSales() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sale> query = cb.createQuery(Sale.class);
        
        
        Root<Sale> sale = query.from(Sale.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        query.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        List<Sale> result = null;
        
        TypedQuery<Sale> realQuery = em.createQuery(query);
        realQuery.setMaxResults(50);
        try {
            result = realQuery.getResultList();
        } finally {
            return result;	
        }
    }

    public Sale findSaleById(Long saleId) {
        return em.find(Sale.class, saleId);
    }

    public void removeSale(Sale sale) {
        em.remove(sale);
    }

    public Long getNumberOfSales(Map<String, String> filter){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sale> sale = cq.from(Sale.class);
        Join<Sale, Customer> customer = sale.join(Sale_.customer);
        
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (filter.get("country") != null) {
            predicates.add(cb.equal(customer.get("country"), Long.valueOf(filter.get("country"))));
        }
        if (filter.get("gender") != null) {
            predicates.add(cb.equal(customer.get("gender"), filter.get("gender")));
        }
        if (filter.get("maritalstatus") != null) {
            predicates.add(cb.equal(customer.get("maritalStatus"), filter.get("maritalstatus")));
        }
        if (filter.get("incomelevel") != null) {
            predicates.add(cb.equal(customer.get("incomeLevel"), filter.get("incomelevel")));
        }
        
        cq.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        cq.select(cb.count(sale.get(Sale_.id)));
        return em.createQuery(cq).getSingleResult();
    }
    
    public BigDecimal getTotalAmount(Map<String, String> filter){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> cq = cb.createQuery(BigDecimal.class);
        Root<Sale> sale = cq.from(Sale.class);
        Join<Sale, Customer> customer = sale.join(Sale_.customer);
        
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (filter.get("country") != null) {
            predicates.add(cb.equal(customer.get("country"), Long.valueOf(filter.get("country"))));
        }
        if (filter.get("gender") != null) {
            predicates.add(cb.equal(customer.get("gender"), filter.get("gender")));
        }
        if (filter.get("maritalstatus") != null) {
            predicates.add(cb.equal(customer.get("maritalStatus"), filter.get("maritalstatus")));
        }
        if (filter.get("incomelevel") != null) {
            predicates.add(cb.equal(customer.get("incomeLevel"), filter.get("incomelevel")));
        }
        
        cq.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        cq.select(cb.sum(sale.get(Sale_.amountSold)));
        return em.createQuery(cq).getSingleResult();
    }
    
    public List<Sale> getSalesByCountry(Long countryId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sale> cq = cb.createQuery(Sale.class);
        Root<Sale> sale = cq.from(Sale.class);
        Join<Sale, Customer> customer = sale.join(Sale_.customer);
        
        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.equal(customer.get("country"), countryId));
        
        cq.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        cq.orderBy(cb.desc(sale.get("time")));
        
        TypedQuery<Sale> query = em.createQuery(cq);
        query.setMaxResults(100);
        return query.getResultList();
    }
}

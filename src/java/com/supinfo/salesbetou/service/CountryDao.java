/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.service;

import com.supinfo.salesbetou.entity.Country;
import com.supinfo.salesbetou.entity.Country_;
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
public class CountryDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public Country addCountry(Country country) {
        em.persist(country);
        return country;
    }

    public List<Country> getAllCountries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Country> query = cb.createQuery(Country.class);
        
        
        Root<Country> country = query.from(Country.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        query.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        List<Country> result = null;
        
        query.orderBy(cb.asc(country.get("name")));
        
        TypedQuery<Country> realQuery = em.createQuery(query);
        realQuery.setMaxResults(150);
        try {
            result = realQuery.getResultList();
        } finally {
            return result;	
        }
    }

    public Country findCountryById(Long countryId) {
        return em.find(Country.class, countryId);
    }

    public void removeCountry(Country country) {
        em.remove(country);
    }
    
    public List getBreadkdownByCountry(Map<String, String> filter){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Country> country = cq.from(Country.class);
        Join<Country, Customer> customer = country.join(Country_.customers, JoinType.LEFT);
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
        cq.multiselect(country ,sum, count);
        cq.groupBy(country.get("id"));
        cq.orderBy(cb.desc(sum));
        
        TypedQuery<Object[]> query = em.createQuery(cq);
        query.setMaxResults(100);
        return query.getResultList();
    }
}

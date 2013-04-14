/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.service;

import com.supinfo.salesbetou.entity.User;
import com.supinfo.salesbetou.util.CryptUtil;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yannick
 */
@Stateless
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public User addUser(User user) {
        em.persist(user);
        return user;
    }

    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    public User findUserById(Long userId) {
        return em.find(User.class, userId);
    }

    public void removeUser(User user) {
        em.remove(user);
    }
    public User userExist(String name,String password) {
        password = CryptUtil.md5(password);
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);

        Root<User> user = query.from(User.class);


        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(user.get("name"), name));
        predicates.add(cb.equal(user.get("password"), password));

        query.where(
            predicates.toArray(new Predicate[predicates.size()])
        );
        
        User result = null;
        
        try {
            result = em.createQuery(query).getSingleResult();
        }finally{
            return result;	
        }
    }
}

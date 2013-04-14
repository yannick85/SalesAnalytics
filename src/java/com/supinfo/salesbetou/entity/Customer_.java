/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Yannick
 */
@StaticMetamodel(Customer.class)
public class Customer_ {
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile ListAttribute<Customer, Sale> sales;
}

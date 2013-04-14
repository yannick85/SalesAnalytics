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
@StaticMetamodel(Country.class)
public class Country_ {
    public static volatile SingularAttribute<Country, Long> id;
    public static volatile ListAttribute<Country, Customer> customers;
}


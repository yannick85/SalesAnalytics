/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.salesbetou.entity;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Yannick
 */
@StaticMetamodel(Sale.class)
public class Sale_ {
    public static volatile SingularAttribute<Sale, Long> id;
    public static volatile SingularAttribute<Sale, Long> product;
    public static volatile SingularAttribute<Sale, Customer> customer;
    public static volatile SingularAttribute<Sale, Date> time;
    public static volatile SingularAttribute<Sale, Channel> channel;
    public static volatile SingularAttribute<Sale, Promotion> promotion;
    public static volatile SingularAttribute<Sale, BigDecimal> quantitySold;
    public static volatile SingularAttribute<Sale, BigDecimal> amountSold;
}
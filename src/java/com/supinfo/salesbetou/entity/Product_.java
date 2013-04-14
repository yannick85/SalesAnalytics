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
@StaticMetamodel(Product.class)
public class Product_ {
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile ListAttribute<Product, Sale> sales;
}

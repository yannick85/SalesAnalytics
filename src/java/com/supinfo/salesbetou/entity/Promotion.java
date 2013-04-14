package com.supinfo.salesbetou.entity;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yannick
 */
@Entity
@Table(name="promotions")
@XmlRootElement
public class Promotion {
    @Column(name="PROMO_ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="PROMO_NAME")
    private String name;
    @Column(name="PROMO_SUBCATEGORY")
    private String subcategory;
    @Column(name="PROMO_SUBCATEGORY_ID")
    private Integer subcategoryId;
    @Column(name="PROMO_CATEGORY")
    private String category;
    @Column(name="PROMO_CATEGORY_ID")
    private Integer categoryId;
    @Column(name="PROMO_COST")
    private BigDecimal cost;
    @Column(name="PROMO_BEGIN_DATE")
    private Date beginDate;
    @Column(name="PROMO_END_DATE")
    private Date endDate;
    @Column(name="PROMO_TOTAL")
    private String total;
    @Column(name="PROMO_TOTAL_ID")
    private BigDecimal totalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public BigDecimal getTotalId() {
        return totalId;
    }

    public void setTotalId(BigDecimal totalId) {
        this.totalId = totalId;
    }
}

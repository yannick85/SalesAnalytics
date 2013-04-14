package com.supinfo.salesbetou.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yannick
 */
@Entity
@Table(name="products")
@XmlRootElement
public class Product {
    @Column(name="PROD_ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="PROD_NAME")
    private String name;
    @Column(name="PROD_DESC")
    private String desc;
    @Column(name="PROD_SUBCATEGORY")
    private String subcategory;
    @Column(name="PROD_SUBCATEGORY_ID")
    private Integer subcategoryId;
    @Column(name="PROD_SUBCATEGORY_DESC")
    private String subcategoryDesc;
    @Column(name="PROD_CATEGORY")
    private String category;
    @Column(name="PROD_CATEGORY_ID")
    private Integer categoryId;
    @Column(name="PROD_CATEGORY_DESC")
    private String categoryDesc;
    @Column(name="PROD_WEIGHT_CLASS")
    private BigDecimal weightClass;
    @Column(name="PROD_UNIT_OF_MEASURE")
    private String unitOfMeasure;
    @Column(name="PROD_PACK_SIZE")
    private String packSize;
    @Column(name="SUPPLIER_ID")
    private BigDecimal supplierId;
    @Column(name="PROD_STATUS")
    private String status;
    @Column(name="PROD_LIST_PRICE")
    private BigDecimal listPrice;
    @Column(name="PROD_MIN_PRICE")
    private BigDecimal minPrice;
    @Column(name="PROD_TOTAL")
    private String total;
    @Column(name="PROD_TOTAL_ID")
    private Integer totalId;
    @Column(name="PROD_SRC_ID")
    private Integer srcId;
    @Column(name="PROD_EFF_FROM")
    private Date effFrom;
    @Column(name="PROD_EFF_TO")
    private Date effTo;
    @Column(name="PROD_VALID")
    private String valid;
    @OneToMany(mappedBy="product")
    private List<Sale> sales;

    @XmlTransient
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getSubcategoryDesc() {
        return subcategoryDesc;
    }

    public void setSubcategoryDesc(String subcategoryDesc) {
        this.subcategoryDesc = subcategoryDesc;
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

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public BigDecimal getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(BigDecimal weightClass) {
        this.weightClass = weightClass;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public BigDecimal getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigDecimal supplierId) {
        this.supplierId = supplierId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getTotalId() {
        return totalId;
    }

    public void setTotalId(Integer totalId) {
        this.totalId = totalId;
    }

    public Integer getSrcId() {
        return srcId;
    }

    public void setSrcId(Integer srcId) {
        this.srcId = srcId;
    }

    public Date getEffFrom() {
        return effFrom;
    }

    public void setEffFrom(Date effFrom) {
        this.effFrom = effFrom;
    }

    public Date getEffTo() {
        return effTo;
    }

    public void setEffTo(Date effTo) {
        this.effTo = effTo;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}

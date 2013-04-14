package com.supinfo.salesbetou.entity;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yannick
 */
@Entity
@Table(name="sales")
@XmlRootElement
public class Sale {
    @Column(name="SALE_ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="PROD_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name="CUST_ID")
    private Customer customer;
    @Column(name="TIME_ID")
    private Date time;
    @ManyToOne
    @JoinColumn(name="CHANNEL_ID")
    private Channel channel;
    @ManyToOne
    @JoinColumn(name="PROMO_ID")
    private Promotion promotion;
    @Column(name="QUANTITY_SOLD")
    private BigDecimal quantitySold;
    @Column(name="AMOUNT_SOLD")
    private BigDecimal amountSold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public BigDecimal getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(BigDecimal quantitySold) {
        this.quantitySold = quantitySold;
    }

    public BigDecimal getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(BigDecimal amountSold) {
        this.amountSold = amountSold;
    }
    
}

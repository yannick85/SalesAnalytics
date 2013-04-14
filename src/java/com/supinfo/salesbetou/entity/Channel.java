package com.supinfo.salesbetou.entity;

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
@Table(name="channels")
@XmlRootElement
public class Channel {
    @Column(name="CHANNEL_ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="CHANNEL_DESC")
    private String desc;
    @Column(name="CHANNEL_CLASS")
    private String channelClass;
    @Column(name="CHANNEL_CLASS_ID")
    private Integer channelClassId;
    @Column(name="CHANNEL_TOTAL")
    private String total;
    @Column(name="CHANNEL_TOTAL_ID")
    private Integer totalId;
    @OneToMany(mappedBy="channel")
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getChannelClass() {
        return channelClass;
    }

    public void setChannelClass(String channelClass) {
        this.channelClass = channelClass;
    }

    public Integer getChannelClassId() {
        return channelClassId;
    }

    public void setChannelClassId(Integer channelClassId) {
        this.channelClassId = channelClassId;
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
}

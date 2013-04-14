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
@Table(name="countries")
@XmlRootElement
public class Country {
    @Column(name="COUNTRY_ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="COUNTRY_ISO_CODE")
    private String isoCode;
    @Column(name="COUNTRY_NAME")
    private String name;
    @Column(name="COUNTRY_SUBREGION")
    private String subregion;
    @Column(name="COUNTRY_SUBREGION_ID")
    private Integer subregionId;
    @Column(name="COUNTRY_REGION")
    private String region;
    @Column(name="COUNTRY_REGION_ID")
    private Integer regionId;
    @Column(name="COUNTRY_TOTAL")
    private String total;
    @Column(name="COUNTRY_TOTAL_ID")
    private Integer totalId;
    @Column(name="COUNTRY_NAME_HIST")
    private String nameHist;
    @OneToMany(mappedBy="country")
    private List<Customer> customers;

    @XmlTransient
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Integer getSubregionId() {
        return subregionId;
    }

    public void setSubregionId(Integer subregionId) {
        this.subregionId = subregionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
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

    public String getNameHist() {
        return nameHist;
    }

    public void setNameHist(String nameHist) {
        this.nameHist = nameHist;
    }
}

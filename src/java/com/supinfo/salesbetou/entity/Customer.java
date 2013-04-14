package com.supinfo.salesbetou.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yannick
 */
@Entity
@Table(name="customers")
@XmlRootElement
public class Customer {
    @Column(name="CUST_ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="CUST_FIRST_NAME")
    private String firstName;
    @Column(name="CUST_LAST_NAME")
    private String lastName;
    @Column(name="CUST_GENDER")
    private String gender;
    @Column(name="CUST_YEAR_OF_BIRTH")
    private BigDecimal yearOfBirth;
    @Column(name="CUST_MARITAL_STATUS")
    private String maritalStatus;
    @Column(name="CUST_STREET_ADDRESS")
    private String streetAddress;
    @Column(name="CUST_POSTAL_CODE")
    private String postalCode;
    @Column(name="CUST_CITY")
    private String city;
    @Column(name="CUST_CITY_ID")
    private Integer cityId;
    @Column(name="CUST_STATE_PROVINCE")
    private String stateProvince;
    @Column(name="CUST_STATE_PROVINCE_ID")
    private Integer stateProvinceId;
    @ManyToOne
    @JoinColumn(name="COUNTRY_ID")
    private Country country;
    @Column(name="CUST_MAIN_PHONE_NUMBER")
    private String mainPhoneNumber;
    @Column(name="CUST_INCOME_LEVEL")
    private String incomeLevel;
    @Column(name="CUST_CREDIT_LIMIT")
    private Integer creditLimit;
    @Column(name="CUST_EMAIL")
    private String email;
    @Column(name="CUST_TOTAL")
    private String total;
    @Column(name="CUST_TOTAL_ID")
    private Integer totalId;
    @Column(name="CUST_SRC_ID")
    private Integer srcId;
    @Column(name="CUST_EFF_FROM")
    private Date effFrom;
    @Column(name="CUST_EFF_TO")
    private Date effTo;
    @Column(name="CUST_VALID")
    private String valid;
    @OneToMany(mappedBy="customer")
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(BigDecimal yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Integer getStateProvinceId() {
        return stateProvinceId;
    }

    public void setStateProvinceId(Integer stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getMainPhoneNumber() {
        return mainPhoneNumber;
    }

    public void setMainPhoneNumber(String mainPhoneNumber) {
        this.mainPhoneNumber = mainPhoneNumber;
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

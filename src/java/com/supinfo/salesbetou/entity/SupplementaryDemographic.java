package com.supinfo.salesbetou.entity;

import java.math.BigDecimal;
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
@Table(name="supplementary_demographics")
@XmlRootElement
public class SupplementaryDemographic {
    @Column(name="DEMOGRAPH_ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="EDUCATION")
    private String education;
    @Column(name="OCCUPATION")
    private String occupation;
    @Column(name="HOUSEHOLD_SIZE")
    private String householdSize;
    @Column(name="YRS_RESIDENCE")
    private Integer yrsResidence;
    @Column(name="AFFINITY_CARD")
    private BigDecimal affinityCard;
    @Column(name="BULK_PACK_DISKETTES")
    private BigDecimal bulkPackDiskettes;
    @Column(name="FLAT_PANEL_MONITOR")
    private BigDecimal flatPanelMonitor;
    @Column(name="HOME_THEATER_PACKAGE")
    private BigDecimal homeTheaterPackage;
    @Column(name="BOOKKEEPING_APPLICATION")
    private BigDecimal bookkeepingApplication;
    @Column(name="PRINTER_SUPPLIES")
    private BigDecimal printerSupplies;
    @Column(name="Y_BOX_GAMES")
    private BigDecimal yBoxGames;
    @Column(name="OS_DOC_SET_KANJI")
    private BigDecimal osDocSetKanji;
    @Column(name="COMMENTS")
    private String comments;
    @ManyToOne
    @JoinColumn(name="CUST_ID")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHouseholdSize() {
        return householdSize;
    }

    public void setHouseholdSize(String householdSize) {
        this.householdSize = householdSize;
    }

    public Integer getYrsResidence() {
        return yrsResidence;
    }

    public void setYrsResidence(Integer yrsResidence) {
        this.yrsResidence = yrsResidence;
    }

    public BigDecimal getAffinityCard() {
        return affinityCard;
    }

    public void setAffinityCard(BigDecimal affinityCard) {
        this.affinityCard = affinityCard;
    }

    public BigDecimal getBulkPackDiskettes() {
        return bulkPackDiskettes;
    }

    public void setBulkPackDiskettes(BigDecimal bulkPackDiskettes) {
        this.bulkPackDiskettes = bulkPackDiskettes;
    }

    public BigDecimal getFlatPanelMonitor() {
        return flatPanelMonitor;
    }

    public void setFlatPanelMonitor(BigDecimal flatPanelMonitor) {
        this.flatPanelMonitor = flatPanelMonitor;
    }

    public BigDecimal getHomeTheaterPackage() {
        return homeTheaterPackage;
    }

    public void setHomeTheaterPackage(BigDecimal homeTheaterPackage) {
        this.homeTheaterPackage = homeTheaterPackage;
    }

    public BigDecimal getBookkeepingApplication() {
        return bookkeepingApplication;
    }

    public void setBookkeepingApplication(BigDecimal bookkeepingApplication) {
        this.bookkeepingApplication = bookkeepingApplication;
    }

    public BigDecimal getPrinterSupplies() {
        return printerSupplies;
    }

    public void setPrinterSupplies(BigDecimal printerSupplies) {
        this.printerSupplies = printerSupplies;
    }

    public BigDecimal getyBoxGames() {
        return yBoxGames;
    }

    public void setyBoxGames(BigDecimal yBoxGames) {
        this.yBoxGames = yBoxGames;
    }

    public BigDecimal getOsDocSetKanji() {
        return osDocSetKanji;
    }

    public void setOsDocSetKanji(BigDecimal osDocSetKanji) {
        this.osDocSetKanji = osDocSetKanji;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

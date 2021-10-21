package com.tw.sellsoftware.software.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SoftwareInfo {
    private Integer id;

    private String softwareName;

    private BigDecimal softwarePrice;

    private String softwareDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName == null ? null : softwareName.trim();
    }

    public BigDecimal getSoftwarePrice() {
        return softwarePrice;
    }

    public void setSoftwarePrice(BigDecimal softwarePrice) {
        this.softwarePrice = softwarePrice;
    }

    public String getSoftwareDescribe() {
        return softwareDescribe;
    }

    public void setSoftwareDescribe(String softwareDescribe) {
        this.softwareDescribe = softwareDescribe == null ? null : softwareDescribe.trim();
    }
}
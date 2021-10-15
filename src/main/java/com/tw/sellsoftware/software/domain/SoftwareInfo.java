package com.tw.sellsoftware.software.domain;

import java.math.BigDecimal;

public class SoftwareInfo {

    private String id;
    private String softwareName;
    private BigDecimal softwarePrice;
    private String softwareDescribe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
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
        this.softwareDescribe = softwareDescribe;
    }
}

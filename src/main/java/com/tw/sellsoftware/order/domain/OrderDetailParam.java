package com.tw.sellsoftware.order.domain;

import java.math.BigDecimal;

public class OrderDetailParam {

    private Integer softwareId;

    private BigDecimal softwarePrice;

    public Integer getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(Integer softwareId) {
        this.softwareId = softwareId;
    }

    public BigDecimal getSoftwarePrice() {
        return softwarePrice;
    }

    public void setSoftwarePrice(BigDecimal softwarePrice) {
        this.softwarePrice = softwarePrice;
    }
}
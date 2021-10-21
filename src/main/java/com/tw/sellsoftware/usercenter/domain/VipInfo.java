package com.tw.sellsoftware.usercenter.domain;

import java.math.BigDecimal;
import java.util.Date;

public class VipInfo {
    private Integer id;

    private String vipGrade;

    private BigDecimal discount;

    private String vipDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(String vipGrade) {
        this.vipGrade = vipGrade == null ? null : vipGrade.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getVipDesc() {
        return vipDesc;
    }

    public void setVipDesc(String vipDesc) {
        this.vipDesc = vipDesc == null ? null : vipDesc.trim();
    }
}
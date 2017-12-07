package com.baoshu.dao.model;

import java.math.BigDecimal;
import java.util.Date;

public class QueryLog {
    private String ordersNo;

    private String fundid;

    private BigDecimal useMoney;

    private Integer useAmount;

    private Integer postStr;

    private Date createDate;

    private Date updateDate;

    public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo == null ? null : ordersNo.trim();
    }

    public String getFundid() {
        return fundid;
    }

    public void setFundid(String fundid) {
        this.fundid = fundid == null ? null : fundid.trim();
    }

    public BigDecimal getUseMoney() {
        return useMoney;
    }

    public void setUseMoney(BigDecimal useMoney) {
        this.useMoney = useMoney;
    }

    public Integer getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(Integer useAmount) {
        this.useAmount = useAmount;
    }

    public Integer getPostStr() {
        return postStr;
    }

    public void setPostStr(Integer postStr) {
        this.postStr = postStr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
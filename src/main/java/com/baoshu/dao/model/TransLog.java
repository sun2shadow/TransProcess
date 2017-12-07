package com.baoshu.dao.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransLog {
    private Integer id;

    private String flag;

    private String fundid;

    private String childFundid;

    private String stkCode;

    private Integer qty;

    private BigDecimal price;

    private String market;

    private String qsflag;

    private String lsno;

    private String devideOrderNo;

    private String ordersNo;

    private String requestId;

    private Boolean isDone;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getFundid() {
        return fundid;
    }

    public void setFundid(String fundid) {
        this.fundid = fundid == null ? null : fundid.trim();
    }

    public String getChildFundid() {
        return childFundid;
    }

    public void setChildFundid(String childFundid) {
        this.childFundid = childFundid == null ? null : childFundid.trim();
    }

    public String getStkCode() {
        return stkCode;
    }

    public void setStkCode(String stkCode) {
        this.stkCode = stkCode == null ? null : stkCode.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market == null ? null : market.trim();
    }

    public String getQsflag() {
        return qsflag;
    }

    public void setQsflag(String qsflag) {
        this.qsflag = qsflag == null ? null : qsflag.trim();
    }

    public String getLsno() {
        return lsno;
    }

    public void setLsno(String lsno) {
        this.lsno = lsno == null ? null : lsno.trim();
    }

    public String getDevideOrderNo() {
        return devideOrderNo;
    }

    public void setDevideOrderNo(String devideOrderNo) {
        this.devideOrderNo = devideOrderNo == null ? null : devideOrderNo.trim();
    }

    public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo == null ? null : ordersNo.trim();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
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
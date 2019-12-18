package com.theotherprogrammingblog.springbootservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookOrder {

    public BookOrder() {}

    public BookOrder(
            @JsonProperty Integer orderId,
            @JsonProperty Double totalAmount,
            @JsonProperty Integer totalQuantity,
            @JsonProperty String customerName,
            @JsonProperty String customerEmail) {

        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.totalQuantity = totalQuantity;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    private Integer orderId;
    private Double totalAmount;
    private Integer totalQuantity;

    private String customerName;
    private String customerEmail;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "orderId=" + orderId +
                ", totalAmount=" + totalAmount +
                ", totalQuantity=" + totalQuantity +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}

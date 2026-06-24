package com.example.demo.Customers;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customers {

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerLastname")
    private String customerLastname;

    @Id
    @Column(name = "customerId")
    private String customerId;

    @Column (name = "departmentId")
    private String departmentId;

    @Column(name = "customerMail")
    private String customerMail;

    // Constructor
    public Customers() {

    }
    public Customers(String customerName, String customerLastname, String customerId, String customerMail, String departmentId) {
        this.customerName = customerName;
        this.customerLastname = customerLastname;
        this.customerId = customerId;
        this.customerMail = customerMail;
        this.departmentId = departmentId;
    }

    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName; //
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public String getDepartmentId() {
        return departmentId;
    }
}

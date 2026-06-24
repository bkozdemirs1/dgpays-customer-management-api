package com.example.demo.CustomerResponseDto;

import java.util.List;

public class CustomerResponseDto {

    private String customerName;
    private String customerLastName;
    private String customerId;
    private String departmentAdress;
    private String departmentId;

    public CustomerResponseDto() {

    }

    public CustomerResponseDto(String customerName, String customerLastName, String customerId, String departmentAdress, String departmentId) {
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.customerId = customerId;
        this.departmentAdress = departmentAdress;
        this.departmentId = departmentId;
    }

    public void  setCustomerName(String customerName) {
        this.customerName = customerName;
    }

public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
}

public void setCustomerId(String customerId) {
        this.customerId = customerId;
}

public void setDepartmentAdress(String departmentAdress) {
        this.departmentAdress = departmentAdress;
}

public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
}

public String getCustomerName() {
        return customerName;
}

public String getCustomerLastName() {
        return customerLastName;
}

public String getCustomerId() {
        return customerId;
}

public String getDepartmentAdress() {
        return departmentAdress;
}

public String getDepartmentId() {
        return departmentId;
}

}
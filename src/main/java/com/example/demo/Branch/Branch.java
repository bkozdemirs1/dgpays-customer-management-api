package com.example.demo.Branch;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "branches")

public class Branch {

    @Id
    private String departmentId;
    private String departmentadress;

    public Branch() {

    }

    public Branch(String departmentId, String departmentadress) {
        this.departmentId = departmentId;
        this.departmentadress = departmentadress;
    }

    //Setters
    public void setDepartmentadress(String departmentadress) {
        this.departmentadress = departmentadress;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    //Getters
    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentadress() {
        return departmentadress;
    }

}
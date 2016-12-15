package com.demo.application.model;

import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;


public class Employee extends Entity {

    private String email;
    private BigDecimal employeeId;
    private String firstName;
    private String hireDate;
    private String jobId;
    private String lastName;
    private String phoneNumber;
    private BigDecimal salary;
    private BigDecimal departmentDepartmentId;


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getDepartmentDepartmentId() {
        return this.departmentDepartmentId;
    }

    public void setDepartmentDepartmentId(BigDecimal departmentDepartmentId) {
        this.departmentDepartmentId = departmentDepartmentId;
    }


}

package com.demo.application.model;

import java.util.Arrays;
import java.util.List;

import oracle.maf.api.cdm.persistence.util.EntityUtils;
import oracle.maf.api.cdm.persistence.manager.DBPersistenceManager;
import oracle.maf.api.cdm.persistence.service.ValueHolderInterface;
import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;

import com.demo.application.model.service.EmployeeService;

public class Department extends Entity {

    private BigDecimal departmentId;
    private String departmentName;
    private BigDecimal locationId;
    private BigDecimal employeeEmployeeId;

    private List<Employee> employees = createIndirectList("employees");

    private ValueHolderInterface managerHolder = createValueHolder("manager");
    private transient Employee manager;

    public BigDecimal getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(BigDecimal departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigDecimal getLocationId() {
        return this.locationId;
    }

    public void setLocationId(BigDecimal locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getEmployeeEmployeeId() {
        return this.employeeEmployeeId;
    }

    public void setEmployeeEmployeeId(BigDecimal employeeEmployeeId) {
        this.employeeEmployeeId = employeeEmployeeId;
    }


    public void setEmployees(List<Employee> employees) {
        this.employees.clear();
        this.employees.addAll(employees);
        getProviderChangeSupport().fireProviderRefresh("employees");
    }

    /**
     * This method is called when entity instance is recreated from persisted JSON string in DataSynchAction
     */
    public void setEmployees(Employee[] employees) {
        setEmployees(Arrays.asList(employees));
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }


    /**
     * This method is automatically called when using the Create operation on the employee collection
     * in the data control palette.
     *
     * Note that this method does NOT add the employee to the entity list because this method is
     * automatically called by MAF framework when using the Create operation from the data control palette.
     * MAF will add the entity to the list AFTER this method has been executed.
     *
     * You can use this method to set default values.
     * If you want to refresh data in the UI based on the size of the employee list, then you cannot do this in this
     * method because the list is not updated yet (see above), instead override method childEntityAdded and add your
     * logic there. The CDM IndirectList class ensures that this method is called after a employee has been added.
     *
     * Do NOT drag and drop this method from the data control palette, use the Create operation
     * instead to ensure that iterator binding and employee list stay in sync.
     * @param index
     * @param employee
     */
    public void addEmployee(int index, Employee employee) {
        employee.setIsNewEntity(true);
        employee.setDepartmentDepartmentId(getDepartmentId());
    }

    /**
     * This method is automatically called when using the Delete operation on the employee collection
     * in the data control palette. It deletes the corresponding row from the database (if persisted) and
     * calls the configured remove method on the remote persistence manager if applicable.
     *
     * Note that this method does NOT remove the employee from the employee list because this method is
     * automatically called by MAF framework when using the Delete operation from the data control palette.
     * MAF will remove the entity from the list AFTER this method has been executed.
     *
     * If you want to refresh data in the UI based on the size of the employee list, then you cannot do this in this
     * method because the list is not updated yet (see above), instead override method childEntityTRemoved and add your
     * logic there. The CDM IndirectList class ensures that this method is called after a employee has been added.
     *
     * Do NOT drag and drop this method from the data control palette, use the Delete operation
     * instead to ensure that iterator binding and employee list stay in sync.
     * @param employee
     */
    public void removeEmployee(Employee employee) {
        EmployeeService crudService = (EmployeeService) EntityUtils.getEntityCRUDService(employee.getClass());
        crudService.removeEmployee(employee);
    }


    public Employee getManager() {
        return (Employee) this.managerHolder.getValue();
    }

    protected ValueHolderInterface getManagerHolder() {
        return this.managerHolder;
    }

    public void setManager(Employee manager) {
        this.managerHolder.setValue(manager);
    }

    protected void setManagerHolder(ValueHolderInterface manager) {
        this.managerHolder = manager;
    }


}

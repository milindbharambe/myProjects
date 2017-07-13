/**
 * 
 */
package com.milind.springbootsample.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The Class Employee.
 *
 * @author bharamil
 */
@Entity
@Table(name = "employee")
public class Employee {

    /** The emp id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private Long empId;

    /** The name. */
    @Column(name = "name")
	private String name;

    /** The address. */
    @Column(name = "address")
    private String address;
    
    /** The company. */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "compId")
    @JsonBackReference
    private Company company;

	/**
     * Instantiates a new employee.
     */
	public Employee() {
		super();
	}

	/**
     * Instantiates a new employee.
     *
     * @param name
     *            the name
     * @param address
     *            the address
     * @param company
     *            the company
     */
    public Employee(String name, String address, Company company) {
		this();
		this.name = name;
        this.address = address;
        this.company = company;
	}

	/**
     * Gets the emp id.
     *
     * @return the empId
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * Sets the emp id.
     *
     * @param empId
     *            the empId to set
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name.
     *
     * @param name
     *            the name to set
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the company.
     *
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets the company.
     *
     * @param company
     *            the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

}

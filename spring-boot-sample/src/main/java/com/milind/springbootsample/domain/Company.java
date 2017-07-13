/**
 * 
 */
package com.milind.springbootsample.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author bharamil
 *
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "compId")
    private Long compId;

    @Column(name = "name")
	private String name;

    @Column(name = "address")
	private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Employee> employees;

	public Company() {
		super();
	}

	/**
	 * @param name
	 * @param address
	 * @param employees
	 */
    public Company(String name, String address) {
		this();
		this.name = name;
		this.address = address;
	}

	/**
     * @return the compId
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * @param compId
     *            the compId to set
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * @return the name
     */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the employees
	 */
    @JsonIgnore
    public Set<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees
	 *            the employees to set
	 */
    public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}

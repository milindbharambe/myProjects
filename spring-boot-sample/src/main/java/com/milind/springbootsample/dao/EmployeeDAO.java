/**
 * 
 */
package com.milind.springbootsample.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.milind.springbootsample.domain.Employee;

/**
 * @author bharamil
 *
 */
public interface EmployeeDAO extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    public Employee findByName(String name);
}

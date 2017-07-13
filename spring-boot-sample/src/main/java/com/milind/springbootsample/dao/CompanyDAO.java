/**
 * 
 */
package com.milind.springbootsample.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.milind.springbootsample.domain.Company;

/**
 * @author bharamil
 *
 */
public interface CompanyDAO extends CrudRepository<Company, Long> {
    
    @Override
    List<Company> findAll();

    Company findByName(String name);
    
}

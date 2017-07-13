/**
 * 
 */
package com.milind.springbootsample.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import com.milind.springbootsample.domain.Company;

/**
 * @author bharamil
 *
 */
@RestResource(path = "companyRest", rel = "companyRest")
public interface CompanyDAO extends CrudRepository<Company, Long> {
    
    @Override
    List<Company> findAll();

    Company findByName(String name);
    
}

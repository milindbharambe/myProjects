/**
 * 
 */
package com.milind.springbootsample.controllers;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.milind.springbootsample.dao.CompanyDAO;
import com.milind.springbootsample.domain.Company;

/**
 * @author bharamil
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    private Logger logger = Logger.getLogger(CompanyController.class);

    @Autowired
    private CompanyDAO companyDao;

    @RequestMapping("/getAllCompanies")
    @ResponseBody
    public List<Company> getCompanies() {
        logger.info("In company controller :: getCompanies() method!!");
        List<Company> companies = companyDao.findAll();
        return companies;
    }

    @RequestMapping("/getCompanyByName/{companyName}")
    @ResponseBody
    public Company getCompanyByName(@PathVariable String companyName) {
        logger.info("In company controller :: getCompanyByName() method!!");
        Company company = companyDao.findByName(companyName);
        return company;
    }

    @RequestMapping("/createCompany/{index}")
    @ResponseBody
    public Company createCompany(@PathVariable int index) {
        logger.info("In company controller :: createCompany() method!!");
        Company company = new Company("Away" + index, "Pune" + index);
        company = companyDao.save(company);
        return company;
    }
}

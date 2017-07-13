/**
 * 
 */
package com.milind.springbootsample.controllers;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.milind.springbootsample.dao.CompanyDAO;
import com.milind.springbootsample.dao.EmployeeDAO;
import com.milind.springbootsample.domain.Company;
import com.milind.springbootsample.domain.Employee;

/**
 * @author bharamil
 *
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    private Logger logger = Logger.getLogger(WelcomeController.class);

    @Autowired
    private CompanyDAO companyDao;

    @Autowired
    private EmployeeDAO employeeDao;

    @RequestMapping("")
    @ResponseBody
    public String welcome() {
        logger.info("In welcome controller :: welcome() method !!");
        return "Hi There, this is spring-boot-sample project !!";
    }

    @RequestMapping("/usingView/{name}")
    public String welcomeWithView(Map modelMap, @PathVariable String name) {
        logger.info("In welcome controller :: welcomeWithView() method !!");
        modelMap.put("name", name);
        return "welcome";
    }

    @PostConstruct
    public void createDummyCompany() {
        Random random = new Random();
        int index = random.nextInt(100);
        Company company = new Company("Home" + index, "Chinchwad" + index);
        // company = companyDao.save(company);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(new Employee("Milind" + index, "Bhusawal" + index, company));
        employees.add(new Employee("Priyanka" + index, "Achegaon" + index, company));
        employeeDao.save(employees);
    }

}

/**
 * 
 */
package com.milind.springbootsample.controllers;

import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/employee")
public class EmployeeController {

    private Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    private CompanyDAO companyDao;

    @Autowired
    private EmployeeDAO employeeDao;

    @RequestMapping("/getEmployeeByName/{empName}")
    @ResponseBody
    public Employee getEmployeeByName(@PathVariable String empName) {
        logger.info("In employee controller :: getEmployeeByName() method!!");
        Employee employee = employeeDao.findByName(empName);
        return employee;
    }

    @RequestMapping("/getAllEmployee")
    @ResponseBody
    public List<Employee> getAllEmployees() {
        logger.info("In employee controller :: getAllEmployees() method!!");
        List<Employee> companies = employeeDao.findAll();
        return companies;
    }

    @RequestMapping("/createEmployee/{index}")
    @ResponseBody
    public List<Employee> createEmployee(@PathVariable int index) {
        logger.info("In employee controller :: createEmployee() method!!");

        Company company = new Company("Away" + index, "Pune" + index);
        company = companyDao.save(company);

        List<Employee> employees = new ArrayList<Employee>();
        Employee emp1 = new Employee("Sonal" + index, "Bhusawal" + index, company);
        employees.add(emp1);
        Employee emp2 = new Employee("Omeshwari" + index, "Achegaon" + index, company);
        employees.add(emp2);

        employees = (List<Employee>) employeeDao.save(employees);

        return employees;
    }

}

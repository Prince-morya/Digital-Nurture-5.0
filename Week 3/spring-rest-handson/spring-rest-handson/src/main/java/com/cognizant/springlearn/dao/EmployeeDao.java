package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    private final List<Employee> employeeList;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Employee> configured = (List<Employee>) context.getBean("employeeList", List.class);
        this.employeeList = new ArrayList<>(configured);
        LOGGER.info("End");
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(employee.getId())) {
                employeeList.set(i, employee);
                LOGGER.info("End");
                return;
            }
        }
        throw new EmployeeNotFoundException(employee.getId());
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        boolean removed = employeeList.removeIf(employee -> employee.getId().equals(id));
        if (!removed) {
            throw new EmployeeNotFoundException(id);
        }
        LOGGER.info("End");
    }
}

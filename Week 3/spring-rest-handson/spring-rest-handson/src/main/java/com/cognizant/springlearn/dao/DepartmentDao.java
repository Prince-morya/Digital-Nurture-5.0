package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

    private final List<Department> departmentList;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        this.departmentList = (List<Department>) context.getBean("departmentList", List.class);
        LOGGER.info("End");
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }
}

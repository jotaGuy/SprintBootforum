package com.perscholas.caseStudy.database.dao;

import com.perscholas.caseStudy.database.entity.Customer;
import com.perscholas.caseStudy.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {




}

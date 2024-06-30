package com.springpractice.SpringPracticeDemo.service;

import com.springpractice.SpringPracticeDemo.entity.Department;
import com.springpractice.SpringPracticeDemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String departmentName);
}

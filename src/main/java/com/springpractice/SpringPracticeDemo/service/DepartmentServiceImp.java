package com.springpractice.SpringPracticeDemo.service;

import com.springpractice.SpringPracticeDemo.entity.Department;
import com.springpractice.SpringPracticeDemo.error.DepartmentNotFoundException;
import com.springpractice.SpringPracticeDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
       Department depBd = departmentRepository.findById(id).get();
       if(Objects.nonNull(department.getDepartmentName()) &&
       !"".equalsIgnoreCase(department.getDepartmentName())) {
           depBd.setDepartmentName(department.getDepartmentName());
       }

       if(Objects.nonNull(department.getDepartmentCode()) &&
       !"".equalsIgnoreCase(department.getDepartmentCode())) {
           depBd.setDepartmentCode(department.getDepartmentCode());
       }

       if (Objects.nonNull(department.getDepartmentAddress()) &&
       !"".equalsIgnoreCase(department.getDepartmentAddress())) {
           depBd.setDepartmentAddress(department.getDepartmentAddress());
       }
       return departmentRepository.save(depBd);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
       return departmentRepository.findByDepartmentName(departmentName);
    }
}

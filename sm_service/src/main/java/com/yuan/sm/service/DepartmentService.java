package com.yuan.sm.service;

import com.yuan.sm.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void remove(Integer id);
    void update(Department department);
    Department findOne(Integer id);
    List<Department> findAll();

}

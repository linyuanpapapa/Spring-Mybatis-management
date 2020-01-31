package com.yuan.sm.dao;

import com.yuan.sm.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentDao {

    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    Department selectOne(Integer id);
    List<Department> selectAll();
}

package com.yuan.sm.service.impl;

import com.yuan.sm.dao.DepartmentDao;
import com.yuan.sm.entity.Department;
import com.yuan.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void update(Department department) {
        departmentDao.update(department);
    }

    public Department findOne(Integer id) {
        return departmentDao.selectOne(id);
    }

    public List<Department> findAll() {
        return departmentDao.selectAll();
    }
}

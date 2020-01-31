package com.yuan.sm.dao;


import com.yuan.sm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffDao")
public interface StaffDao {
    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectOne(Integer id);
    List<Staff> selectAll();
}

package com.yuan.sm.service;


import com.yuan.sm.entity.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void remove(Integer id);
    void update(Staff staff);
    Staff findOne(Integer id);
    List<Staff> findAll();

}

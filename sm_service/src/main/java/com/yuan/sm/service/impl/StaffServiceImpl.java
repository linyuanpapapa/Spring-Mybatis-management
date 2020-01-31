package com.yuan.sm.service.impl;

import com.yuan.sm.dao.StaffDao;
import com.yuan.sm.entity.Staff;
import com.yuan.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    public void add(Staff staff) {
        staff.setWorkTime(new Date());
        staff.setPassword("123456");
        staff.setStatus("正常");
        staffDao.insert(staff);
    }

    public void remove(Integer id) {
        staffDao.delete(id);
    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }

    public Staff findOne(Integer id) {
        return staffDao.selectOne(id);
    }

    public List<Staff> findAll() {
        return staffDao.selectAll();
    }
}

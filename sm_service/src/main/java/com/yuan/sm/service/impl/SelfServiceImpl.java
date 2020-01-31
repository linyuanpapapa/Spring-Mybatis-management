package com.yuan.sm.service.impl;

import com.yuan.sm.dao.SelfDao;
import com.yuan.sm.dao.StaffDao;
import com.yuan.sm.entity.Staff;
import com.yuan.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfDao selfDao;
    @Autowired
    private StaffDao staffDao;

    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if(staff==null) return null;
        if(staff.getPassword().equals(password)) return staff;
        return null;
    }

    public void editPassword(Integer id, String password) {
        Staff staff = staffDao.selectOne(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}

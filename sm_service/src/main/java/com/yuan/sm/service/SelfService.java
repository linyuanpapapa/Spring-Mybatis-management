package com.yuan.sm.service;

import com.yuan.sm.entity.Staff;

public interface SelfService {
    public Staff login(String account, String password);
    public void editPassword(Integer id,String password);
}

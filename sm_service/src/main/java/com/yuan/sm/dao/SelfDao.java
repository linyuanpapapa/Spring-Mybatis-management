package com.yuan.sm.dao;

import com.yuan.sm.entity.Staff;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {
    public Staff selectByAccount(String account);
}

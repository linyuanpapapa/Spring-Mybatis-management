package com.yuan.sm.dao;

import com.yuan.sm.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("logDao")
public interface LogDao {
    void addLog(Log log);
    List<Log> selectByType(String type);
}

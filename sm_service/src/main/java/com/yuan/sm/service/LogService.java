package com.yuan.sm.service;

import com.yuan.sm.entity.Log;

import java.util.List;

public interface LogService {
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    void addOperatorLog(Log log);

    List<Log> getSystemLog();
    List<Log> getLoginLog();
    List<Log> getOperatorLog();

}

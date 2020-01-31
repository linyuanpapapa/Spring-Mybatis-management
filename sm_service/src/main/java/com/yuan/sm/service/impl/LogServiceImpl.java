package com.yuan.sm.service.impl;

import com.yuan.sm.dao.LogDao;
import com.yuan.sm.entity.Log;
import com.yuan.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    public void addSystemLog(Log log) {
        log.setOprTime(new Date());
        log.setType("system");
        logDao.addLog(log);
    }

    public void addLoginLog(Log log) {
        log.setOprTime(new Date());
        log.setType("login");
        logDao.addLog(log);
    }

    public void addOperatorLog(Log log) {
        log.setOprTime(new Date());
        log.setType("operator");
        logDao.addLog(log);
    }

    public List<Log> getSystemLog() {
        return logDao.selectByType("system");
    }

    public List<Log> getLoginLog() {
        return logDao.selectByType("login");
    }

    public List<Log> getOperatorLog() {
        return logDao.selectByType("operator");
    }
}

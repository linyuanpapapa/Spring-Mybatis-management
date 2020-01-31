package com.yuan.sm.controller;

import com.yuan.sm.entity.Log;
import com.yuan.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {
    @Autowired
    private LogService logService;

    public void operateLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list=logService.getOperatorLog();
        request.setAttribute("List",list);
        request.setAttribute("Type","操作");
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }

    public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list=logService.getSystemLog();
        request.setAttribute("List",list);
        request.setAttribute("Type","系统");
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }
    public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list=logService.getLoginLog();
        request.setAttribute("List",list);
        request.setAttribute("Type","登录");
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }
}

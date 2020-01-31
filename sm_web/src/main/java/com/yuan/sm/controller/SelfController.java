package com.yuan.sm.controller;

import com.yuan.sm.dao.SelfDao;
import com.yuan.sm.entity.Staff;
import com.yuan.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpRetryException;

@Controller("selfController")
public class SelfController {
    @Autowired
    private SelfService selfService;
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        Staff staff = selfService.login(account, password);
        if(staff==null){
            response.sendRedirect("toLogin.do");
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("USER",staff);
            response.sendRedirect("toMain.do");
        }
    }

    public void toMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("USER",null);
        response.sendRedirect("toLogin.do");
    }

    public void info(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../info.jsp").forward(request,response);
    }

    public void toChangePassword(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../changePassword.jsp").forward(request,response);
    }

    public void changePassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String password=request.getParameter("password");
        String password1=request.getParameter("password1");

        HttpSession session=request.getSession();
        Staff user =(Staff) session.getAttribute("USER");
        System.out.println(user);
        if(user.getPassword().equals(password)){
            selfService.editPassword(user.getId(),password1);
            System.out.println(user);
            //response.sendRedirect("../logout.do");
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }else{
            response.sendRedirect("toChangePassword.do");
        }

    }
}

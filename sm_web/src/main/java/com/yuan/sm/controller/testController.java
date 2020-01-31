package com.yuan.sm.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("testController")

public class testController{

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Name","yuanyuan");
        request.getRequestDispatcher("../show.jsp").forward(request,response);
    }

}

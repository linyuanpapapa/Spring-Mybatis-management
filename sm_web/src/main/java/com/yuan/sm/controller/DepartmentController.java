package com.yuan.sm.controller;

import com.yuan.sm.entity.Department;
import com.yuan.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.findAll();
        //把从数据库查到的list返回到前端
        request.setAttribute("List",list);
        //跳转到相应页面
        request.getRequestDispatcher("../department_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../department_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String address=request.getParameter("address");

        Department department=new Department();
        department.setName(name);
        department.setAddress(address);

        departmentService.add(department);

        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Department department=departmentService.findOne(id);
        request.setAttribute("OBJ",department);
        request.getRequestDispatcher("../department_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String address=request.getParameter("address");

        Department department=new Department();
        department.setId(id);
        department.setName(name);
        department.setAddress(address);

        departmentService.update(department);

        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        departmentService.remove(id);
        response.sendRedirect("list.do");
    }

}

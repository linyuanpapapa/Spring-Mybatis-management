package com.yuan.sm.controller;

import com.yuan.sm.entity.Department;
import com.yuan.sm.entity.Staff;
import com.yuan.sm.service.DepartmentService;
import com.yuan.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list=staffService.findAll();
        request.setAttribute("List",list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request,response);
    }
    //跳转到添加页面
    public void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException{
        List<Department> list=departmentService.findAll();
        request.setAttribute("DList",list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String info=request.getParameter("info");
        Integer did=Integer.parseInt(request.getParameter("did"));
        String idNumber=request.getParameter("idNumber");
        Date birthday=null;
        try {
            birthday=new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Staff staff=new Staff();
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        staff.setInfo(info);
        staff.setBirthday(birthday);
        staff.setIdNumber(idNumber);
        staff.setDid(did);

        staffService.add(staff);

        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Department> list=departmentService.findAll();
        request.setAttribute("DList",list);
        Integer id=Integer.parseInt(request.getParameter("id"));
        Staff staff=staffService.findOne(id);
        request.setAttribute("OBJ",staff);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String account=request.getParameter("account");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String info=request.getParameter("info");
        Integer did=Integer.parseInt(request.getParameter("did"));
        String idNumber=request.getParameter("idNumber");
        Date birthday=null;
        try {
            birthday=new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Staff staff=staffService.findOne(id);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        staff.setInfo(info);
        staff.setBirthday(birthday);
        staff.setIdNumber(idNumber);
        staff.setDid(did);

        staffService.update(staff);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Staff staff=staffService.findOne(id);
        request.setAttribute("OBJ",staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request,response);
    }
}

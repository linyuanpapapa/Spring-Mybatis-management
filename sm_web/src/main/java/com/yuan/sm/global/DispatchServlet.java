package com.yuan.sm.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 核心控制器
 */
public class DispatchServlet extends GenericServlet {
    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        context= new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        /*
            路径名一般有两种：/staff/add.do  或者  /login.do
         */
        String BeanName=null;
        String MethodName=null;

        String path = request.getServletPath().substring(1);

        int index=path.indexOf('/');
        if(index!=-1){
            BeanName=path.substring(0,index)+"Controller";
            MethodName=path.substring(index+1,path.indexOf(".do"));
        }else{
            BeanName="selfController";
            MethodName=path.substring(0,path.indexOf(".do"));
        }

        Object obj=context.getBean(BeanName);
        try {
            Method method = obj.getClass().getMethod(MethodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(obj,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

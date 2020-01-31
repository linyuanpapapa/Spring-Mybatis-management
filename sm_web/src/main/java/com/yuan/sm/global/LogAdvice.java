package com.yuan.sm.global;

import com.yuan.sm.entity.Log;
import com.yuan.sm.entity.Staff;
import com.yuan.sm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {
    @Autowired
    private LogService logService;
    //在指定方法完成后进行增强
    @After("execution(* com.yuan.sm.controller.*.*(..)) && !execution(* com.yuan.sm.controller.SelfController.*(..)) && !execution(* com.yuan.sm.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log=new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());

        HttpServletRequest request=(HttpServletRequest)joinPoint.getArgs()[0];
        HttpSession session=request.getSession();
        Staff staff=(Staff)session.getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult("成功");

        logService.addOperatorLog(log);
    }
    @AfterThrowing(throwing = "e",pointcut = "execution(* com.yuan.sm.controller.*.*(..))&& !execution(* com.yuan.sm.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log=new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());

        HttpServletRequest request=(HttpServletRequest)joinPoint.getArgs()[0];
        HttpSession session=request.getSession();
        Staff staff=(Staff)session.getAttribute("USER");
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());

        logService.addSystemLog(log);
    }
    @After("execution(* com.yuan.sm.controller.*.login(..))")
    public void loginLog(JoinPoint joinPoint){
        log(joinPoint);
    }
    @Before("execution(* com.yuan.sm.controller.*.logout(..))")
    public void logoutLog(JoinPoint joinPoint){
        log(joinPoint);
    }

    private void log(JoinPoint joinPoint){
        Log log=new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());

        HttpServletRequest request=(HttpServletRequest)joinPoint.getArgs()[0];
        HttpSession session=request.getSession();
        Staff staff=(Staff)session.getAttribute("USER");
        if(staff==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }else {
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }
        logService.addLoginLog(log);
    }

}

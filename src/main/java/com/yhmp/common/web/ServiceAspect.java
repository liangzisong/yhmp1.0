package com.yhmp.common.web;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yhmp.project.entity.PorjectDeclare;
import com.yhmp.project.entity.PreservationProjectVO;
import com.yhmp.project.entity.ProjectPlan;
import com.yhmp.project.entity.ProjectPreservation;
import com.yhmp.project.entity.ProjectSummary;
import com.yhmp.system.entity.User;
import com.yhmp.system.entity.UserLogs;

/**
 * 系统服务组件Aspect切面Bean
 * @author Shenghany
 */
//声明这是一个组件
@Component
//声明这是一个切面Bean
@Aspect
public class ServiceAspect {

    //private final static Log log = LogFactory.getLog(ServiceAspect.class);

    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.yhmp.*.controller..*(..))")
    public void aspect(){    }

    /*
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        Object[] obj = joinPoint.getArgs();
        System.out.println("执行before.....");
        System.out.println(joinPoint);
        System.out.println("=============================调用方法=============================");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("=============================调用类=============================");
        System.out.println(joinPoint.getTarget().getClass().getName());
        System.out.println("=============================参数列表start=============================");
        for(int i=0;i<obj.length;i++) {
            System.out.println(obj[i]);
        }
        System.out.println("=============================参数列表end=============================");
        System.out.println("=============================正常开始=============================");
        if(obj.length>=2) {
            if(obj[obj.length-1] instanceof String && obj[obj.length-2] instanceof Integer) {
                System.out.println("用户："+obj[obj.length-1]+",进入:"+obj.getClass().getName());
            }
        }
    }

    //配置后置通知,使用在方法aspect()上注册的切入点
    @After("execution(* com.yhmp.system.controller.UserLogsController.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("执行after.....");
        System.out.println(((UserLogs) joinPoint.getArgs()[0]).getUserName());
        //System.out.println(joinPoint);

    }

    //配置环绕通知,使用在方法aspect()上注册的切入点
    @Around("execution(* com.yhmp.*.controller..*(..))")
    public Object aroundAOP(ProceedingJoinPoint joinPoint){
        System.out.println("ServiceAspect.around()");
        //long start = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = joinPoint.proceed();
            System.out.println();
            System.out.println("obj="+obj);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;
      //  try {
//            try {
//            } catch (Throwable e) {
//                System.out.println("异常");
//                e.printStackTrace();
//            }
      //      long end = System.currentTimeMillis();
      //      if(log.isInfoEnabled()){
      //          log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
      //      }
      //  } catch (Throwable e) {
      //      long end = System.currentTimeMillis();
      //      if(log.isInfoEnabled()){
      //          log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
      //      }
        }
//    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("ServiceAspect.afterReturn()");
        //if(log.isInfoEnabled()){
        //    log.info("afterReturn " + joinPoint);
        //}
    }

    //配置抛出异常后通知,使用在方法aspect()上注册的切入点
    @AfterThrowing(pointcut="aspect()", throwing="ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex){
        System.out.println("ServiceAspect.afterThrow()");
        //if(log.isInfoEnabled()){
        //    log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
        //}
    }

}
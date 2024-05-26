package com.colvir.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Pointcut("execution(public void com.colvir.spring.aop.EmployeeService.print*())")
//    public void printPatternMethod() {
//
//    }
//
//    @Before("printPatternMethod()")
//    public void printPatternLogging() {
//        System.out.println("Вызван метод print*");
//    }

    @Pointcut("execution(public void com.colvir.spring.aop.EmployeeService.print*())")
    public void printPatternMethod() {}

//    @Before("execution(public void com.colvir.spring.aop.EmployeeService.print*())")
    @Before("printPatternMethod()")
    public void printPatternLogging() {
        System.out.println("@Before. Вызван метод print*");
    }
}

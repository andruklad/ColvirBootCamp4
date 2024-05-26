package com.colvir.spring.aop.aspects;

import com.colvir.spring.aop.Credentials;
import com.colvir.spring.aop.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect {

    @Around("execution(* *(com.colvir.spring.aop.Credentials, ..))")
    public Employee chkCreds(ProceedingJoinPoint proceedingJoinPoint) {

        System.out.println("@Around. Вызов метода " + proceedingJoinPoint.getSignature().getName());

        Object[] args = proceedingJoinPoint.getArgs();

        Credentials credentials = null;

        for (Object arg: args) {
            if (arg instanceof Credentials) {
                credentials = (Credentials) arg;
            }
        }

        if (credentials == null) {
            throw new RuntimeException("Ошибка извлечения данных авторизации");
        }

        if (!credentials.getPassword().equals(credentials.getConfirmPassword())) {
            throw new RuntimeException(("Пароли не совпадают!"));
        }

        Employee employee = null;

        try {
            employee = (Employee) proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        employee.setSecondName("Товарищ " + employee.getSecondName());

        return employee;
    }
}

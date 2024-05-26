package com.colvir.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

        Credentials credentials1 = new Credentials("ivan", "pass", "pass");
        System.out.println("Добавление сотрудника в список сотрудников: " + employeeService.add(credentials1, "Ivan", "Ivanov"));

        Credentials credentials2 = new Credentials("petr", "pass", "pass");
        System.out.println(employeeService.add(credentials2, "Petr", "Petrov"));

        employeeService.printAll();
        employeeService.printFirst();

        context.close();
    }
}

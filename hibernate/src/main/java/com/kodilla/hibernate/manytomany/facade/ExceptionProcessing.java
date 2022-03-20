package com.kodilla.hibernate.manytomany.facade;

public class ExceptionProcessing extends Exception {
    public static String ERR_COMPANY_NOT_FOUND = "Company not found";
    public static String ERR_EMPLOYEE_NOT_FOUND = "Employee not found";
    public static String ERR_COMPANY_AND_EMPLOYEE_NOT_FOUND = "Company & Employee not found";

    public ExceptionProcessing(String message) {
        super(message);
    }
}
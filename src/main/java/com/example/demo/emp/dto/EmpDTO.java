package com.example.demo.emp.dto;

import lombok.Data;
import java.util.Date;
@Data
public class EmpDTO {
    private int empno;
    private String ename;
    private String job;
    private int sal;
    private Date hiredate;
}
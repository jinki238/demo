package com.example.demo.emp.dto;

import lombok.Data;
import java.util.Date;
@Data
public class EmpDTO {
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private int sal;
    private Date hiredate;
    private int comm;
    private int deptno;
}
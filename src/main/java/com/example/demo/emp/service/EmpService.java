package com.example.demo.emp.service;

import java.util.List;
import com.example.demo.emp.dto.EmpDTO;

public interface EmpService {

    List<EmpDTO> getEmpList();

    EmpDTO getEmpById(int empno);

    int createEmp(EmpDTO emp);

    int updateEmp(EmpDTO emp);

    int deleteEmp(int empno);
}
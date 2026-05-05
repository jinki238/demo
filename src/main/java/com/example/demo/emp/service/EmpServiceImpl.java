package com.example.demo.emp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.emp.dto.EmpDTO;
import com.example.demo.emp.mapper.EmpMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    @Override
    public List<EmpDTO> getEmpList() {
        return empMapper.selectEmpList();
    }

    @Override
    public EmpDTO getEmpById(int empno) {
        return empMapper.selectEmpDetail(empno);
    }

    @Override
    public int createEmp(EmpDTO emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public int updateEmp(EmpDTO emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public int deleteEmp(int empno) {
        return empMapper.deleteEmp(empno);
    }
}
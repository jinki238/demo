package com.example.demo.emp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.emp.dto.EmpDTO;

@Mapper
public interface EmpMapper {

    List<EmpDTO> selectEmpList();

    EmpDTO selectEmpDetail(int empno);

    int insertEmp(EmpDTO emp);

    int updateEmp(EmpDTO emp);

    int deleteEmp(int empno);
}
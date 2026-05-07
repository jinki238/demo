package com.example.demo.emp.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.emp.dto.EmpDTO;
import com.example.demo.emp.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    // =========================
    // 전체 조회
    // GET /emp
    // =========================
    @GetMapping
    public ResponseEntity<ApiResponse<List<EmpDTO>>> getList() {
        List<EmpDTO> list = empService.getEmpList();
        return ResponseEntity.ok(
                ApiResponse.success(list)
        );
    }

    // =========================
    // 단일 조회
    // GET /emp/{empno}
    // =========================
    @GetMapping("/{empno}")
    public ResponseEntity<ApiResponse<EmpDTO>> getDetail(@PathVariable int empno) {
        EmpDTO emp = empService.getEmpById(empno);
        return ResponseEntity.ok(
                ApiResponse.success(emp)
        );
    }

    // =========================
    // 생성
    // POST /emp
    // =========================
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(@RequestBody EmpDTO emp) {
        empService.createEmp(emp);
        return ResponseEntity
                .status(201)
                .body(ApiResponse.success("사원 생성 완료", null));
    }

    // =========================
    // 수정
    // PUT /emp/{empno}
    // =========================
    @PutMapping("/{empno}")
    public ResponseEntity<ApiResponse<Void>> update(
            @PathVariable int empno,
            @RequestBody EmpDTO emp) {

        emp.setEmpno(empno);
        empService.updateEmp(emp);

        return ResponseEntity.ok(
                ApiResponse.success("사원 수정 완료", null)
        );
    }

    // =========================
    // 삭제
    // DELETE /emp/{empno}
    // =========================
    @DeleteMapping("/{empno}")
    public ResponseEntity<Void> delete(@PathVariable int empno) {
        empService.deleteEmp(empno);
        return ResponseEntity.noContent().build();
    }
}
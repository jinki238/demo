package com.example.demo.emp.controller;

import com.example.empdemo.dto.EmpDTO;
import com.example.empdemo.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    @GetMapping("/home")
    public String home(Model model) {
        return "emp/home";

    }

    @GetMapping("/list")
    public String list(Model model) {
        List<EmpDTO> list = empService.getEmpList();
        model.addAttribute("list", list);
        return "emp/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int empno, Model model) {
        EmpDTO emp=empService.getEmpById(empno);
        model.addAttribute("emp", emp);
        return "emp/detail";
    }





//    @GetMapping("/create")
//    public String createForm() {
//        return "emp/create";
//    }
//
//    @PostMapping("/create")
//    public String create(EmpDTO emp) {
//        empService.createEmp(emp);
//        return "redirect:/emp/list";
//    }
//
//    @GetMapping("/edit")
//    public String editForm(@RequestParam int empno, Model model) {
//        model.addAttribute("emp", empService.getEmpById(empno));
//        return "emp/edit";
//    }
//
//    @PostMapping("/edit")
//    public String edit(EmpDTO emp) {
//        empService.updateEmp(emp);
//        return "redirect:/emp/list";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam int empno) {
//        empService.deleteEmp(empno);
//        return "redirect:/emp/list";
//    }
}
package com.example.demo.controller;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/t1")
	public String t1(Model model) {
		List<MemberDTO> list=memberService.getMemberList();
		model.addAttribute("memberlist",list);
		return "member/t1";
	}
	@GetMapping("/t2")
	public String editMemberForm(@RequestParam("id") String id, Model model) {
		MemberDTO member = memberService.getMemberById(id);
		model.addAttribute("edit", member);
		return "member/t2";
	}
}
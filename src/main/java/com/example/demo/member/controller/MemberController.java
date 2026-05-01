package com.example.demo.member.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/main")
	public String main() {
		return "member/main";
	}

	@GetMapping("/joinform")
	public String joinform() {
		return "member/joinform";
	}

	// =========================
	// 화면 반환
	// =========================
	@GetMapping("/home")
	public String t1() {
		return "member/index";
	}

	// =========================
	// 전체 조회 (READ ALL)
	// GET /member
	// =========================
	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<ApiResponse<List<MemberDTO>>> getList() {
		List<MemberDTO> list = memberService.getMemberList();
		return ResponseEntity.ok(
				ApiResponse.success(list)
		);
	}

	// =========================
	// 단일 조회 (READ ONE)
	// GET /member/{id}
	// =========================
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ApiResponse<MemberDTO>> getMember(
			@PathVariable String id) {

		MemberDTO member = memberService.getMemberById(id);
		return ResponseEntity.ok(
				ApiResponse.success(member)
		);
	}

	// =========================
	// 생성 (CREATE)
	// POST /member
	// =========================
	@PostMapping
	@ResponseBody
	public ResponseEntity<ApiResponse<Void>> create(
			@RequestBody MemberDTO member) {

		memberService.createMember(member);
		return ResponseEntity
				.status(201) // Created
				.body(ApiResponse.success("회원 생성 완료", null));
	}

	// =========================
	// 수정 (UPDATE)
	// PUT /member/{id}
	// =========================
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ApiResponse<Void>> update(
			@PathVariable String id,
			@RequestBody MemberDTO member) {

		member.setId(id); // URL id와 동기화

		memberService.updateMember(member);
		return ResponseEntity.ok(
				ApiResponse.success("회원 수정 완료", null)
		);
	}

	// =========================
	// 삭제 (DELETE)
	// DELETE /member/{id}
	// =========================
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable String id) {

		memberService.deleteMember(id);
		return ResponseEntity.noContent().build(); // 204
	}

}
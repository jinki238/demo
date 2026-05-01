package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.MemberDTO;

public interface MemberService {

    // 회원 목록 조회
    List<MemberDTO> getMemberList();

	// 회원 상세 조회
	MemberDTO getMemberById(String id);

	// 회원 등록
	int createMember(MemberDTO member);

	// 회원 수정
	int updateMember(MemberDTO member);

	// 회원 삭제
	int deleteMember(String id);
}
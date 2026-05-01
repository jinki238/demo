package com.example.demo.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.common.exception.BusinessException;
import com.example.demo.common.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;

	// =========================
	// 회원 목록 조회
	// =========================
	@Override
	@Transactional(readOnly = true)
	public List<MemberDTO> getMemberList() {

		List<MemberDTO> list = memberMapper.selectMemberList();

		if (list == null || list.isEmpty()) {
			log.warn("회원 목록 없음");
			throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
		}

		return list;
	}

	// =========================
	// 회원 상세 조회
	// =========================
	@Override
	@Transactional(readOnly = true)
	public MemberDTO getMemberById(String id) {

		validateId(id);

		MemberDTO member = memberMapper.selectMemberDetail(id);

		if (member == null) {
			log.warn("회원 없음 id={}", id);
			throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
		}

		return member;
	}

	// =========================
	// 회원 등록
	// =========================
	@Override
	public int createMember(MemberDTO member) {

		validateMember(member);

		int result = memberMapper.insertMember(member);

		if (result == 0) {
			log.error("회원 등록 실패 member={}", member);
			throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
		}

		return result;
	}

	// =========================
	// 회원 수정
	// =========================
	@Override
	public int updateMember(MemberDTO member) {

		validateMember(member);

		int result = memberMapper.updateMember(member);

		if (result == 0) {
			log.error("회원 수정 실패 member={}", member);
			throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
		}

		return result;
	}

	// =========================
	// 회원 삭제
	// =========================
	@Override
	public int deleteMember(String id) {

		validateId(id);

		int result = memberMapper.deleteMember(id);

		if (result == 0) {
			log.error("회원 삭제 실패 id={}", id);
			throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
		}

		return result;
	}

	// =========================
	// 공통 검증 - ID
	// =========================
	private void validateId(String id) {
		if (id == null || id.trim().isEmpty()) {
			throw new BusinessException(ErrorCode.INVALID_REQUEST);
		}
	}

	// =========================
	// 공통 검증 - MEMBER
	// =========================
	private void validateMember(MemberDTO member) {

		if (member == null) {
			throw new BusinessException(ErrorCode.INVALID_REQUEST);
		}

		if (member.getId() == null || member.getId().trim().isEmpty()) {
			throw new BusinessException(ErrorCode.INVALID_REQUEST);
		}

		if (member.getPw() == null || member.getPw().trim().isEmpty()) {
			throw new BusinessException(ErrorCode.INVALID_REQUEST);
		}
	}
}
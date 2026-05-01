package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    // 회원 목록 조회
    @Override
    public List<MemberDTO> getMemberList() {
        return memberMapper.selectMemberList();
    }

	// 회원 상세 조회
	@Override
	public MemberDTO getMemberById(String id) {
		return memberMapper.selectMemberDetail(id);
	}

	// 회원 등록
	@Override
	public int createMember(MemberDTO member) {
		return memberMapper.insertMember(member);
	}

	// 회원 수정
	@Override
	public int updateMember(MemberDTO member) {
		return memberMapper.updateMember(member);
	}

	// 회원 삭제
	@Override
	public int deleteMember(String id) {
		return memberMapper.deleteMember(id);
	}
}
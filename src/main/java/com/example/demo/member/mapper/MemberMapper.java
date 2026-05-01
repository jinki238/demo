package com.example.demo.member.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

    // 회원 목록 조회
    List<MemberDTO> selectMemberList();

    // 회원 상세 조회
    MemberDTO selectMemberDetail(String id);

    // 회원 등록
    int insertMember(MemberDTO member);

    // 회원 수정
    int updateMember(MemberDTO member);

    // 회원 삭제
    int deleteMember(String id);
}
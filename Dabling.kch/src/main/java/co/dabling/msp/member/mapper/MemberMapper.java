package co.dabling.msp.member.mapper;

import java.util.List;

import co.dabling.msp.members.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();  // 전체 회원리스트 가져오기
	MemberVO memberSelect(MemberVO vo);  // 회원 1건 조회
	int memberUpdate(MemberVO vo);   //회원수정
	int dormantMember(MemberVO vo);  //휴면회원 관리
}

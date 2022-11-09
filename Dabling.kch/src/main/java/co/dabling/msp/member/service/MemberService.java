package co.dabling.msp.member.service;

import java.util.List;

import co.dabling.msp.members.vo.MemberVO;



public interface MemberService {
	List<MemberVO> MemberSelectList();  // 전체 회원리스트 가져오기
	MemberVO MemberSelect(MemberVO vo);  // 회원 1건 조회
	int MemberUpdate(MemberVO vo);   //회원수정
	int dormantMember(MemberVO vo);  //휴면회원을 일반회원으로 권한변경.
}

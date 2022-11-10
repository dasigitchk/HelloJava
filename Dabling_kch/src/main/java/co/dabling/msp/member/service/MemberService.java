package co.dabling.msp.member.service;

import java.util.List;

import co.dabling.msp.member.vo.MemberVO;

public interface MemberService {
	//회원 전체 목록
	List<MemberVO> memberList();
	//회원 한명 조회 & 로그인
	MemberVO memberSelect(int memberCode);
	//회원입력(가입)
	int memberInsert(MemberVO vo); 
	//회원수정(회원-정보수정 / 관리자-권한 변경)
	int memberUpdate(MemberVO vo);
	
	// 로그인 처리.
	MemberVO memberLogin(String email, String password); 
	
	//email 중복체크
	 boolean isMemberEmailCheck(String email); //중복되는 이메일이면 false 리턴
	 
}

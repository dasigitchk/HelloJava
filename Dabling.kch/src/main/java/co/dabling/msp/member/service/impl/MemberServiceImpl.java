package co.dabling.msp.member.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dabling.msp.common.DataSource;
import co.dabling.msp.member.mapper.MemberMapper;
import co.dabling.msp.member.service.MemberService;
import co.dabling.msp.member.service.MemberVO;


public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); //true를 안써주면 오토커밋이 안됨.
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	@Override
	public List<MemberVO> MemberSelectList() {
		// 전체회원 리스트
		return map.memberSelectList();
	}

	@Override
	public MemberVO MemberSelect(MemberVO vo) {
		// 회원 한건 조회
		return map.memberSelect(MemberVO vo);
	}

	@Override
	public int MemberUpdate(MemberVO vo) {
		// 회원정보 수정
		return map.memberUpdate(MemberVO vo);
	}

	@Override
	public int dormantMember(MemberVO vo) {
		// 휴먼회원 일반회원 전환
		return map.dormantMember(MemberVO vo);
	}
}

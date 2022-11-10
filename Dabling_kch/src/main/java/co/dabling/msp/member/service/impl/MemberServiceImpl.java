package co.dabling.msp.member.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dabling.msp.common.DataSource;
import co.dabling.msp.member.mapper.MemberMapper;
import co.dabling.msp.member.service.MemberService;
import co.dabling.msp.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> memberList() {
		return map.memberList();
	}

	@Override
	public MemberVO memberSelect(int memberCode) {
		return map.memberSelect(memberCode);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public boolean isMemberEmailCheck(String email) {
		return map.isMemberEmailCheck(email);
	}

	@Override
	public MemberVO memberLogin(String email, String password) {
		return map.memberLogin(email, password);
	}

}

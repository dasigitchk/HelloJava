package co.dabling.msp.liked.service.impl;

import org.apache.ibatis.session.SqlSession;

import co.dabling.msp.common.DataSource;
import co.dabling.msp.liked.mapper.LikedMapper;
import co.dabling.msp.liked.service.LikedService;
import co.dabling.msp.liked.vo.LikedVO;

public class LikedServiceImpl implements LikedService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private LikedMapper map = sqlSession.getMapper(LikedMapper.class);

	@Override
	public LikedVO likeCheck(int storeCode, int memberCode) {
		return map.likeCheck(storeCode, memberCode);
	}

	@Override
	public int insertLike(int storeCode, int memberCode) {
		return map.insertLike(storeCode, memberCode);
	}

	@Override
	public int updateLike(LikedVO vo) {
		return map.updateLike(vo);
	}

}

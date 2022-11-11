package co.dabling.msp.review.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dabling.msp.common.DataSource;
import co.dabling.msp.review.mapper.ReviewMapper;
import co.dabling.msp.review.service.ReviewService;
import co.dabling.msp.review.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService {
	private SqlSession SqlSession = DataSource.getInstance().openSession(true);
	private ReviewMapper map = SqlSession.getMapper(ReviewMapper.class);

	@Override
	public List<ReviewVO> ReviewList() {
		// TODO Auto-generated method stub
		return map.ReviewList();
	}

	@Override
	public int reviewInsert(ReviewVO vo) {
		// TODO Auto-generated method stub
		return map.reviewInsert(vo);
	}

}

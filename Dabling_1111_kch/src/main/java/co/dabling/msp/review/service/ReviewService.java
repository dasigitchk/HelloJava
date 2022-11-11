package co.dabling.msp.review.service;

import java.util.List;

import co.dabling.msp.review.vo.ReviewVO;

public interface ReviewService {
	List<ReviewVO> ReviewList(); //리뷰 전체 리스트 가져오기.
	int reviewInsert(ReviewVO vo);
}

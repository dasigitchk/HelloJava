package co.dabling.msp.review.mapper;

import java.util.List;

import co.dabling.msp.review.vo.ReviewVO;

public interface ReviewMapper {
	List<ReviewVO> ReviewList(); //리뷰 전체 리스트 가져오기.
	int reviewInsert(ReviewVO vo);
}

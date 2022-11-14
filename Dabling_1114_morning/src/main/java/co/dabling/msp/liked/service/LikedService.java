package co.dabling.msp.liked.service;

import co.dabling.msp.liked.vo.LikedVO;

public interface LikedService {
	LikedVO likeCheck(int storeCode, int memberCode);
	int insertLike(int storeCode, int memberCode);
	int updateLike(LikedVO vo);
}

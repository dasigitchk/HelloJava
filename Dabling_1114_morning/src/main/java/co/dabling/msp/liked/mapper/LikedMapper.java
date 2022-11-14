package co.dabling.msp.liked.mapper;

import org.apache.ibatis.annotations.Param;

import co.dabling.msp.liked.vo.LikedVO;

public interface LikedMapper {
	LikedVO likeCheck(@Param("storeCode") int storeCode, @Param("memberCode") int memberCode);
	int insertLike(@Param("storeCode")int storeCode, @Param("memberCode")int memberCode);
	int updateLike(LikedVO vo);
	
}

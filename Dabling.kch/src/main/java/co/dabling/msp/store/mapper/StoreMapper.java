package co.dabling.msp.store.mapper;

import java.util.List;

import co.dabling.msp.members.vo.MemberVO;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.storeVO;

public interface StoreMapper {
	
	List<StoreVO> storeSelectList();  // 전체 매장리스트 가져오기
	StoreVO storeSelect(StoreVO vo);  // 매장 1건 조회
	int storeUpdate(StoreVO vo);   //매장정보수정
	int storeDelete(StoreVO vo);  //매장삭제

}

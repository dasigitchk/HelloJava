package co.dabling.msp.store.service;

import java.util.List;

public interface StoreService {
	List<storeVO> StoreSelectList();  // 전체 매장리스트 가져오기
	storeVO storeSelect(storeVO vo);  // 매장 1건 조회
	int storeUpdate(storeVO vo);   //매장정보수정
	int storeDelete(storeVO vo);  //매장삭제
}

package co.dabling.msp.store.mapper;

import java.util.List;

import co.dabling.msp.store.vo.StoreVO;

public interface StoreMapper {

	List<StoreVO> storeSelectList(); // 전체 매장리스트 조회

	StoreVO storeSelect(String businessNum); // 매장 1건 조회

	int storeInsert(StoreVO vo); // 매장등록(승인신청)

	int storeUpdate(StoreVO vo); // 매장수정

	int storeDelete(String businessNum); // 매장삭제

	StoreVO storeSelectByCode(int storeCode);// 스토어코드로 매장조회하기

	int storeApproval(String businessNum); // 등록승인
}

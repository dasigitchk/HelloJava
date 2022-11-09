package co.dabling.msp.store.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.dabling.msp.common.DataSource;
import co.dabling.msp.store.mapper.StoreMapper;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.StoreVO;


public class StoreServiceImpl implements StoreService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); //true를 안써주면 오토커밋이 안됨.
	private StoreMapper map = sqlSession.getMapper(StoreMapper.class);
	@Override
	public List<StoreVO> storeSelectList() {
		// 매장 전체 조회
		return map.storeSelectList();
	}

	@Override
	public StoreVO storeSelect(StoreVO vo) {
		// 매장 한건 조회
		return map.storeSelect(StoreVO vo);
	}

	@Override
	public int storeUpdate(StoreVO vo) {
		// 매장정보 수정
		return map.storeUpdate(StoreVO vo);
	}

	@Override
	public int storeDelete(StoreVO vo) {
		// 매장삭제
		return map.storeDelete(StoreVO vo);
	}

}

package co.dabling.msp.menu.service;

import java.util.List;

import co.dabling.msp.menu.vo.MenuVO;

public interface MenuService {
	
	List<MenuVO> menuSelectList(); // 메뉴 전체조회

	List<MenuVO> menuSelect(String menuName); // 메뉴별 조회
	
	List<MenuVO> storeMenuSelect(String storeCode);	// 매장별 메뉴조회
										
	int menuInsert(MenuVO vo); // 메뉴등록
	
	int menuUpdate(MenuVO vo); // 메뉴수정
	
	int menuDelete(String menuName); //메뉴삭제

}

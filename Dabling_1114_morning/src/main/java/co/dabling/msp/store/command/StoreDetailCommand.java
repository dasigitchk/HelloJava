package co.dabling.msp.store.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.liked.service.LikedService;
import co.dabling.msp.liked.service.impl.LikedServiceImpl;
import co.dabling.msp.liked.vo.LikedVO;
import co.dabling.msp.menu.service.MenuService;
import co.dabling.msp.menu.service.impl.MenuServiceImpl;
import co.dabling.msp.menu.vo.MenuVO;
import co.dabling.msp.relpy.vo.ReplyVO;
import co.dabling.msp.relpy.service.ReplyServcie;
import co.dabling.msp.relpy.service.impl.ReplyServiceImpl;
import co.dabling.msp.review.service.ReviewService;
import co.dabling.msp.review.service.impl.ReviewServiceImpl;
import co.dabling.msp.review.vo.ReviewVO;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;

public class StoreDetailCommand implements Command {
//남미주파일
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("스토어디테일커맨드 도착");

		StoreService service = new StoreServiceImpl();
		MenuService menuService = new MenuServiceImpl();
		ReviewService reviewService = new ReviewServiceImpl();
		LikedService likeService = new LikedServiceImpl();
		ReplyServcie replyService = new ReplyServiceImpl();
		
		StoreVO store = new StoreVO();
		LikedVO like = new LikedVO();
		List<MenuVO> menuList = new ArrayList<>();
		List<ReviewVO> reviewList = new ArrayList<>();
		List<ReplyVO> replyList = new ArrayList<>();
		
		//버튼 클릭된 식당정보 받아와서 식당 및 식당별 메뉴 조회
		int storeCode = Integer.parseInt(request.getParameter("storeCode"));
		store = service.storeSelectByCode(storeCode);//식당조회
		
		//메뉴리스트조회
		menuList = menuService.storeMenuSelect(storeCode);
		
		//리뷰리스트조회
		reviewList = reviewService.reviewList("storeCode",storeCode);
		
		//리뷰 작성날짜 조회 후 시간제거하여 다시 넣기
		for(ReviewVO vo: reviewList) {
			String cutDate = vo.getReviewDate().substring(0,vo.getReviewDate().indexOf(" "));
			vo.setReviewDate(cutDate);
		}

		//리뷰답변리스트 조회
		replyList = replyService.replySelectList();
		//리뷰답변 작성날짜 조회 후 시간제거하여 다시 넣기
		for(ReplyVO vo: replyList) {
			String cutDate = vo.getReplyDate().substring(0,vo.getReplyDate().indexOf(" "));
			vo.setReplyDate(cutDate);
		}
		
		//로그인 확인 후 찜버튼 값 전달
		String likeValue =null;
		if(request.getParameter("memberCode") !=null) {
			int memberCode = Integer.parseInt(request.getParameter("memberCode"));
			likeValue = "찜하기";
			like = likeService.likeCheck(storeCode, memberCode);
			switch(like.getLikeCode()){
			case 0:
				likeValue = "찜완료";
			case 1:
				likeValue = "찜취소하기";
			}
		}

		//조회된 식당정보,메뉴정보,리뷰,찜 값 리턴
		request.setAttribute("store", store);
		request.setAttribute("menuList", menuList);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("replyList", replyList);
		request.setAttribute("likeValue", likeValue);
		
		return "store/store.tiles";
	}

}

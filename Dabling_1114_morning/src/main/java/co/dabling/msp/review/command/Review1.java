package co.dabling.msp.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.review.service.ReviewService;
import co.dabling.msp.review.service.impl.ReviewServiceImpl;
import co.dabling.msp.review.vo.ReviewVO;

public class Review1 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 리뷰입력
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		vo.setReviewNum(Integer.parseInt(request.getParameter("reviewNum")));
		vo.setReservationCode(Integer.parseInt(request.getParameter("reservationCode")));
		vo.setContent(request.getParameter("content"));
		vo.setRate(Integer.parseInt(request.getParameter("rate")));
		vo.setReviewDate(request.getParameter("reviewDate"));
		
		int n = dao.reviewInsert(vo);
		
		return "./review.do";
	}

}

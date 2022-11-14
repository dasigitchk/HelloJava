package co.dabling.msp.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;

public class ReviewForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 리뷰쓰는 폼 호출
		return "review/reviewForm.tiles";
	}
}

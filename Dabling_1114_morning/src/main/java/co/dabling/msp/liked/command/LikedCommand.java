package co.dabling.msp.liked.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.liked.service.LikedService;
import co.dabling.msp.liked.service.impl.LikedServiceImpl;
import co.dabling.msp.liked.vo.LikedVO;

public class LikedCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		LikedService service = new LikedServiceImpl();
		LikedVO like = new LikedVO();
		
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		int storeCode = Integer.parseInt(request.getParameter("storeCode"));
		like = service.likeCheck(storeCode, memberCode);
		
		String likeValue = null;
		if(like==null) {
			//라이크추가
			likeValue = "찜추가 완료";
			service.insertLike(storeCode, memberCode);
		}else {			
			switch(like.getLikeCode()) {
			case 0 ://라이크추가로 업데이트
				like.setLikeCode(1);
				service.updateLike(like);
				likeValue = "찜추가 완료";
			case 1 ://라이크삭제로 업데이트
				like.setLikeCode(0);
				service.updateLike(like);
				likeValue = "찜취소 완료";
			}
		}
		return "ajax:"+likeValue;
	}

}

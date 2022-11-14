package co.dabling.msp.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dabling.msp.common.Command;
import co.dabling.msp.notice.service.NoticeService;
import co.dabling.msp.notice.service.impl.NoticeServiceImpl;
import co.dabling.msp.notice.vo.NoticeVO;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 등록
		String title = request.getParameter("title"); //공지제목
		String cont = request.getParameter("title"); //공지내용
		NoticeVO notice = new NoticeVO();
		NoticeService service = new NoticeServiceImpl();
		service.noticeInsert(notice);
		return "admin/noticeForm.tiles";
	}

}

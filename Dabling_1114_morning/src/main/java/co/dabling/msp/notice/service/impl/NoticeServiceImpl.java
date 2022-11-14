package co.dabling.msp.notice.service.impl;

import java.util.List;
import java.util.Properties;

import co.dabling.msp.notice.service.NoticeService;
import co.dabling.msp.notice.vo.NoticeVO;



public class NoticeServiceImpl implements NoticeService {

	@Override
	public List<NoticeVO> noticeSelectList() {
		// 공지사항 전체조회
		return null;
	}

	@Override
	public NoticeVO noticeSelect(int noticeCode) {
		// 공지사항 1건 상세조회
		return null;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// 공지사항 입력
		return 0;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// 공지사항 수정
		return 0;
	}

	@Override
	public int noticeDelete(int noticeCode) {
		// 공지사항 추가.
		return 0;
	}
}
package co.edu.board;

public class PageVO {
	int totalCnt; // ��ü�Ǽ�.
	int pageNum; // ����������.
	int startPage, endPage, totalPage;
	boolean prev, next;

	public PageVO(int totalCnt, int pageNum) {
		this.totalCnt = totalCnt;
		this.pageNum = pageNum;

		totalPage = (int) Math.ceil(totalCnt / 10.0); // 51.6 => 52
		// startPage, endPage ���.
		this.endPage = (int) Math.ceil(this.pageNum / 10.0) * 10; // 10page
		this.startPage = this.endPage - 9; // 1page
		if(this.endPage > totalPage) {
			this.endPage = totalPage;
		}
		
		prev = this.startPage > 10; // ����������.
		next = this.endPage < totalPage; // ����������.
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	@Override
	public String toString() {
		return "PageVO [totalCnt=" + totalCnt + ", pageNum=" + pageNum + ", startPage=" + startPage + ", endPage="
				+ endPage + ", totalPage=" + totalPage + ", prev=" + prev + ", next=" + next + "]";
	}
}

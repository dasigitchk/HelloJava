package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.edu.board.BoardVO;
import co.edu.common.Control;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class WriteBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String saveDir = req.getServletContext().getRealPath("upload");
		System.out.println(saveDir);
		String encod = "UTF-8";
		int maxSize = 5 * 1024 * 1024; // 5
		
		MultipartRequest mr = new MultipartRequest(//
				req, // ��û����.
				saveDir, // ������ġ.
				maxSize, // ����ũ��.
				encod, //���ڵ�.
				new DefaultFileRenamePolicy() // ������ ��å. �Ȱ��������������� �ٸ��̸����� ����ڴ�?
		);
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String image = mr.getFilesystemName("image");
		
		// DB �Է�.
		BoardService service = new BoardServiceImpl();
		service.insertBoard(new BoardVO(0, title, content, writer, null, 0, image));
		
//		HttpUtil.forward(req, resp, "bulletin/bulletin.tiles");
		resp.sendRedirect("bulletin.do");
	}

}

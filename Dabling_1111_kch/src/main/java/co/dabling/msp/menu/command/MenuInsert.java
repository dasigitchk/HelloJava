package co.dabling.msp.menu.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dabling.msp.common.Command;
import co.dabling.msp.menu.service.MenuService;
import co.dabling.msp.menu.service.impl.MenuServiceImpl;
import co.dabling.msp.menu.vo.MenuVO;

public class MenuInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		MenuService service = new MenuServiceImpl();
		MenuVO menu = new MenuVO();

		// 이미지파일 업로드.
		String saveFolder = "c:\\upload";
		String saveDir = request.getServletContext().getRealPath("/upload"); // 저장폴더.
		int maxSize = 5 * 1024 * 1024; // 5 메가 제한
		String encod = "UTF-8";

		MultipartRequest multipart;
		try {
			multipart = new MultipartRequest(request, // 요청정보
					saveDir, // 저장위치
					maxSize, // 파일크기
					encod, // 인코딩
					new DefaultFileRenamePolicy() // 같은이름 파일 재지정.(덮어쓰기x)
			);

			// 파일저장, 업로드파일제목으로 저장.ㅣ
			String filName = multipart.getFilesystemName("uploadFile");
			String orignal = multipart.getOriginalFileName("uploadFile");

			String menuName = multipart.getParameter("menuName");
			String menuImage = multipart.getFilesystemName("menuImage");
			String price = multipart.getParameter("price");

			menu.setMenuName(menuName);
			menu.setMenuImage(menuImage);
			menu.setPrice(price);

			System.out.println(menuName);

			service.menuInsert(menu);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "menu/menuInsert.tiles";

	}
}
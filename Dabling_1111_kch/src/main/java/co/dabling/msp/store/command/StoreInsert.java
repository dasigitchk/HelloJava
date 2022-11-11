package co.dabling.msp.store.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dabling.msp.common.Command;
import co.dabling.msp.store.service.StoreService;
import co.dabling.msp.store.service.impl.StoreServiceImpl;
import co.dabling.msp.store.vo.StoreVO;

public class StoreInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		// 매장 승인신청
		String saveFolder = "c:\\upload";
		StoreService service = new StoreServiceImpl();
		StoreVO vo = new StoreVO();

		// 이미지파일 업로드.
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
			
			//파일저장, 업로드파일제목으로 저장.ㅣ
			String filName = multipart.getFilesystemName("uploadFile");
			String orignal = multipart.getOriginalFileName("uploadFile");

			String storeName = multipart.getParameter("storeName");
			String storeRegion = multipart.getParameter("storeRegion");
			String storeCategory = multipart.getParameter("storeCategory");
			String storeInfo = multipart.getParameter("storeInfo");
			double lat = Double.parseDouble(multipart.getParameter("lat"));
			double lng = Double.parseDouble(multipart.getParameter("lng"));
			String storeImage = multipart.getFilesystemName("storeImage");
			String storeAddress = multipart.getParameter("storeAddress");
			String businessNum = multipart.getParameter("businessNum");

			vo.setStoreName(storeName);
			vo.setStoreRegion(storeRegion);
			vo.setStoreCategory(storeCategory);
			vo.setStoreInfo(storeInfo);
			vo.setLat(lat);
			vo.setLng(lng);
			vo.setStoreImage(storeImage);
			vo.setStoreAddress(storeAddress);
			vo.setBusinessNum(businessNum);
			
			System.out.println(vo.getStoreName());
			System.out.println(vo.getLat());
			System.out.println(vo.getLng());
			System.out.println(vo.getBusinessNum());
			service.storeInsert(vo);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "store/storeInsert.tiles";
	}

}

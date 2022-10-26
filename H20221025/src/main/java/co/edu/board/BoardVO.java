package co.edu.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 필드 다 채워주는 생성자 만듦.
@NoArgsConstructor  //매개값없는 기본생성자 만듦.
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate; // 2020-11-23
	private int clickCnt;
	private String image;
}

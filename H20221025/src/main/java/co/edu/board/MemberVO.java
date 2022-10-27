package co.edu.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor 
@NoArgsConstructor  
public class MemberVO {
		private String id;
		private String passwd;
		private String name;
		private String email; // 2020-11-23
		private String resposibility;
}
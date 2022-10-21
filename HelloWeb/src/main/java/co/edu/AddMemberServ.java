package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddMemberServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request
			, HttpServletResponse response)	throws ServletException, IOException {
		
		// content 타입을 지정.
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("/addMemberServ 페이지입니다.");
		String empId = request.getParameter("employee_id");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hire_date = request.getParameter("hire_date");
		String job_id = request.getParameter("job_id");
		System.out.println(empId);

		String sql = "insert into emp1 values(seq_nextval)  ";
		// 입력.
		EmpDAO dao = new EmpDAO();
		EmployeeVO emp = new EmployeeVO(0,null,lName,email,hire_date,job_id);
		dao.insertEmp(emp);
		
		System.out.println("입력완료" );
		
		PrintWriter out = response.getWriter(); // 출력스트림. writer는 2byte씩 담아서 처리하는 객체.
		out.print("입력결과: ");
		out.print("사원번호: "+emp.getEmployeeId());
		out.print("이름: "+emp.getLastName());
		out.print("이메일: "+emp.getEmail());
		out.print("입사일: "+emp.getHireDate());
		out.print("직무: "+emp.getJobId());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
package com.movie.web.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;
import com.movie.web.member.MemberBean;
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;


@WebServlet({"/admin/admin_form.do","/admin/memberList.do","/admin/admin_login.do","/admin/admin_login_form.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//MemberService service = MemberServiceImpl.getInstance();
	AdminService service = AdminServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = new Command();
		AdminBean admin = new AdminBean();
		HttpSession session = request.getSession();
		String directory = Seperator.extract(request)[2];
		String action = Seperator.extract(request)[3];

		switch (action) {
		case "admin_form": 
			command = CommandFactory.createCommand(directory, action);
			break;
		case "memberList":
			command = CommandFactory.createCommand(directory, action);
			break;
		case "admin_login":
			System.out.println("어드민컨트롤러접근");
			admin.setId(request.getParameter("id"));
			System.out.println(admin+"admin!!!!!");
			
			if (!(service.getAdmin(admin).getId()).equals("")) {
				System.out.println("====  아이디가 존재함 ===========");
				admin.setId(request.getParameter("id"));
				admin.setPassword(request.getParameter("password"));
				System.out.println(service.getAdmin(admin));
				if(service.getAdmin(admin) ==null){
					System.out.println("====  비밀번호 오류 ===========");
					command = CommandFactory.createCommand(directory, "admin_login_form");
				}else{
					System.out.println(" 관리자 로그인 성공");
					session.setAttribute("user", admin);//session => bom
					command = CommandFactory.createCommand(directory, "admin_form");
				}
			}else {
				System.out.println("====  로그인 실패 ===========");
				command = CommandFactory.createCommand(directory, "admin_login_form");
			}
			
			break;
		case "admin_login_form":
			command = CommandFactory.createCommand(directory, action);
			break;
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		DispatcherServlet.go(request, response, command.getView());
	}

}

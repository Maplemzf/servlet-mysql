import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import dao.BaseDao;


public class ModifyServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//以下两句为取消在本地的缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("expires", "0");
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		String age = request.getParameter("age");
		String usertype = request.getParameter("usertype");
		String usersex = request.getParameter("usersex");
		if(username.equals("")||password.equals("")){
			out.print("1");
		}else{
			BaseDao bd=new BaseDao();
			List<String> usenames=bd.allUserName();
			if(usenames.contains(username)){
				out.print("2");
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				int userage=Integer.valueOf(age);
				User user=new User();
				user.setUserid(Integer.valueOf(userid));
				user.setAge(userage);
				user.setType(usertype);
				user.setUsername(username);
				user.setUserpass(password);
				user.setUsersex(usersex);
				int addRes=bd.modi(user);
				if(addRes==1){
					out.print("3");
				}else{
					out.print("4");
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

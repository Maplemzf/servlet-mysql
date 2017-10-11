import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaseDao;

public class LoginServlet extends HttpServlet{
	/**  
     *   
     */  
    private static final long serialVersionUID = 1L;  
  
    /**  
     * Constructor of the object.  
     */  
    public LoginServlet() {  
        super();  
    }  
  
    /**  
     * Destruction of the servlet. <br>  
     */  
    public void destroy() {  
        super.destroy(); // Just puts "destroy" string in log  
        // Put your code here  
    } 

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {

		//response.sendRedirect("/yzm/index.jsp");
	}
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
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		String code = request.getParameter("code");// 页面，用户输入的验证码
		HttpSession session = request.getSession();
		String randCode = (String)session.getAttribute("randCode");// 得到系统生成的验证码
		String forward="";
		try {
			//以下两句为取消在本地的缓存

			if(randCode.equals(code)){// 验证码输入正确
				BaseDao bd=new BaseDao();
				String res=bd.login(username, password);
				if(res.equals("登录失败")){
					out.print("1");
				}else{
					String userTpye=bd.getType(username);
					session.setAttribute("username", username);
					out.print(userTpye);
				}
				
			}else{
				out.print("3");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			out.close();
		}
		
		
	}
}
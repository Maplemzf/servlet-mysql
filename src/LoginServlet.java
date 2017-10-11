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
		//��������Ϊȡ���ڱ��صĻ���
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("expires", "0");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		String code = request.getParameter("code");// ҳ�棬�û��������֤��
		HttpSession session = request.getSession();
		String randCode = (String)session.getAttribute("randCode");// �õ�ϵͳ���ɵ���֤��
		String forward="";
		try {
			//��������Ϊȡ���ڱ��صĻ���

			if(randCode.equals(code)){// ��֤��������ȷ
				BaseDao bd=new BaseDao();
				String res=bd.login(username, password);
				if(res.equals("��¼ʧ��")){
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
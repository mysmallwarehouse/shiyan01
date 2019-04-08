package com.wys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wys.dao.userDao;
import com.wys.javabean.User;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//׼������		
		// ���������ַ�����
		request.setCharacterEncoding("utf-8");
		// ������Ӧ�ַ�����
		response.setContentType("text/html;charset=utf-8");

		// ��ȡ����,��ȡ��������
		String type = request.getParameter("type");
		if ("login".equals(type)) {
			// �����C
			String userLogname = request.getParameter("userLogname");
			String userPwd = request.getParameter("userPwd");
			// �{��dao �����L����
			userDao dao = new userDao();
			User user = dao.login(userLogname, userPwd);
			if (user != null) {
				// ��¼�ɹ���ʹ�ûỰ�����Լ�¼�û���Ϣ���������������
				request.getSession().setAttribute("user", user);
				response.sendRedirect("manage/main.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert(�Ñ����ܴa���`��)");
				out.println("window.location='login.jsp");
				out.println("</script>");

			}

			// ���D
		} else if ("logout".equals(type)) {
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");

		}

	}

}

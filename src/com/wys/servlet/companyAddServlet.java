package com.wys.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wys.dao.CompanyDao;
import com.wys.javabean.Company;

/**
 * ��ҵ��Ϣ���Servlet
 * 
 */
@WebServlet("/companyAddServlet")
@MultipartConfig
public class companyAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���������ַ�����
		request.setCharacterEncoding("UTF-8");
		// ������Ӧ�ַ�����
		response.setContentType("text/html;charset=UTF-8");
		// ��ȡ��Ӧ�ַ������
		PrintWriter out = response.getWriter();
		// ��ȡ��ҵ�����Ϣ
		String companyName = request.getParameter("companyName");
		String companyArea = request.getParameter("companyArea");
		String companySize = request.getParameter("companySize");
		String companyType = request.getParameter("companyType");
		String companyBrief = request.getParameter("companyBrief");
		int companyState = (request.getParameter("companyState") == null) ?3
				: Integer.parseInt(request.getParameter("companyState"));
		int companySort = (request.getParameter("companySort") == null) ?0
				: Integer.parseInt(request.getParameter("companySort"));
		int companyViewnum = 0;
		
		
		
		
		
		
		
		
		
		
		// ��ȡ�ϴ��ļ���
		Part part = request.getPart("companyPic");
		// ��ȡ�ϴ��ļ�����
		String fileName = part.getSubmittedFileName();
		// Ϊ��ֹ�ϴ��ļ����������ļ�����������
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		// ���ϴ����ļ������ڷ�������Ŀ¼�µ�upload/companyPic��Ŀ¼��
		String filepath = getServletContext().getRealPath("/");
		filepath = filepath.substring(0, filepath.indexOf(getServletContext().getServletContextName()));
		filepath = filepath + "upload/companyPic";
		getServletContext().log("�ϴ�·��Ϊ��" + filepath);
		File f = new File(filepath);
		if (!f.exists())
			f.mkdirs();
		part.write(filepath + "/" + newFileName);
		// ����һ��������װ��ҵ��Ϣ��JavaBean
		Company company = new Company(companyName, companyArea, companySize, companyType, companyBrief, companyState,companySort, 0, newFileName);

		
		// ��ҵ��Ϣ���
		CompanyDao dao = new CompanyDao();

		int n = dao.save(company);
		//��ת
		if(n==1) {
			response.sendRedirect(request.getContextPath()+"/manage/companyList.html");
		}else {
			response.sendRedirect(request.getContextPath()+"/manage/error.jsp");
		}
		
//		out.print("<script type='text/javascript'>");
//		out.print("alert('��ҵ��Ϣ��ӳɹ���');");
//		out.print("window.location='manage/companyList.html';");
//		out.print("</script>");
	}
}

package web_study_03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResearchServlet")
public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String seasonArr[] = request.getParameterValues("season");
		String seasonRes = "";

		
		if (gender.equals("male")) {
			gender = "남자";
		}else {
			gender = "여자";
		}
		
		if (seasonArr == null)
			seasonArr = new String[] {"계절을 선택하세요"};
		
		for (String season : seasonArr) {
			int n = Integer.parseInt(season);
			switch (n) {
			case 1:
				seasonRes = seasonRes + "봄 ";
				break;
			case 2:
				seasonRes = seasonRes + "여름 ";
				break;
			case 3:
				seasonRes = seasonRes + "가을 ";
				break;
			case 4:
				seasonRes = seasonRes + "겨울 ";
				break;
			}
		}
	
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("season", seasonRes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("researchResult.jsp");
		dispatcher.forward(request, response);
//		response.sendRedirect("researchResult.jsp");
		
	}

}

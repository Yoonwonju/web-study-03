package web_study_03;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResearchServlet")
public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object seasonRes;

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
		if(seasonArr == null)
			seasonArr = new String[] {
				for (String season : seasonArr) {
					int n = Integer.parseInt(season);
					switch (n) {
					case 1:seasonRes = seasonRes + "봄"; break;
					case 2:seasonRes = seasonRes + "여름"; break;
					case 3:seasonRes = seasonRes + "가을"; break;
					case 4:seasonRes = seasonRes + "겨울"; break;
					default : seasonRes = seasonRes + "계절을 선택하세요";
					}
				}
		};
	
		String arrToSeason = Arrays.stream(seasonArr).collect(Collectors.joining(" "));
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("season", seasonRes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("researchResult.jsp");
		dispatcher.forward(request, response);
		
	}

}

package ro.sci.java5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgeCalculator ageCalculator = new AgeCalculator();
			int yearOfBirthday = Integer.parseInt(req.getParameter("yearOfBirth"));
			int monthOfBirthday = Integer.parseInt(req.getParameter("monthOfBirth"));
			int birthday = Integer.parseInt(req.getParameter("dayOfBirth"));
			int currentYear = Integer.parseInt(req.getParameter("currentYear"));
			int currentMonth = Integer.parseInt(req.getParameter("currentMonth"));
			int currentDay = Integer.parseInt(req.getParameter("currentDay"));
			ageCalculator.calculateAge(yearOfBirthday, monthOfBirthday, birthday, currentYear, currentMonth,
					currentDay);
			
			req.setAttribute("result", ageCalculator.displayAgeInDays());
			req.getRequestDispatcher("myAge.jsp").forward(req, resp);
	}
}

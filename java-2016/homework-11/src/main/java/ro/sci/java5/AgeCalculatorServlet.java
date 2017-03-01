package ro.sci.java5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgeCalculator ageCalculator = new AgeCalculator();
		int yearOfBirthday = Integer.parseInt(req.getParameter("yearOfBirthday"));
		int monthOfBirthday = Integer.parseInt(req.getParameter("monthOfBirthday"));
		int birthday = Integer.parseInt(req.getParameter("birthday"));
		int currentYear = Integer.parseInt(req.getParameter("currentYear"));
		int currentMonth = Integer.parseInt(req.getParameter("currentMonth"));
		int currentDay = Integer.parseInt(req.getParameter("currentDay"));
		ageCalculator.calculateAge(yearOfBirthday, monthOfBirthday, birthday, currentYear, currentMonth,
				currentDay);
		
		req.setAttribute("result", ageCalculator.displayAgeInDays());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}

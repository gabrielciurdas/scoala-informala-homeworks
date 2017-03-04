package ro.sci.java5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is a Servlet for the Age Calculator web app.
 * 
 * @author Gabriel Ciurdas
 *         <p>
 *         Created on 4/3/2017
 *
 */
public class AgeCalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This get method receives an input with details of birthday and current
	 * day from a web page. Then a calculateAge method is called in order to
	 * send back a response with the result of age in days.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgeCalculator ageCalculator = new AgeCalculator();
		int yearOfBirthday = Integer.parseInt(req.getParameter("yearOfBirth"));
		int monthOfBirthday = Integer.parseInt(req.getParameter("monthOfBirth"));
		int birthday = Integer.parseInt(req.getParameter("dayOfBirth"));
		int currentYear = Integer.parseInt(req.getParameter("currentYear"));
		int currentMonth = Integer.parseInt(req.getParameter("currentMonth"));
		int currentDay = Integer.parseInt(req.getParameter("currentDay"));
		ageCalculator.setDates(yearOfBirthday, monthOfBirthday, birthday, currentYear, currentMonth, currentDay);

		req.setAttribute("result", ageCalculator.displayAgeInDays());
		req.getRequestDispatcher("myAge.jsp").forward(req, resp);
	}
}

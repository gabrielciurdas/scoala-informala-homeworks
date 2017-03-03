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
		/*String error = "Field cannot be empty";
		if(req.getParameter("yearOfBirth").equals(null)
				|| req.getParameter("monthOfBirth").equals(null)
				|| req.getParameter("dayOfBirth").equals(null)
				|| req.getParameter("currentYear").equals(null)
				|| req.getParameter("currentMonth").equals(null)
				|| req.getParameter("currentDay").equals(null)) {
			req.setAttribute("error", error);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		} else {
			*/
			int yearOfBirthday = Integer.parseInt(req.getParameter("yearOfBirth"));
			int monthOfBirthday = Integer.parseInt(req.getParameter("monthOfBirth"));
			int birthday = Integer.parseInt(req.getParameter("dayOfBirth"));
			int currentYear = Integer.parseInt(req.getParameter("currentYear"));
			int currentMonth = Integer.parseInt(req.getParameter("currentMonth"));
			int currentDay = Integer.parseInt(req.getParameter("currentDay"));
			ageCalculator.calculateAge(yearOfBirthday, monthOfBirthday, birthday, currentYear, currentMonth,
					currentDay);
			
			req.setAttribute("result", ageCalculator.displayAgeInDays());
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		//}
	}
}

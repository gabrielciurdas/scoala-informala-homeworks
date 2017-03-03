package ro.sci.java5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletInformation = "This is the message posted by NewServlet using doPost method.";
		req.setAttribute("servletInformation", servletInformation);
		req.getRequestDispatcher("myAge.jsp").forward(req, resp);
	}
}
	

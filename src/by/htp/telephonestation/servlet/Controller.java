package by.htp.telephonestation.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.telephonestation.command.ActionCommand;
import by.htp.telephonestation.command.factory.ActionFactory;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.resource.MessageManager;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		/*
		 * определение команды, пришедшей из JSP
		 */
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		/*
		* вызов реализованного метода execute() и передача параметров классу-обработчику конкретной команды
		*/
		page = command.execute(request);
		System.out.println(page);
		/*
		 * метод возвращает страницу ответа и установка страницы c cообщением об ошибке
		 */
		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} else {
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}
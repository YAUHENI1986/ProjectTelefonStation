package by.htp.telephonestation.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.logic.LoginLogic;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.resource.MessageManager;

public class LoginAdminCommandImpl implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		/*
		 * ���������� �� ������� ������ � ������
		 */
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		/*
		 * �������� ������ � ������
		 */
		if (LoginLogic.checkLogin(login, pass)) {
			request.setAttribute("user", login);
			/*
			 * ����������� ���� � main.jsp
			 */
			page = ConfigurationManager.getProperty("path.page.main&admin");
		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login&admin");
		}
		return page;
	}
}

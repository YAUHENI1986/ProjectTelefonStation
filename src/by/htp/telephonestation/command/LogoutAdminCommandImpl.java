package by.htp.telephonestation.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.resource.ConfigurationManager;



public class LogoutAdminCommandImpl implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		/*
		 * уничтожение сессии
		 */
		request.getSession().invalidate();
		return page;
	}
}

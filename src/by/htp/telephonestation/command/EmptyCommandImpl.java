package by.htp.telephonestation.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.resource.ConfigurationManager;



public class EmptyCommandImpl implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		/* 
		 * в случае ошибки или прямого обращения к контроллеру переадресация на страницу ввода логина
		 */
		String page = ConfigurationManager.getProperty("path.page.index");
		return page;
	}
}

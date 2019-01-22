package by.htp.telephonestation.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.resource.ConfigurationManager;

public class JspAddServiceCommandImpl implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.add&service");
		return page;
	}

}

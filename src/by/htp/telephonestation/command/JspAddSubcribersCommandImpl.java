package by.htp.telephonestation.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.resource.ConfigurationManager;

public class JspAddSubcribersCommandImpl implements ActionCommand{
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.add&subscriber");
		return page;
	}

}

package by.htp.telephonestation.command;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.resource.ConfigurationManager;

public class UserEntryCommandImpl implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.main%user");
		return page;
	}

}

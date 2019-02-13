package by.htp.telephonestation.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.entity.PhoneService;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class UserEntryCommandImpl implements ActionCommand{
	
	private CatalogServicesPhoneServices catalogServices = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		List<PhoneService> phoneServices = catalogServices.viewActivePhoneServices();
		
		request.setAttribute("phoneServices", phoneServices);
		page = ConfigurationManager.getProperty("path.page.main%user");
		return page;
	}

}

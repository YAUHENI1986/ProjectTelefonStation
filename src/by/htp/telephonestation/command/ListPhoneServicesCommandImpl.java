package by.htp.telephonestation.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.entity.PhoneService;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class ListPhoneServicesCommandImpl implements ActionCommand{
	
	private CatalogServicesPhoneServices catalogService = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		List<PhoneService> phoneServices = catalogService.viewAllPhoneServices();
		
		request.setAttribute("phoneServices", phoneServices);
		page = ConfigurationManager.getProperty("path.page.list&phone&services");
		return page;
	}

}
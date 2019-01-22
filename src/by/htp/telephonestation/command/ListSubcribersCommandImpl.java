package by.htp.telephonestation.command;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.entity.Subscriber;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.service.CatalogServiceSubscribers;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class ListSubcribersCommandImpl implements ActionCommand{
	
	private CatalogServiceSubscribers catalogService = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		List<Subscriber> subscribers = catalogService.getCatalogSubscribers();
		
		request.setAttribute("subscribers", subscribers);
		page = ConfigurationManager.getProperty("path.page.list&subscribers");
		return page;
	}

}
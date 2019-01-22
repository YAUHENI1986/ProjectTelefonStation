package by.htp.telephonestation.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.entity.Invoice;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.service.CatalogServiceInvoice;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class ListInvoicesCommandImpl implements ActionCommand{
	
	private CatalogServiceInvoice catalogService = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		List<Invoice> invoices = catalogService.getCatalogInvoices();
		request.setAttribute("invoices", invoices);
		page = ConfigurationManager.getProperty("path.page.list&invoices");
		return page;
	}

}

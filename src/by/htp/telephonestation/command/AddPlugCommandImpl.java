package by.htp.telephonestation.command;

import static by.htp.telephonestation.command.util.CommandConstant.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.entity.PhoneService;
import by.htp.telephonestation.logic.AddPlugLogic;
import by.htp.telephonestation.resource.ConfigurationManager;
import by.htp.telephonestation.resource.MessageManager;
import by.htp.telephonestation.service.CatalogServiceInvoice;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class AddPlugCommandImpl implements ActionCommand{
	
	private CatalogServiceInvoice catalogServiceInv = new CatalogServiceImpl();
	private CatalogServicesPhoneServices catalogServices = new CatalogServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		String id_plug = request.getParameter(REQ_PARAM_INVOICE_ID_PLUG);
		String phone_number = request.getParameter(REQ_PARAM_INVOICE_PHONE_NUMBER);
		
		if(AddPlugLogic.checkNullEmpty(id_plug, phone_number)) {			
			if(AddPlugLogic.checkIdPlugAvailability(id_plug, phone_number)) {
				if(AddPlugLogic.checkPhoneNumberAvailability(id_plug, phone_number)) {
					if(AddPlugLogic.checkDoubleTariff(id_plug, phone_number)) {
						if(AddPlugLogic.checkIdOverlap(id_plug, phone_number)) {
							preRequest(request);
							catalogServiceInv.addPlug(Integer.parseInt(id_plug), Integer.parseInt(phone_number));
							request.setAttribute("serviceSuccessfullyAdded", MessageManager.getProperty("message.successful"));
							page = ConfigurationManager.getProperty("path.page.plug&service");
						} else {
							preRequest(request);
							request.setAttribute("errorCopyService", MessageManager.getProperty("message.dataidcopy"));
							page = ConfigurationManager.getProperty("path.page.plug&service");
						}						
					} else {
						preRequest(request);
						request.setAttribute("errorDoubleTariff", MessageManager.getProperty("message.datadoubletariff"));
						page = ConfigurationManager.getProperty("path.page.plug&service");
					}					
				} else {
					preRequest(request);
					request.setAttribute("errorPhoneNumberMessage", MessageManager.getProperty("message.dataphone"));
					page = ConfigurationManager.getProperty("path.page.plug&service");
				}	
			} else {
				preRequest(request);
				request.setAttribute("errorIdMessage", MessageManager.getProperty("message.dataid"));
				page = ConfigurationManager.getProperty("path.page.plug&service");
			}			
		} else {
			preRequest(request);
			request.setAttribute("errorDataMessage", MessageManager.getProperty("message.dataempty"));
			page = ConfigurationManager.getProperty("path.page.plug&service");
		}
		return page;
	}
	
	private void preRequest(HttpServletRequest request) {
		List<PhoneService> phoneServices = catalogServices.viewActivePhoneServices();			
		request.setAttribute("phoneServices", phoneServices);
	}

}

package by.htp.telephonestation.logic;

import static by.htp.telephonestation.command.util.CommandConstant.*;

import java.util.List;

import by.htp.telephonestation.entity.Invoice;
import by.htp.telephonestation.entity.PhoneService;
import by.htp.telephonestation.service.CatalogServiceInvoice;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class AddPlugLogic {
	
	public static boolean checkNullEmpty(String id_plug, String phone_number) {
		return id_plug!=null && id_plug!="" && phone_number!=null && phone_number!="" && checkValidate(id_plug, phone_number);
	};
	
	private static boolean checkValidate(String id_plug, String phone_number) throws NumberFormatException{
		try {
			Integer.parseInt(id_plug);
			Integer.parseInt(phone_number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/*
	 * проверка на наличие в базе данных номера телефона
	 */
	public static boolean checkPhoneNumberAvailability(String id_plug,  String phone_number) {
		CatalogServiceInvoice catalogServiceI = new CatalogServiceImpl();
		List<Invoice> invoices = catalogServiceI.getCatalogInvoices();
		if(checkValidate(id_plug, phone_number)){
			for(Invoice e: invoices) {
				if(e.getPhoneNumber() == Integer.parseInt(phone_number)) {
					return true;
				}
			}			
		}		
		return false;
	}
	
	/*
	 * проверка на наличие в базе данных услуги
	 */
	public static boolean checkIdPlugAvailability(String id_plug,  String phone_number) {		
		CatalogServicesPhoneServices catalogServiceP = new CatalogServiceImpl();
		List<PhoneService> phoneServices = catalogServiceP.viewActivePhoneServices();
		if(checkValidate(id_plug, phone_number)){
			for(PhoneService e: phoneServices) {
				if(e.getId() == Integer.parseInt(id_plug)) {
					return true;
				}
			}	
		}		
		return false;
	}
	
	public static boolean checkIdOverlap(String id_plug,  String phone_number) {		
		CatalogServicesPhoneServices catalogServicePhone = new CatalogServiceImpl();
		List<PhoneService> phoneActiveServices = catalogServicePhone.viewActivePhoneServices();
		List<PhoneService> phoneAllServices = catalogServicePhone.viewAllPhoneServices();
		PhoneService current = phoneActiveServices.get(Integer.parseInt(id_plug)-1);
		int i = 0;
		for(PhoneService e: phoneAllServices) {
			if(e.getDescriprion().equals(current.getDescriprion())) {
				i = e.getId();
			}
		}
		CatalogServiceInvoice catalogServiceInvoices = new CatalogServiceImpl();
		String currentInvoices = catalogServiceInvoices.getConnectedServices(Integer.parseInt(phone_number));
		if(checkConnectedServce(i,currentInvoices)) {
			return false;
		}		
		return true;
	}
	
	private static boolean checkConnectedServce(int i, String y) {
		String[] services = y.split(",");
		for(int z = 0; z<services.length; z++) {
			if(services[z].equals(String.valueOf(i))) {				
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkDoubleTariff(String id_plug,  String phone_number) {		
		CatalogServicesPhoneServices catalogServicePhone = new CatalogServiceImpl();
		List<PhoneService> phoneActiveServices = catalogServicePhone.viewActivePhoneServices();
		List<PhoneService> phoneAllServices = catalogServicePhone.viewAllPhoneServices();
		PhoneService current = phoneActiveServices.get(Integer.parseInt(id_plug)-1);
		int i = 0;
		for(PhoneService e: phoneAllServices) {
			if(e.getDescriprion().equals(current.getDescriprion())) {
				i = e.getId();
			}
		}
		CatalogServiceInvoice catalogServiceInvoices = new CatalogServiceImpl();
		String currentInvoices = catalogServiceInvoices.getConnectedServices(Integer.parseInt(phone_number));		
		if(checkDoubleTariff(i, currentInvoices, phoneAllServices)) {
			return false;
		}
		return true;
	}
	
	private static boolean checkDoubleTariff(int i, String y, List<PhoneService> list) {		
		String[] services = y.split(",");
		int counter = 0;
		if(services.length == 1 && services[0].equals(REQ_PARAM_INVOICE_DEFAULT_CONNECTED_SERVICES)) {
			return false;
		}
		for(PhoneService e: list) {
			for(int z = 0; z<services.length; z++) {
				if(e.getId() == Integer.valueOf(services[z])) {				
					if(e.getType().equals(REQ_PARAM_INVOICE_DEFAULT_TYPE_TARIFF)) {
						counter++;
					}					
				}
			}
		}
		if(counter == 1 && list.get(i-1).getType().equals(REQ_PARAM_INVOICE_DEFAULT_TYPE_TARIFF)) {			
			return true;
		}
		return false;
	}

}

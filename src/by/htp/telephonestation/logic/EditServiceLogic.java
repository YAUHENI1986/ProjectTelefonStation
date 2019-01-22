package by.htp.telephonestation.logic;

import java.util.List;

import by.htp.telephonestation.entity.PhoneService;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class EditServiceLogic {
	/*
	 * проверка на пустые поля и null
	 */	
	public static boolean checkNullEmpty(String id, String type_list, String status_list, String description, String cost_per_month) {
		return id!=null && id!="" && type_list!=null && type_list!="" && status_list!=null && status_list!="" && description!=null && description!="" && cost_per_month!=null && cost_per_month!="" && checkValidate(id, cost_per_month);
	}
	
	/*
	 * проверка что числа - это числа
	 */	
	private static boolean checkValidate(String id, String cost_per_month) throws NumberFormatException{
		try {
			Integer.parseInt(id);
			Double.parseDouble(cost_per_month);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/*
	 * проверка на выход за пределы базы данных
	 */
	public static boolean checkServiceAvailability(String id, String cost_per_month) {
		CatalogServicesPhoneServices catalogService = new CatalogServiceImpl();
		List<PhoneService> phoneServices = catalogService.viewAllPhoneServices();
		if(checkValidate(id, cost_per_month)) {
			if(Integer.parseInt(id)<=phoneServices.size() && Integer.parseInt(id)>0) {
				return true;
			}
		}
		return false;
	}

}

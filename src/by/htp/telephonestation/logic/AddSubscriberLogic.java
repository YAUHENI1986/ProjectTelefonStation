package by.htp.telephonestation.logic;

import java.util.List;

import by.htp.telephonestation.entity.Subscriber;
import by.htp.telephonestation.service.CatalogServiceSubscribers;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class AddSubscriberLogic {
	/*
	 * проверка на пустые поля и null
	 */	
	public static boolean checkNullEmptyLogin(String name, String surname, String adress, String personal_number_passport) {
		return name!=null && name!="" && surname!=null && surname!="" && adress!=null && adress!="" && personal_number_passport!=null && personal_number_passport!="" && checkValidate(personal_number_passport);
	}
	
	/*
	 * проверка что числа - это числа
	 */
	private static boolean checkValidate(String personal_number_passport) throws NumberFormatException{
		try {
			Integer.parseInt(personal_number_passport);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/*
	 * проверка на наличие в базе данных пользователя
	 */
	public static boolean checkUserAvailability(String personal_number_passport) {
		CatalogServiceSubscribers catalogService = new CatalogServiceImpl();
		List<Subscriber> subscribers = catalogService.getCatalogSubscribers();
		if(checkValidate(personal_number_passport)) {
			for (Subscriber e: subscribers) {
				if(e.getPersonalNumberPassport() == Integer.parseInt(personal_number_passport)) {
					return false;
				}
			}
		}
		return true;
	}
	
}

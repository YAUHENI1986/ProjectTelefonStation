package by.htp.telephonestation.service;

import java.util.List;

import by.htp.telephonestation.entity.PhoneService;

public interface CatalogServicesPhoneServices {
	
	void addPhoneService(String status, String type, String descriprion, double costPerMonth);
	List<PhoneService> viewAllPhoneServices();
	List<PhoneService> viewActivePhoneServices();
	void editPhoneServiceById(int id, String status, String type, String description, double costPerMonth);
	
}

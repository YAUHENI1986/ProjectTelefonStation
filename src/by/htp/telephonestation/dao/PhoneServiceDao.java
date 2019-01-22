package by.htp.telephonestation.dao;

import java.util.List;

import by.htp.telephonestation.entity.PhoneService;

public interface PhoneServiceDao {
	
	void addServices(PhoneService phoneService);
	List<PhoneService> readAll();
	void editServiceById(int id, String status, String type, String description, double costPerMonth);
	
}

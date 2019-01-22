package by.htp.telephonestation.service;

import java.util.List;

import by.htp.telephonestation.entity.Subscriber;

public interface CatalogServiceSubscribers {
	
	List<Subscriber> getCatalogSubscribers();
	void addSubscriber(String name, String surname, String adress, int personalNumberPassport);

}

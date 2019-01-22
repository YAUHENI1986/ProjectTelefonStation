package by.htp.telephonestation.dao;

import java.util.List;

import by.htp.telephonestation.entity.Subscriber;

public interface SubscriberDao {
	
	List<Subscriber> readAll();
	void addSubscriber(Subscriber subscriber);
	
}

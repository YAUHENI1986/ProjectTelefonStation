package by.htp.telephonestation.service;

import java.util.List;

import by.htp.telephonestation.entity.Invoice;

public interface CatalogServiceInvoice {
	
	List<Invoice> getCatalogInvoices();
	void addInvoice(int subscriber, int invoice, String connected_services, int phone_number, String status);
	int getIdSubscriber(int personal_number_passport);
	int generatePhoneNumber();
	
}

package by.htp.telephonestation.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.telephonestation.dao.InvoiceDao;
import by.htp.telephonestation.dao.PhoneServiceDao;
import by.htp.telephonestation.dao.SubscriberDao;
import by.htp.telephonestation.dao.impl.InvoiceDaoSqlImpl;
import by.htp.telephonestation.dao.impl.PhoneServiceDaoSqlImpl;
import by.htp.telephonestation.dao.impl.SubscriberDaoSqlImpl;
import by.htp.telephonestation.entity.Invoice;
import by.htp.telephonestation.entity.PhoneService;
import by.htp.telephonestation.entity.Subscriber;
import by.htp.telephonestation.service.CatalogServiceInvoice;
import by.htp.telephonestation.service.CatalogServiceSubscribers;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;



public class CatalogServiceImpl implements CatalogServiceSubscribers, CatalogServicesPhoneServices, CatalogServiceInvoice{
	
	private SubscriberDao subscriberDao = new SubscriberDaoSqlImpl();
	private PhoneServiceDao phoneServiceDao = new PhoneServiceDaoSqlImpl();
	private InvoiceDao invoiceDao = new InvoiceDaoSqlImpl();

	@Override
	public List<Subscriber> getCatalogSubscribers() {
		return subscriberDao.readAll();
	}
	
	@Override
	public void addSubscriber(String name, String surname, String adress, int personalNumberPassport) {
		Subscriber subscriber = new Subscriber(0 , name, surname, adress, personalNumberPassport);
		subscriberDao.addSubscriber(subscriber);		
	}
		
	
	
	
	@Override
	public void addPhoneService(String status, String type, String descriprion, double costPerMonth) {
		PhoneService phoneService = new PhoneService(0, status, type, descriprion, costPerMonth);
		phoneServiceDao.addServices(phoneService);
	}

	@Override
	public List<PhoneService> viewAllPhoneServices() {
		return phoneServiceDao.readAll();
	}
	
	@Override
	public List<PhoneService> viewActivePhoneServices() {
		List<PhoneService> allServices = phoneServiceDao.readAll();
		List<PhoneService> activeServices = new ArrayList<>();
		for(PhoneService e: allServices) {
			if(e.getStatus().equals("active")) {
				activeServices.add(e);
			}
		}
		int i = 1;
		for(PhoneService e: activeServices) {
			e.setId(i);
			i++;
		}
		return activeServices;
	}

	@Override
	public void editPhoneServiceById(int id, String status, String type, String description, double costPerMonth) {
		phoneServiceDao.editServiceById(id, status, type, description, costPerMonth);
	}
	
	
	

	@Override
	public List<Invoice> getCatalogInvoices() {
		return invoiceDao.readAll();
	}

	@Override
	public void addInvoice(int subscriber, int invoice, String connected_services, int phone_number, String status) {
		Invoice invoiceI = new Invoice(subscriber, invoice, connected_services, phone_number, status);
		invoiceDao.addInvoice(invoiceI);		
	}

	@Override
	public int getIdSubscriber(int personal_number_passport) {CatalogServiceSubscribers catalogService = new CatalogServiceImpl();
		List<Subscriber> subscribers = catalogService.getCatalogSubscribers();
		for(Subscriber subscriber: subscribers) {
			if(subscriber.getPersonalNumberPassport() == personal_number_passport) {
				return subscriber.getUniqueNumber();
			}
		}
		return 0;
	}

	@Override
	public int generatePhoneNumber() {
		InvoiceDao invoiceDao = new InvoiceDaoSqlImpl();
		List<Invoice> invoices = invoiceDao.readAll();
		int randomPhoneNumber;
		do {
			randomPhoneNumber = 1000000 + (int)(Math.random()*9000000);
			for(Invoice invoice: invoices) {
				if(invoice.getPhoneNumber() == randomPhoneNumber) {
					randomPhoneNumber = 0;
				}
			}			
		} while(randomPhoneNumber == 0);		
		return randomPhoneNumber;
	}

	@Override
	public void addPlug(int plug, int phone_number) {
		invoiceDao.addPlug(plug, phone_number);		
	}

	@Override
	public String getConnectedServices(int phone_number) {
		List<Invoice> invoices = invoiceDao.readAll();
		for(Invoice e: invoices) {
			if(e.getPhoneNumber() == phone_number) {
				return e.getConnectedServices();
			}
		}
		return "";
	}

	


}

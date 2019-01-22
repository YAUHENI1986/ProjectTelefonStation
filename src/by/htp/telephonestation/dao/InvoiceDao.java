package by.htp.telephonestation.dao;

import java.util.List;

import by.htp.telephonestation.entity.Invoice;

public interface InvoiceDao {
	
	List<Invoice> readAll();
	void addInvoice(Invoice invoice);

}

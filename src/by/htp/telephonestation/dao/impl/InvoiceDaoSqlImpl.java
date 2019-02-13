package by.htp.telephonestation.dao.impl;

import static by.htp.telephonestation.dao.util.DaoConstant.*;
import static by.htp.telephonestation.command.util.CommandConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.telephonestation.dao.InvoiceDao;
import by.htp.telephonestation.entity.Invoice;
import by.htp.telephonestation.entity.PhoneService;
import by.htp.telephonestation.service.CatalogServiceInvoice;
import by.htp.telephonestation.service.CatalogServicesPhoneServices;
import by.htp.telephonestation.service.impl.CatalogServiceImpl;

public class InvoiceDaoSqlImpl implements InvoiceDao{
	
	private static final String SQL_INSERT_INVOICE = "INSERT INTO invoice_and_connected_services (subscriber, invoice, connected_services, phone_number, status) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_INSERT_PLUG = "UPDATE invoice_and_connected_services SET connected_services=? WHERE phone_number=?";
	private static final String SQL_UPDATE_INVOICE = "UPDATE invoice_and_connected_services SET invoice=? WHERE phone_number=?";

	
	@Override
	public List<Invoice> readAll() {
		List<Invoice> invoices =  new ArrayList<>();
		
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from invoice_and_connected_services");
			
			Invoice invoice = null;
			while(rs.next()) {
				invoice = new Invoice(rs.getInt("subscriber"), rs.getInt("invoice"), rs.getString("connected_services"), rs.getInt("phone_number"), rs.getString("status"));
				invoices.add(invoice);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}		
		return invoices;
	}

	@Override
	public void addInvoice(Invoice invoice) {
		try {Class.forName("com.mysql.cj.jdbc.Driver");			
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
				
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT_INVOICE, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, String.valueOf(invoice.getSubscriber()));
				ps.setString(2, String.valueOf(invoice.getInvoice()));
				ps.setString(3, invoice.getConnectedServices());
				ps.setString(4, String.valueOf(invoice.getPhoneNumber()));
				ps.setString(5, invoice.getStatus());
				ps.executeUpdate();				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			} catch (ClassNotFoundException el) {
				el.printStackTrace();
			}	
	}

	@Override
	public void addPlug(int plug, int phone_number) {
		try {Class.forName("com.mysql.cj.jdbc.Driver");			
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
				CatalogServiceInvoice catalogServiceInv = new CatalogServiceImpl();
				CatalogServicesPhoneServices catalogServicePho = new CatalogServiceImpl();
				List<PhoneService> listActiveServices = catalogServicePho.viewActivePhoneServices();
				List<PhoneService> listAllServices = catalogServicePho.viewAllPhoneServices();
				int addPlug = 0;
				PhoneService current = listActiveServices.get(plug-1);
				for(PhoneService e: listAllServices) {
					if(e.getDescriprion().equals(current.getDescriprion())) {
						addPlug = e.getId();
					}
				}				
				String connectedServices = null;
				if(catalogServiceInv.getConnectedServices(phone_number).equals(REQ_PARAM_INVOICE_DEFAULT_CONNECTED_SERVICES)) {
					connectedServices = ""+addPlug;
				} else {
					connectedServices = catalogServiceInv.getConnectedServices(phone_number) + "," + addPlug;
				}
				
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT_PLUG, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, connectedServices);
				ps.setString(2, String.valueOf(phone_number));
				ps.executeUpdate();
				updateInvoice(addPlug, phone_number);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			} catch (ClassNotFoundException el) {
				el.printStackTrace();
			}	
	}
	
	private void updateInvoice(int plug, int phone_number) {
		try {Class.forName("com.mysql.cj.jdbc.Driver");			
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
				CatalogServiceInvoice catalogServiceInv = new CatalogServiceImpl();
				CatalogServicesPhoneServices catalogServicePho = new CatalogServiceImpl();
				List<PhoneService> listAllServices = catalogServicePho.viewAllPhoneServices();
				List<Invoice> listInvoice = catalogServiceInv.getCatalogInvoices();
				double currentInvoice = 0;
				double cost_per_month = 0;
				for(PhoneService e:listAllServices) {
					if(e.getId() == plug) {
						cost_per_month = e.getCostPerMonth();
					}
				}
				for(Invoice e:listInvoice) {
					if(e.getPhoneNumber() == phone_number) {
						currentInvoice = e.getInvoice() - cost_per_month;
					}
				}
					
				PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_INVOICE, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, String.valueOf(currentInvoice));
				ps.setString(2, String.valueOf(phone_number));				
				ps.executeUpdate();				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			} catch (ClassNotFoundException el) {
				el.printStackTrace();
			}	
	}
	
}

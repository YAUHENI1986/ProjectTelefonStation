package by.htp.telephonestation.dao.impl;

import static by.htp.telephonestation.dao.util.DaoConstant.*;

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

public class InvoiceDaoSqlImpl implements InvoiceDao{
	
	private static final String SQL_INSERT_INVOICE = "INSERT INTO invoice_and_connected_services (subscriber, invoice, connected_services, phone_number, status) VALUES (?, ?, ?, ?, ?)";

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

}

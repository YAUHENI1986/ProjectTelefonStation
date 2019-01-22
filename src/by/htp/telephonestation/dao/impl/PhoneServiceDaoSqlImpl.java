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

import by.htp.telephonestation.dao.PhoneServiceDao;
import by.htp.telephonestation.entity.PhoneService;

public class PhoneServiceDaoSqlImpl implements PhoneServiceDao{
	
	private static final String SQL_INSERT_SERVICES = "INSERT INTO tariffs_and_services (status, type, description, cost_per_month) VALUES (?, ?, ?, ?)";
	private static final String SQL_EDIT_SERVICE_BY_ID = "UPDATE tariffs_and_services SET status=?, type=?, description=?, cost_per_month=?  WHERE id=?";


	@Override
	public void addServices(PhoneService phoneService) {		
		try {Class.forName("com.mysql.cj.jdbc.Driver");			
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
				
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT_SERVICES, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, phoneService.getStatus());
				ps.setString(2, phoneService.getType());
				ps.setString(3, phoneService.getDescriprion());
				ps.setString(4, String.valueOf(phoneService.getCostPerMonth()));
				ps.executeUpdate();				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			} catch (ClassNotFoundException el) {
				el.printStackTrace();
			}		
	}

	@Override
	public List<PhoneService> readAll() {
		List<PhoneService> phoneServices = new ArrayList<>();
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from tariffs_and_services");
			
			PhoneService phoneService = null;
			while(rs.next()) {
				phoneService = new PhoneService(rs.getInt("id"), rs.getString("status"), rs.getString("type"), rs.getString("description"), rs.getDouble("cost_per_month"));
				phoneServices.add(phoneService);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}		
		return phoneServices;	
	}

	@Override
	public void editServiceById(int id, String status, String type, String description, double costPerMonth) {
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement ps = conn.prepareStatement(SQL_EDIT_SERVICE_BY_ID);
			ps.setString(1, status);
			ps.setString(2, type);
			ps.setString(3, description);
			ps.setString(4, String.valueOf(costPerMonth));
			ps.setString(5, String.valueOf(id));
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}		
	}

}

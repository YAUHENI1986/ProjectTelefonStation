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

import by.htp.telephonestation.dao.SubscriberDao;
import by.htp.telephonestation.entity.Subscriber;

public class SubscriberDaoSqlImpl implements SubscriberDao{
	
	private static final String SQL_INSERT_SUBSCRIBER = "INSERT INTO subscribers (name, surname, adress, personal_number_passport) VALUES (?, ?, ?, ?)";

	@Override
	public List<Subscriber> readAll() {
		
		List<Subscriber> subscribers = new ArrayList<>();
		
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from subscribers");
			
			Subscriber subscriber = null;
			while(rs.next()) {
				subscriber = new Subscriber(rs.getInt("unique_number"), rs.getString("name"), rs.getString("surname"), rs.getString("adress"), rs.getInt("personal_number_passport"));
				subscribers.add(subscriber);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}		
		return subscribers;
	}

	@Override
	public void addSubscriber(Subscriber subscriber) {
		List<Subscriber> list = readAll();
		int count = 0;
		for(Subscriber e: list) {
			if(e.getName().equals(subscriber.getName()) && e.getSurname().equals(subscriber.getSurname()) && e.getPersonalNumberPassport()==subscriber.getPersonalNumberPassport()) {
				System.out.println("Совпадение");
				count--;
			}
			count++;
		}
		System.out.println("--------------"+count + "uh" + list.size());
		if(count == list.size()) {
			try {Class.forName("com.mysql.cj.jdbc.Driver");			
			try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
				
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT_SUBSCRIBER, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, subscriber.getName());
				ps.setString(2, subscriber.getSurname());
				ps.setString(3, subscriber.getAdress());
				ps.setString(4, String.valueOf(subscriber.getPersonalNumberPassport()));
				ps.executeUpdate();				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			} catch (ClassNotFoundException el) {
				el.printStackTrace();
			}	
		} else {
			throw new RuntimeException();
		}
	}
}

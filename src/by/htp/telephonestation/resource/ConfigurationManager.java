package by.htp.telephonestation.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("by.htp.telephonestation.resource.config");
	/*
	 * ����� ��������� ���������� �� ����� config.properties
	 */
	private ConfigurationManager() { }
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}

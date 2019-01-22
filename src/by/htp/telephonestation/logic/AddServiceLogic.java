package by.htp.telephonestation.logic;

public class AddServiceLogic {
	
	public static boolean checkNullEmptyLogin(String type_list, String status_list, String description, String cost_per_month) {
		return type_list!=null && type_list!="" && status_list!=null && status_list!="" && description!=null && description!="" && cost_per_month!=null && cost_per_month!="" && checkValidate(cost_per_month);
	}
	
	private static boolean checkValidate(String cost_per_month) throws NumberFormatException{
		try {
			Double.parseDouble(cost_per_month);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

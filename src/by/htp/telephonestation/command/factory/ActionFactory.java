package by.htp.telephonestation.command.factory;

import javax.servlet.http.HttpServletRequest;

import by.htp.telephonestation.command.ActionCommand;
import by.htp.telephonestation.command.EmptyCommandImpl;
import by.htp.telephonestation.command.client.CommandEnum;
import by.htp.telephonestation.resource.MessageManager;



public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommandImpl();
		// извлечение имени команды из запроса
		String action = request.getParameter("command");
		System.out.println(action);
		if (action == null || action.isEmpty()) {
			/*
			 * если команда не задана в текущем запросе
			 */
			return current;
		}
		/*
		 * получение объекта, соответствующего команде
		 */
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}

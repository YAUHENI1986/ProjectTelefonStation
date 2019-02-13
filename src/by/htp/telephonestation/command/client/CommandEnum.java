package by.htp.telephonestation.command.client;

import by.htp.telephonestation.command.ActionCommand;
import by.htp.telephonestation.command.AddPlugCommandImpl;
import by.htp.telephonestation.command.AddServiceCommandImpl;
import by.htp.telephonestation.command.AddSubcriberCommandImpl;
import by.htp.telephonestation.command.AdminEntryCommandImpl;
import by.htp.telephonestation.command.EditServiceCommandImpl;
import by.htp.telephonestation.command.JspAddServiceCommandImpl;
import by.htp.telephonestation.command.JspAddSubcribersCommandImpl;
import by.htp.telephonestation.command.JspBalanceAndServicesCommandImpl;
import by.htp.telephonestation.command.JspEditServiceCommandImpl;
import by.htp.telephonestation.command.JspPlugServiceCommandImpl;
import by.htp.telephonestation.command.JspTopUpBalanceCommandImpl;
import by.htp.telephonestation.command.ListInvoicesCommandImpl;
import by.htp.telephonestation.command.ListPhoneServicesCommandImpl;
import by.htp.telephonestation.command.ListSubcribersCommandImpl;
import by.htp.telephonestation.command.LoginAdminCommandImpl;
import by.htp.telephonestation.command.LogoutAdminCommandImpl;
import by.htp.telephonestation.command.MainAdminCommandImpl;
import by.htp.telephonestation.command.UserEntryCommandImpl;

public enum CommandEnum {
	LOGIN_ADMIN {
		{
			this.command = new LoginAdminCommandImpl();
		}
	},
	LOGOUT_ADMIN {
		{
			this.command = new LogoutAdminCommandImpl();
		}
	},
	USER_ENTRY {
		{
			this.command = new UserEntryCommandImpl();
		}
	},
	ADMIN_ENTRY {
		{
			this.command = new AdminEntryCommandImpl();
		}
	},
	LIST_SUBSCRIBERS {
		{
			this.command = new ListSubcribersCommandImpl();
		}
	},
	LIST_PHONE_SERVICES {
		{
			this.command = new ListPhoneServicesCommandImpl();
		}
	},
	LIST_INVOICES {
		{
			this.command = new ListInvoicesCommandImpl();
		}
	},
	ADD_SUBSCRIBER {
		{
			this.command = new AddSubcriberCommandImpl();
		}
	},
	ADD_SERVICE {
		{
			this.command = new AddServiceCommandImpl();
		}
	},
	ADD_PLUG {
		{
			this.command = new AddPlugCommandImpl();
		}
	},
	EDIT_SERVICE {
		{
			this.command = new EditServiceCommandImpl();
		}
	},
	JSP_ADD_SUBSCRIBER {
		{
			this.command = new JspAddSubcribersCommandImpl();
		}
	},
	JSP_ADD_SERVICE {
		{
			this.command = new JspAddServiceCommandImpl();
		}
	},
	JSP_EDIT_SERVICE {
		{
			this.command = new JspEditServiceCommandImpl();
		}
	},
	JSP_PLUG_SERVICE {
		{
			this.command = new JspPlugServiceCommandImpl();
		}
	},
	JSP_BALANCE_AND_SERVICES {
		{
			this.command = new JspBalanceAndServicesCommandImpl();
		}
	},
	JSP_TOP_UP_BALANCE {
		{
			this.command = new JspTopUpBalanceCommandImpl();
		}
	},
	MAIN_ADMIN {
		{
			this.command = new MainAdminCommandImpl();
		}
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}
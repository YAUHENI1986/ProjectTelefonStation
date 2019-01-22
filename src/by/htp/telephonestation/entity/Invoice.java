package by.htp.telephonestation.entity;

public class Invoice {
	
	private int subscriber;
	private int invoice;
	private String connectedServices;
	private int phoneNumber;
	private String status;
	
	public Invoice() {}

	public Invoice(int subscriber, int invoice, String connectedServices, int phoneNumber, String status) {
		super();
		this.subscriber = subscriber;
		this.invoice = invoice;
		this.connectedServices = connectedServices;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public int getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(int subscriber) {
		this.subscriber = subscriber;
	}

	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public String getConnectedServices() {
		return connectedServices;
	}

	public void setConnectedServices(String connectedServices) {
		this.connectedServices = connectedServices;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Invoices [subscriber=" + subscriber + ", invoice=" + invoice + ", connectedServices="
				+ connectedServices + ", phoneNumber=" + phoneNumber + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectedServices == null) ? 0 : connectedServices.hashCode());
		result = prime * result + invoice;
		result = prime * result + phoneNumber;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + subscriber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (connectedServices == null) {
			if (other.connectedServices != null)
				return false;
		} else if (!connectedServices.equals(other.connectedServices))
			return false;
		if (invoice != other.invoice)
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subscriber != other.subscriber)
			return false;
		return true;
	}

}

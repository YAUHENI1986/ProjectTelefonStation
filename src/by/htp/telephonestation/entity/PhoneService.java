package by.htp.telephonestation.entity;

public class PhoneService {
	
	private int id;
	private String status;
	private String type;
	private String descriprion;
	private double costPerMonth;
	
	public PhoneService() {}

	public PhoneService(int id, String status, String type, String descriprion, double costPerMonth) {
		this.id = id;
		this.status = status;
		this.type = type;
		this.descriprion = descriprion;
		this.costPerMonth = costPerMonth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescriprion() {
		return descriprion;
	}

	public void setDescriprion(String descriprion) {
		this.descriprion = descriprion;
	}

	public double getCostPerMonth() {
		return costPerMonth;
	}

	public void setCostPerMonth(double costPerMonth) {
		this.costPerMonth = costPerMonth;
	}

	@Override
	public String toString() {
		return "PhoneService [id=" + id + ", status=" + status + ", type=" + type + ", descriprion=" + descriprion
				+ ", costPerMonth=" + costPerMonth + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costPerMonth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descriprion == null) ? 0 : descriprion.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PhoneService other = (PhoneService) obj;
		if (Double.doubleToLongBits(costPerMonth) != Double.doubleToLongBits(other.costPerMonth))
			return false;
		if (descriprion == null) {
			if (other.descriprion != null)
				return false;
		} else if (!descriprion.equals(other.descriprion))
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}	
	
}

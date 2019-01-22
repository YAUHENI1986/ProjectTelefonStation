package by.htp.telephonestation.entity;

public class Subscriber {
	
	private int uniqueNumber;
	private String name;
	private String surname;
	private String adress;
	private int personalNumberPassport;
	
	public Subscriber() {}

	public Subscriber(int uniqueNumber, String name, String surname, String adress, int personalNumberPassport) {
		super();
		this.uniqueNumber = uniqueNumber;
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.personalNumberPassport = personalNumberPassport;
	}	

	public int getUniqueNumber() {
		return uniqueNumber;
	}

	public void setUniqueNumber(int uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPersonalNumberPassport() {
		return personalNumberPassport;
	}

	public void setPersonalNumberPassport(int personalNumberPassport) {
		this.personalNumberPassport = personalNumberPassport;
	}

	@Override
	public String toString() {
		return "Subscriber [uniqueNumber=" + uniqueNumber + ", name=" + name + ", surname=" + surname + ", adress="
				+ adress + ", personalNumberPassport=" + personalNumberPassport + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + personalNumberPassport;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + uniqueNumber;
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
		Subscriber other = (Subscriber) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personalNumberPassport != other.personalNumberPassport)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (uniqueNumber != other.uniqueNumber)
			return false;
		return true;
	}
	
}

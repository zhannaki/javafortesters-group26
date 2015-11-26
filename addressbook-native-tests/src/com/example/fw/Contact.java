package com.example.fw;

public class Contact {

	private String firstname;
	private String lastname;

	public Contact setFirstname(String firstname) {
		this.firstname = firstname;
		// TODO Auto-generated method stub
		return this;
	}

	public Contact setLastname(String lastname) {
		this.lastname = lastname;
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

}

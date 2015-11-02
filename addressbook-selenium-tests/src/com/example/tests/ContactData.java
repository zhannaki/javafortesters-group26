package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String officePhone;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String newGroup;
	public String address2;
	public String phone2;

	public ContactData(String firstName, String lastName, String address, String homePhone, String mobilePhone,
			String officePhone, String email, String email2, String bday, String bmonth, String byear, String newGroup,
			String address2, String phone2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.officePhone = officePhone;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.newGroup = newGroup;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	
	public ContactData(){
	}

	@Override
	public int compareTo(ContactData other) {
		int compareTo = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
			if (compareTo == 0){
				return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
			} else {
				return compareTo;
			}
	}

	@Override
	public String toString() {
		return "Contact [" + firstName + " " + lastName + "]";
	}

	@Override
	public int hashCode() {
	//	final int prime = 31;
		int result = 1;
	//	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	//	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	
	
}
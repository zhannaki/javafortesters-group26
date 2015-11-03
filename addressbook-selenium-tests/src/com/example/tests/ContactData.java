package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String officePhone;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String newGroup;
	private String address2;
	private String phone2;

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

	// -------------- getters 
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getNewGroup() {
		return newGroup;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
	
	// ------------ setters	
	

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withOfficePhone(String officePhone) {
		this.officePhone = officePhone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBday(String bday) {		
		this.bday = bday;
		return this;
	}

	public ContactData withbmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withbyear(String byear) {		
		this.byear = byear;
		return this;
	}

	public ContactData withNewGroup(String newGroup) {		
		this.newGroup = newGroup;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
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
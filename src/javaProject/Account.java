package javaProject;

import java.util.Objects;

public abstract class Account {
	protected String ID, password, name, phone, address, email;
	
	public Account() {}
	public Account(String iD, String password, String name, String phone, String address, String email) {
		ID = iD;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
	public Account(String iD) {
		ID = iD;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(ID, other.ID);
	}
	
	boolean passCheck(String word) {
		return password.equals(word);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getID() {
		return ID;
	}
	
	
}

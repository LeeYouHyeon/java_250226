package account;

public class Account {
	private String id; // 기본키
	private String password;
	private String name;
	private String phone;
	private String address;
	private String email;
	
	public Account() {}
	public Account(String id, String password, String name, String phone, String address, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	// 비밀번호가 맞는지 확인
	public boolean passCheck(String word) {
		return password.equals(word);
	}
	
	// 필요하면 메서드 추가
	
	// getter/setter
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
	public String getId() {
		return id;
	}
}

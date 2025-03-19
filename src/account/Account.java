package account;

public class Account {
	private String id;
	private String password;
	private String email;
	// 필요하면 개인정보 추가
	
	public Account(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	// 비밀번호가 맞는지 확인
	public boolean equals(String word) {
		return password.equals(word);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

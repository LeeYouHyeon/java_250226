package javaProject;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Account {
	String labAddress;
	List<String> subjects = new ArrayList<>();

	public Professor() {
		super();
	}

	public Professor(String iD) {
		super(iD);
	}

	public Professor(String iD, String password, String name, String phone, String address, String email,
			String labAddress) {
		super(iD, password, name, phone, address, email);
		this.labAddress = labAddress;
	}

	@Override
	public String toString() {
		return "기본 정보 확인 \r\n교수명 :" + name + " / 연락처 : " + super.phone + " / 연구실 : " + super.address + "\r\ne-mail : "
				+ super.email;
	}
	void registerSubject(String sub) {
		subjects.add(sub);
	}

	void deleteSubject(String sub) {
		subjects.remove(sub);
	}

	public String getLabAddress() {
		return labAddress;
	}

	public void setLabAddress(String labAddress) {
		this.labAddress = labAddress;
	}

	public List<String> getSubjects() {
		return subjects;
	}

}

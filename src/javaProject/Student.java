package javaProject;

import java.util.ArrayList;
import java.util.List;

public class Student extends Account {
	String stdCode;
	List<String> subjectList = new ArrayList<>();

	public Student() {
		super();
	}
	public Student(String iD) {
		super(iD);
	}

	public Student(String iD, String password, String name, String phone, String address, String email, String stdCode,
			List<String> subjectList) {
		super(iD, password, name, phone, address, email);
		this.stdCode = stdCode;
		this.subjectList = subjectList;
	}
	
	@Override
	public String toString() {
		//수강 과목이 없는 경우 추가하기
		return super.name+" 학생의  학번 : " + stdCode + "\r\n수강 과목 리스트\r\n" + subjectList + "]";
	}
	
	boolean isRegistered(String sub) {
		return subjectList.contains(sub);
	}
	void insertSubject(String sub) {
		subjectList.add(sub);
	}
	void deleteSubject(String sub) {
		subjectList.remove(sub);
	}
	
	public String getStdCode() {
		return stdCode;
	}
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}
	public List<String> getSubjectList() {
		return subjectList;
	}
	
	
}

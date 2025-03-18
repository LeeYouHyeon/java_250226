package studentManager_List;

import java.util.List;

public class Student {
	// 학번, 이름, 나이, 전화번호, 주소, 수강과목
	private String stdCode, stdName, stdPhone, stdAddress;
	private int stdAge;
	private List<Subject> subjects;
	
	// 생성자
	public Student() {;}
	public Student(String stdCode, String stdName, String stdPhone, String stdAddress, int stdAge,
			List<Subject> subjects) {
		super();
		this.stdCode = stdCode;
		this.stdName = stdName;
		this.stdPhone = stdPhone;
		this.stdAddress = stdAddress;
		this.stdAge = stdAge;
		this.subjects = subjects;
	}
	public Student(String stdCode, String stdName) {
		super();
		this.stdCode = stdCode;
		this.stdName = stdName;
	}

	// 과목을 받으면 수강한 과목인지 확인
	public boolean contains(Subject subject) {
		for(Subject sub : subjects) {
			if(sub.getSubCode().equals(subject.getSubCode())) {
				return true;
			}
		}
		return false;
	}
	
	// 수강신청
	public void insertSubject(Subject s) {
		if(contains(s)) {
			System.out.println("이미 수강한 과목입니다.");
			return;
		}
		subjects.add(s);
		System.out.println("신청되었습니다.");
	}
	
	// 수강신청 취소
	public void cancelSubject(Subject s) {
		if(subjects.remove(s)) {
			System.out.println("취소되었습니다.");
		} else {
			System.out.println("신청하지 않은 과목입니다.");
		}
	}
	
	// getter/setter
	public String getStdCode() {
		return stdCode;
	}
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public int getStdAge() {
		return stdAge;
	}
	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}

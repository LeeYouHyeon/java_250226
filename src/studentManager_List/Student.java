package studentManager_List;

import java.util.List;

public class Student {
	// �й�, �̸�, ����, ��ȭ��ȣ, �ּ�, ��������
	private String stdCode, stdName, stdPhone, stdAddress;
	private int stdAge;
	private List<Subject> subjects;
	
	// ������
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

	// ������ ������ ������ �������� Ȯ��
	public boolean contains(Subject subject) {
		for(Subject sub : subjects) {
			if(sub.getSubCode().equals(subject.getSubCode())) {
				return true;
			}
		}
		return false;
	}
	
	// ������û
	public void insertSubject(Subject s) {
		if(contains(s)) {
			System.out.println("�̹� ������ �����Դϴ�.");
			return;
		}
		subjects.add(s);
		System.out.println("��û�Ǿ����ϴ�.");
	}
	
	// ������û ���
	public void cancelSubject(Subject s) {
		if(subjects.remove(s)) {
			System.out.println("��ҵǾ����ϴ�.");
		} else {
			System.out.println("��û���� ���� �����Դϴ�.");
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

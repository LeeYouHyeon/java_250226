package examStd;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Student {
	private String stdNum, stdName, stdAge, stdPhone, stdAddress;
	private int total;
	private ArrayList<Subject> subject = new ArrayList<Subject>();
	
	public Student() {
	}
	public Student(String stdNum) {
		this.stdNum = stdNum;
	}
	public Student(String stdNum, String stdName, String stdAge, String stdPhone, String stdAddress) {
		this.stdNum = stdNum;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdPhone = stdPhone;
		this.stdAddress = stdAddress;
	}
	
	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", stdName=" + stdName + ", stdAge=" + stdAge + ", stdPhone=" + stdPhone
				+ ", stdAddress=" + stdAddress + ", total=" + total + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(stdNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(stdNum, other.stdNum);
	}
	
	// ���� �ʿ��� �޼��� �߰�
	// 1. subject�� ������ �߰��ϱ� : ������û
	// 2. subject���� ������ �����ϱ� : ����öȸ
	// 3. subject�� ������ ��ȸ�ϱ� : ���� ��ȸ (�����߰�)
	// 4. subject ����ϱ�
	
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdAge() {
		return stdAge;
	}
	public void setStdAge(String stdAge) {
		this.stdAge = stdAge;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<Subject> getSubject() {
		return subject;
	}
	public void setSubject(ArrayList<Subject> subject) {
		this.subject = subject;
	}
	public void subjectPrint() {
		if(subject == null || subject.isEmpty()) {
			System.out.println("�������� ������ �����ϴ�.");
		} else {
			System.out.println("--" + stdNum + "�� ������û���--");
			for(Subject s : subject) {
				System.out.println(s);
			}
			System.out.println("----------------");
		}
		
	}
	public void insertSubject(Subject temp) {
		// subject�� �ԷµǸ� ����Ʈ�� �߰�
		if(subject.contains(temp)) {
			System.out.println("�̹� ������ �����Դϴ�.");
			return;
		}
		subject.add(temp);
		System.out.println("������û �Ϸ�");
	}
	public void deleteSub(String subNum) {
		// ���� ��� ��ȣ�� �ָ� ���� ����
		System.out.println(subject.remove(new Subject(subNum)) ? "���� ��� �Ϸ�" : "��û���� ���� �����Դϴ�.");
	}
	
	// ���� ����ϱ�
	// � ����? (�����ȣ) / �� ��? (����)
	// �ش� ���� ��� �� ������ ����
	public void insertScore(String subNum, Scanner scan) {
		//TODO
		for(Subject s : subject) {
			if(s.equals(new Subject(subNum))) {
				System.out.print("����> ");
				int score = scan.nextInt();
				s.setSubScore(score);
				total += score;
				System.out.println("�Է� �Ϸ�");
				return;
			}
		}
		
		System.out.println("�������� ���� �����Դϴ�.");
	}
}
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
	
	// 내가 필요한 메서드 추가
	// 1. subject에 데이터 추가하기 : 수강신청
	// 2. subject에서 데이터 삭제하기 : 수강철회
	// 3. subject의 데이터 조회하기 : 과목 조회 (성적추가)
	// 4. subject 출력하기
	
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
			System.out.println("수강중인 과목이 없습니다.");
		} else {
			System.out.println("--" + stdNum + "님 수강신청목록--");
			for(Subject s : subject) {
				System.out.println(s);
			}
			System.out.println("----------------");
		}
		
	}
	public void insertSubject(Subject temp) {
		// subject가 입력되면 리스트에 추가
		if(subject.contains(temp)) {
			System.out.println("이미 수강한 과목입니다.");
			return;
		}
		subject.add(temp);
		System.out.println("수강신청 완료");
	}
	public void deleteSub(String subNum) {
		// 수강 취소 번호를 주면 수강 삭제
		System.out.println(subject.remove(new Subject(subNum)) ? "수강 취소 완료" : "신청하지 않은 과목입니다.");
	}
	
	// 성적 등록하기
	// 어떤 과목? (과목번호) / 몇 점? (점수)
	// 해당 성적 등록 후 점수에 누적
	public void insertScore(String subNum, Scanner scan) {
		//TODO
		for(Subject s : subject) {
			if(s.equals(new Subject(subNum))) {
				System.out.print("점수> ");
				int score = scan.nextInt();
				s.setSubScore(score);
				total += score;
				System.out.println("입력 완료");
				return;
			}
		}
		
		System.out.println("수강하지 않은 과목입니다.");
	}
}
package day16_StudentManager_List;

import java.util.Scanner;

public interface TODO {
	// 학생 등록
	public void insertStudent(Scanner scan);
	
	// 학생 목록 출력
	public void printStudents();
	
	// 학생 검색(기본정보 출력)
	public void searchStudent(Scanner scan);
	
	// 학생 정보 수정
	public void updateStudent(Scanner scan);
	
	// 학생 삭제
	public void deleteStudent(Scanner scan);
	
	// 과목 목록 출력
	public void printSubjects();
	
	// 수강신청
	public void insertSubject(Scanner scan);
	
	// 수강철회
	public void deleteSubject(Scanner scan);
	
	// 과목별 신청자 리스트
	// 과목을 입력받아 신청한 학생들의 기본정보 출력
	public void studentsOfSubject(Scanner scan);
	
	// 학생별 성적표 출력
	// 성적 평균도 출력
	public void printStudentScore(Scanner scan);
}

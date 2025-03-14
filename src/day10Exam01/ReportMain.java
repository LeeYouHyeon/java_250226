package day10Exam01;

import java.util.Scanner;

public class ReportMain {

	public static void main(String[] args) {
		// MultiArrayEx01을 Student 클래스를 이용해 구현
		
		System.out.print("성적을 입력할 학생 수를 입력하세요.> ");
		Scanner scan = new Scanner(System.in);
		int numOfStudents = scan.nextInt();
		
		// 학생 정보를 받아 이름, 점수 계산
		// 총점, 평균은 점수 setter에 내장되어있음
		Report[] students = new Report[numOfStudents];
		System.out.println("학생의 이름, 국어, 영어, 수학 점수를 입력해주세요.");
		for (int i = 0; i < numOfStudents; i++) {
			// 입력
			System.out.println(i + 1 + "번째 학생");
			scan.nextLine(); // nextInt()에서 처리되지 않은 엔터키를 버림
			
			String name;
			int kor, eng, math;
			
			System.out.print("이름> ");
			name = scan.nextLine();
			System.out.print("국어 점수> ");
			kor = scan.nextInt();
			System.out.print("영어 점수> ");
			eng = scan.nextInt();
			System.out.print("수학 점수> ");
			math = scan.nextInt();
			
			students[i] = new Report(name, kor, eng, math);
		}
		scan.close();
		
		// 총점을 기준으로 석차 계산
		for(Report a : students) {
			for(Report b : students) {
				if(a.sum() < b.sum()) {
					a.rankDown();
				}
			}
		}
		
		System.out.println("=============================================");
		System.out.printf("이름\t국어\t영어\t수학\t총점\t평균\t석차\n");
		for(Report s : students) {
			s.print();
		}
	}

}

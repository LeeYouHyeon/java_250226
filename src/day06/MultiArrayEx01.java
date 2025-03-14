package day06;

import java.util.Scanner;

public class MultiArrayEx01 {
	public static void main(String[] args) {
		/* 성적표
		 * 몇 명의 성적을 입력할 지 결정 > 3
		 * 이름, 국어, 영어, 수학, 총점, 평균, 석차
		 * 석차는 총점 기준
		 * "\t" : 탭
		 * */

		// 입력받을 학생 수 결정
		System.out.print("성적을 입력할 학생 수를 입력하세요.> ");
		Scanner scan = new Scanner(System.in);
		int numOfStudents = scan.nextInt();

		String	name[]	= new String[numOfStudents];
		int		kor[]	= new int[numOfStudents],
				eng[] 	= new int[numOfStudents],
				math[]	= new int[numOfStudents],
				sum[]	= new int[numOfStudents],
				rank[]	= new int[numOfStudents];
		double	avg[]	= new double[numOfStudents];

		// 학생 정보를 입력받아 이름, 점수, 총점, 평균 계산
		System.out.println("학생의 이름, 국어, 영어, 수학 점수를 입력해주세요.");
		for (int i = 0; i < numOfStudents; i++) {
			// 입력
			System.out.println(i + 1 + "번 학생");
			scan.nextLine(); // nextInt()에서 처리되지 않은 엔터키를 버림
			
			System.out.print("이름> ");
			name[i] = scan.nextLine();
			System.out.print("국어 점수> ");
			kor[i] = scan.nextInt();
			System.out.print("영어 점수> ");
			eng[i] = scan.nextInt();
			System.out.print("수학 점수> ");
			math[i] = scan.nextInt();

			// 총점, 평균 계산
			sum[i] = kor[i] + eng[i] + math[i];
			avg[i] = sum[i] / 3.0;
			rank[i] = 1;
			System.out.println();
		}
		scan.close();

		// 총점을 기준으로 석차를 계산
		for (int i = 0; i < numOfStudents; i++) {
			for (int j = 0; j < numOfStudents; j++) {
				if (sum[i] < sum[j]) {
					rank[i]++;
				}
			}
		}

		System.out.println("=============================================");
		// 입력받은 순서대로 출력
		System.out.printf("이름\t국어\t영어\t수학\t총점\t평균\t석차\n");
		for (int i = 0; i < numOfStudents; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
					name[i], kor[i], eng[i], math[i], sum[i], avg[i], rank[i]);
		}
	}
}

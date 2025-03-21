package day02;

import java.util.Scanner;

public class If02 {

	public static void main(String[] args) {
		/*
		 * 국어, 영어, 수학 점수를 입력받아 합계, 평균, pass 여부를 출력
		 * 80 이상이면 합격, if 사용
		 * 점수를 입력받을 때 100점보다 크거나 0보다 작으면 오류 출력 후 즉시 종료
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("국어, 영어, 수학 점수를 순서대로, 띄어쓰기로 구분하여 입력해주세요.");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
		if (kor > 100 || kor < 0) {
			System.out.println("국어 점수가 잘못되었습니다.");
		} else if (eng > 100 || eng < 0) {
			System.out.println("영어 점수가 잘못되었습니다.");
		} else if (math > 100 || math < 0) {
			System.out.println("수학 점수가 잘못되었습니다.");
		} else {
			int sum = kor + eng + math;
			double avg = sum / 3.0;
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			
			if (avg >= 80) {
				System.out.println("합격");
			}
		}
		
		scan.close();

		
		//main에선 return 지양
//		int kor, eng, math;
//		Scanner scan = new Scanner(System.in);
//
//		System.out.print("국어 점수를 입력해주세요.> ");
//		kor = scan.nextInt();
//		if (kor < 0 || kor > 100) {
//			System.out.println("잘못된 입력입니다.");
//			scan.close();
//			return;
//		}
//		System.out.print("영어 점수를 입력해주세요.> ");
//		eng = scan.nextInt();
//		if (eng < 0 || eng > 100) {
//			System.out.println("잘못된 입력입니다.");
//			scan.close();
//			return;
//		}
//		System.out.print("수학 점수를 입력해주세요> ");
//		math = scan.nextInt();
//		if (math < 0 || math > 100) {
//			System.out.println("잘못된 입력입니다.");
//			scan.close();
//			return;
//		}
//
//		int sum = kor + eng + math;
//		double avg = sum / 3.0;
//
//		System.out.println("합계 : " + sum);
//		System.out.println("평균 : " + avg);
//		if (avg > 100 || avg < 0) {
//			System.out.println("알 수 없는 오류");
//		} else if (avg >= 80) {
//			System.out.println("합격");
//		} else if (avg >= 0) {
//			System.out.println("불합격");
//		}
//		scan.close();
	}

}

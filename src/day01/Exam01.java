package day01;

public class Exam01 {
	public static void main(String[] args) {
		/* 카페에 제출
		 * 국어, 영어, 수학 점수 입력
		 * 합계와 평균을 출력
		 * 
		 * 조건 선택 연산자를 이용하여
		 * 평균이 80점 이상이면 합격, 아니면 불합격
		 */
		int kor, eng, math, sum;
		double average;
		String pass;
		
		// 이후 입력받는 코드로 변경
		kor = 78;
		eng = 96;
		math = 156;
		
		sum = kor + eng + math;
		average = (double)sum/3;
		pass = (average >= 80) ? "합격" : "불합격";
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + average);
		System.out.println(pass);
		
		
		System.out.println("---------------");
		//if (조건식) { 실행문; } else { 실행문; }
		//평균이 100보다 크거나 0보다 작다면 오류
		//80점 이상이면 우수, 60점 이상이면 합격, 나머지는 불합격
		
		//예시답안 1
		if(average > 100 || average < 0) {
			System.out.println("오류");
		} else if(average >= 80) {
			System.out.println("우수");
		} else if(average >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		//예시답안 2
		//조금 더 문제의 아이디어에 비슷한 접근
		System.out.println("---------------");
		if(average > 100 || average < 0) {
			System.out.println("오류");
		} else {
			if(average >= 80) {
				System.out.println("우수");
			} else if(average >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
			
		}
		
	}
}
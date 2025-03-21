package day09;

public class Exam01 {
	public static void main(String[] args) {
		/* 메서드로 작업
		 * 두 정수의 값이 주어질 때
		 * 두 정수 사이의 모든 정수의 합을 리턴하는 메서드
		 * */
		Exam01 e1 = new Exam01();

		System.out.println(e1.sumBetween(3, 5));
		System.out.println(e1.sumRecur(3, 3));
	}
	
	// 재귀 메서드를 입력의 조건을 제한하는 용도로만 사용
	public int sumBetween(int num1, int num2) {
		if (num1 > num2) {
			return sumBetween(num2, num1);
		}

		int answer = 0;
		for (int i = num1; i <= num2; i++) {
			answer += i;
		}

		return answer;
	}

	// 완전한 재귀 메서드로 구현
	public int sumRecur(int num1, int num2) {
		if (num1 > num2) {
			return sumRecur(num2, num1);
		}

		return (num1 == num2) ? num1 : num1 + sumRecur(num1 + 1, num2);
	}
}

package day02;

public class Switch01 {

	public static void main(String[] args) {
		/*
		 * switch(변수 / 값) { case 값 : 실행문; break; case 값 : 실행문; break; case 값 : 실행문;
		 * break; case 값 : 실행문; break; ... default : 실행문; } break;는 구문을 빠져나갈 때 사용, 보통
		 * 조건문을 사용한다.(switch는 자체적으로 조건문을 포함함)
		 */

		// 짝수 홀수 switch 구문으로 실행
		int num;

		num = 2;

		switch (num % 2) {
			case 0:
				System.out.println("짝수");
				break;
			case 1:
				System.out.println("홀수");
				break;
			default:
				System.out.println("잘못된 값입니다.");
		}

		System.out.println("----------------");

		/*
		 * num1의 값이 1, 2, 3이라고 가정 1이면 1칸 전진, 2면 2칸 전진, 3이면 3칸 전진 나머지 값은 다시 입력하라고 출력
		 */
		int num1;

		num1 = 2;

//		switch (num1) {
//			case 1:
//				System.out.println("한 칸 전진");
//				break;
//			case 2:
//				System.out.println("두 칸 전진");
//				break;
//			case 3:
//				System.out.println("세 칸 전진");
//				break;
//			default:
//				System.out.println("다시 입력하세요.");
//		}

		switch (num1) {
			case 1:
			case 2:
			case 3:
				System.out.println(num1 + "칸 전진");
				break;
			default:
				System.out.println("다시 입력하세요.");
		}

		System.out.println("----------------");
		/*
		 * 3월부터 봄, 6월부터 여름, 9월부터 가을, 12월부터 겨울
		 */
		int month = 13;

		switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.println("봄");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("여름");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("가을");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("겨울");
				break;
			default:
				System.out.println("잘못된 날짜입니다.");
		}

	}

}

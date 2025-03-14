package day03;

public class For02 {

	public static void main(String[] args) {
		// for 예제
		// 1부터 10까지 출력
		// for(초기화; 조건식; 증감식) {
		// 실행문;
		// }
		// 조건식은 참이어야 실행 (true가 될 수 있게 설정)
		// 초기화한 변수가 조건식을 만족하면 실행 -> 증감식(증가/감소)
		// 증가한 변수를 다시 조건식 비교 -> 만족하면 실행 -> 증감식(증가/감소)
		// ... 조건식 비교 -> 불만족하면 종료

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		System.out.println("-----------------");
		// 1부터 10까지 짝수만 출력
		for (int i = 1; i <= 5; i++) {
			System.out.println(2 * i);
		}
		
		System.out.println("-----------------");
		// 1부터 10까지의 합계 출력
		// 기본 자료형의 지역 변수는 반드시 초깃값이 있어야 한다. 숫자는 보통 0이나 1, 문자(String)는 null을 사용
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("-----------------");
		// 1~10의 짝수 합, 홀수 합을 각각 출력
		int even = 0;
		int odd = 0;
		
		for(int i = 1; i <= 10; i++) {
			switch(i%2) {
				case 0:
					even += i;
					break;
				default:
					odd += i;
			}
		}
		System.out.println("짝수 합 : " + even);
		System.out.println("홀수 합 : " + odd);
		
		System.out.println("-----------------");
	}

}

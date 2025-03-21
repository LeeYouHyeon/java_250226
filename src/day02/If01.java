package day02;

public class If01 {
	
	public static void main(String[] args) {
		/* 조건문 : if문, switch문
		 * if문 : 조건식을 주고, 조건식이 참이면 / 거짓이면 값을 주는 구조
		 * if(조건식){ 실행문; }
		 * if문에서 실행문이 한 줄이면 중괄호를 생략할 수 있다. (비추천)
		 * 실행문이 두 줄 이상이면 반드시 중괄호를 써야 한다.
		 * */
		
		// 1. num가 0보다 크면 양수, 0보다 작으면 음수, 0이면 0이라고 출력
		// 2. num이 짝수인지 홀수인지 출력
		int num;
		String sig, even;
		
		num = -2; // 임의의 값을 입력
		
		if(num > 0) {
			sig = "양수";
		} else if(num < 0) {
			sig = "음수";
		} else {
			sig = "0";
		}
		
		//------------------- : 여기까진 완성된 내용
		
		if(num % 2 == 0) {
			even = "짝수";
		} else {
			even = "홀수";
		}
		
		System.out.println(num);
		System.out.println(sig);
		System.out.println(even);
	}
	
}

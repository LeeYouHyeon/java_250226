package day02;

public class For01 {

	public static void main(String[] args) {
		/* 반복문 : 규칙적인 작업을 반복적으로 할 때 사용
		 * for, while, do~while
		 * - for, while 문은 동작 방식이 같음
		 * => 조건에 따라 조건이 맞지 않으면 한 번도 실행되지 않을 수 있음
		 * 
		 * do~while 문 : 조건에 맞지 않아도 한 번은 무조건 실행함
		 * 
		 * for(초기화; 조건식; 증감식) {
		 * 	실행문; 
		 * }
		 * - 초기화 : 실행문을 반복하기 위한 변수 초기화, 처음 한 번만 실행. 생략 가능
		 * - 조건식 : 반복을 결정하는 기능. 생략 가능
		 * - 증감식 : 조건식에서 사용하는 변수를 증감시켜 반복 횟수를 조절. 생략 가능
		 * */
		
		//for문, while문 네이밍
		//(이름): for() {}, (이름): while() {}
		a: for(;;) {
			for(;;) {
				break a;
			}
		}
		
		// 1~10의 랜덤 수를 5개 출력
//		for(int i = 1; i <= 5; i++) {
//			System.out.println((int)(10*Math.random()) + 1);
//		}
		
		// 1~10까지의 합계 출력
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}

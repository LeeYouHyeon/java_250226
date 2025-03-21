package day03;

public class While01 {

	public static void main(String[] args) {
		// while문
		/* while문은 for문과 순서가 동일한 구문
		 * for : 실행 횟수가 정해져 있는 경우 사용
		 * while : 실행 횟수가 일정하지 않은 경우 사용
		 * 
		 * while(조건식) { //조건식이 true일 때 반복
		 * 	실행문;
		 * }
		 * 실행문 안에 조건식이 바뀔 수 있는 변화가 있어야 함
		 * 
		 * */

		// 1부터 10까지 출력
		int i = 1;
		while (i <= 10) {
			System.out.println(i++);
		}

		System.out.println("--------------");
		// 1부터 10까지 중 짝수 출력
		i = 2;
		while (i <= 10) {
			System.out.println(i);
			i += 2;
		}
		
		System.out.println("--------------");
		
	}

}

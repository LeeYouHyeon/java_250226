package day07;

public class Method04 {
	
	/* 정수([2, 9] 중 하나)를 입력받아
	 * 정수에 해당하는 구구단을 출력하는 메서드
	 * 리턴 타입 : void
	 * 매개 변수 : int num
	 * */
	public static void times(int num) {
		if(num < 2 || num > 9) {
			System.out.println("지원하지 않는 숫자입니다.");
		} else {
			for(int i = 1; i <= 9; i++) {
				System.out.print(num + "*" + i + " = " + num*i + ' ');
			}
		}
	}
	
	/* 구구단 출력 메서드
	 * 
	 * */
	
	public static void times() {
		for(int i = 2; i <= 9; i++) {
			times(i);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		times();
	}
}

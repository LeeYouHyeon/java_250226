package day02;

public class MathClass {

	public static void main(String[] args) {
		// 수학 관련 기능이 있는 클래스
		// Math.(메서드)
		// Math.round() : 반올림 / Math.ceil() : 올림 / Math.floor() : 버림
		// 소수 자릿수는 무조건 0
		
		double num = 3.14258;
		//long roundNum = Math.round(num);
		int roundNum = (int)Math.round(num);
		System.out.println(roundNum);
		
		//double ceilNum = Math.ceil(num);
		int ceilNum = (int)Math.ceil(num);
		System.out.println(ceilNum);
		
		//double floorNum = Math.floor(num);
		int floorNum = (int)Math.floor(num);
		System.out.println(floorNum);
		
		//Math.max() : 최댓값 / Math.min() : 최솟값
		System.out.println(Math.max(3, 5));
		System.out.println(Math.min(6, 1));
		
		//Math.random() : [0, 1)의 랜덤값 리턴
		//(int)(Math.random()*count) + start
		//(int)Math.random()*count == 0 : 형변환이 곱셈보다 먼저이므로 반드시 괄호를 넣어줘야 함
		System.out.println((int)(Math.random()*10)); //0~9
		System.out.println((int)(Math.random()*10) + 1); //1~10
		System.out.println((int)(Math.random()*6) + 1); //1~6
	}

}

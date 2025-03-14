package day04;

public class StringEx01 {

	public static void main(String[] args) {
		// regNum의 주민등록번호를 참고하여
		// 생년월일과 성별을 출력
		
		String regNum = "990101-12344567";
		String regNum1 = "020101-4567896";
		
		System.out.println("1");
		System.out.println("생년월일 : " + regNum.substring(0, 6));
		System.out.println((int)(regNum.charAt(7))%2 == 0 ? "여자" : "남자");
		System.out.println("2");
		System.out.println("생년월일 : " + regNum1.substring(0, 6));
		System.out.println((int)(regNum1.charAt(7))%2 == 0 ? "여자" : "남자");
	}

}

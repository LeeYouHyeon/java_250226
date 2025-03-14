package day12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {
	public static void main(String[] args) {
		// LocalDateTime 클래스
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		
		// 객체를 String으로 변환
		String date = today.toString();
		
		// substring으로 날짜 / 시간으로 분리하여 출력
		
		int idx = date.indexOf("T");
		System.out.print(date.substring(0, idx) + "/");
		System.out.println(date.substring(idx + 1, date.indexOf('.')));
		System.out.println();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today));
		
		// 임의의 날짜 생성
		LocalDateTime birth = LocalDateTime.of(1994, 10, 13, 0, 0);
		System.out.println(dtf.format(birth));
	}
}

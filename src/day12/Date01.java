package day12;

import java.util.Calendar;

public class Date01 {
	public static void main(String[] args) {
		/* 날짜/시간 클래스
		 * Date 클래스(Deprecated) / Calendar 클래스 / LocalDateTime 클래스
		 * 
		 * Calendar : 추상 클래스 => new 객체를 생성할 수 없음.
		 * 	- 싱글턴 패턴 : 객체를 생성하지 않고 클래스명.getInstance() 메서드로 얻어옴 => static
		 * 
		 * */
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		System.out.println(c.get(Calendar.MONTH) + 1);		//0~11
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));	//1(일)~7(토)
		
		// 2025-03-14(금)
//		System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH) + "("
//				+ new char[] {'일', '월', '화', '수', '목', '금', '토'}[c.get(Calendar.DAY_OF_WEEK) - 1] + ")");
		
		System.out.println(String.format("%d-%02d-%d(%c)",
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH),
				new char[] {'일', '월', '화', '수', '목', '금', '토'}[c.get(Calendar.DAY_OF_WEEK) - 1]));
		System.out.println();
		
		System.out.println(String.format("%s %d시 %d분 %02d초", 
				(c.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후"),
				c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND)));
		
		
	}
}

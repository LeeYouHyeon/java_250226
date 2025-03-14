package day12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {
	public static void main(String[] args) {
		// LocalDateTime Ŭ����
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		
		// ��ü�� String���� ��ȯ
		String date = today.toString();
		
		// substring���� ��¥ / �ð����� �и��Ͽ� ���
		
		int idx = date.indexOf("T");
		System.out.print(date.substring(0, idx) + "/");
		System.out.println(date.substring(idx + 1, date.indexOf('.')));
		System.out.println();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today));
		
		// ������ ��¥ ����
		LocalDateTime birth = LocalDateTime.of(1994, 10, 13, 0, 0);
		System.out.println(dtf.format(birth));
	}
}

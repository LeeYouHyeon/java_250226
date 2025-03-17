package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class List03 {
	public static void main(String[] args) {
		/* 오늘 하루 일과(String)를 저장하는 list를 생성
		 * 출력 => 향상된 for / iterator
		 * */
		List<String> day = new ArrayList<String>();
		for (String work : new String[] { "기상", "출근", "수업", "점심", "수업", "퇴근", "저녁", "수면" }) {
			day.add(work);
		}

		// 일반 for문
		for (int i = 0; i < day.size(); i++) {
			System.out.print(day.get(i) + " ");
		}
		System.out.println();

		// 향상된 for문
		for (String work : day) {
			System.out.print(work + " ");
		}
		System.out.println();

		// iterator
		Iterator<String> it = day.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

		// 정렬
		Collections.sort(day);
		System.out.println(day);
		day.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// compareTo
				// o1.compareTo(o2) : 오름차순
				// o2.compareTo(o1) : 내림차순
				return o2.compareTo(o1);
			}
		});

		System.out.println(day);
	}
}
package day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream03 {
	public static void main(String[] args) {
		// List<Student> 생성
		
		List<Student> list = new ArrayList<Student>();
		for(String name : new String[]
				{"홍길동", "김순이", "이영이", "박순철", "이철수", "홍순이", "박길동", "최수지"}) {
			list.add(new Student(name, new memos.Randoms().random(50, 100)));
		}
		
		// 스트림으로 출력 => 홍길동 : 56
		// toString() 이용
		list.stream()
			.forEach(s -> System.out.println(s));
		System.out.println("----------------");
		// toString() 없이
		// cf) effectively final
		String[] prints = {"", ""};
		list.stream()
			.forEach(s -> {
				prints[0] += s.getName() + "\t";
				prints[1] += s.getScore() + "\t";
			});
		System.out.println(prints[0]);
		System.out.println(prints[1]);
		System.out.println();
		
		// list의 점수 합계
		int sum = list.stream()
				.mapToInt(s -> s.getScore())
				.sum();
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/(double)list.size());
		
		// list의 인원수
		System.out.println("인원수 : " + list.stream().count());
		
		// 이름 가나다순 정렬
		System.out.println("---------------------");
		String[] sortName = {"", ""};
		list.stream()
			.sorted()	// Comparable<Student>에서 구현한 정렬
			.forEach(s -> {
				sortName[0] += s.getName() + "\t";
				sortName[1] += s.getScore() + "\t";
			});
		System.out.println(sortName[0]);
		System.out.println(sortName[1]);
		
		// 점수 내림차순 정렬
		System.out.println("---------------------");
		String[] sortScoreDesc = {"", ""};
		list.stream()
			.sorted(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o2.getScore() - o1.getScore();
				}
			}).forEach(s -> {
				sortScoreDesc[0] += s.getName() + "\t";
				sortScoreDesc[1] += s.getScore() + "\t";
			});
		System.out.println(sortScoreDesc[0]);
		System.out.println(sortScoreDesc[1]);
	}
}

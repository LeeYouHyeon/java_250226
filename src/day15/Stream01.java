package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream01 {
	public static void main(String[] args) {
		/* Stream(스트림)
		 * - 자료구조를 복사하여 스트림 객체로 생성
		 * - 스트림을 이용하여 연산을 수행
		 * - 연산을 수행한 스트림은 소모됨
		 * - 스트림은 기존 자료를 변경할 수 없음
		 * - 메서드 체이닝 방식을 사용
		 * - 스트림만의 연산을 가지고 있음
		 * - 중간연산 / 최종연산
		 * - 한 스트림의 연산들 사이에선 같은 이름의 변수를 사용할 수 없음
		 * 
		 * - 중간연산 : 메서드를 이어서 사용가능, 순서는 상관없는 경우가 많음
		 * 	- filter() : 조건에 맞는 값만 다음 메서드로 넘김
		 * 	- distinct() : 중복 제거
		 *  - limit() : 스트림의 일부를 잘라냄
		 *  - sorted() : 정렬
		 *  - map() : 주로 형변환
		 *  - peek() : 작업수행
		 *  - skip() : 스트림 일부를 건너뜀
		 * 
		 * - 최종연산 : 반드시 마지막에 하나만
		 * 	- forEach(), count(), sum(), average(), max(), min()
		 * 	- allMatch() : 스트림 요소가 모두 일치하는지
		 * 	- anyMatch() : 하나라도 일치하는지
		 * 	- toArray() : array로 변환
		 * 	- toList() : 리스트로 변환
		 *  - collect() : 수집
		 * */

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.stream(arr).sum());
		System.out.println(Arrays.stream(arr).count());
		System.out.println(Arrays.stream(arr).average());

		// 5 이상만 합계
		System.out.println(Arrays.stream(arr).filter(n -> n >= 5).sum());

		// 점수 배열을 생성한 후 70점 이상만 필터해 합계, 평균
		// 가장 높은 점수를 출력
		int arr2[] = new memos.Randoms().randoms(5, 0, 100);
		for (int num : arr2) {
			System.out.print(num + " ");
		}
		System.out.println();

		// 합계
		System.out.print("70점 이상의 합계 : ");
		System.out.println(Arrays.stream(arr2).filter(n -> n >= 70).sum());
		System.out.print("70점 이상의 평균 : ");
		System.out.println(Arrays.stream(arr2).filter(n -> n >= 70).average().orElse(0));
		System.out.print("1등 : ");
		System.out.println(Arrays.stream(arr2).max().orElse(0));

		// 
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num : new memos.Randoms().randoms(15, 1, 9)) {
			list.add(num);
		}

		// list를 스트림으로 구성
		list.stream()
			.sorted()
			.forEach(n -> System.out.print(n + " "));
		System.out.println();
		// 중복제거
		list.stream()
			.distinct()
			.forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		// 중복제거 후 합계
		System.out.println(list.stream()
								.distinct()
								.mapToInt(n -> n.intValue())
								.sum());
		
		// 스트림 객체 생성
		Stream<Integer> stream01 = Stream.of(10, 20, 30, 40, 50);
		System.out.println(stream01.mapToInt(n -> n.intValue()).sum());
		
		// 이미 스트림이 소모됨. 이후 stream01 사용불가
		System.out.println(Stream.of(10, 20, 30, 40, 50)
								.mapToInt(n -> n.intValue())
								.average().orElse(0));
	}
}

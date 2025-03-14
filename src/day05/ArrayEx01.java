package day05;

import java.util.Scanner;

public class ArrayEx01 {
	public static void main(String[] args) {
		/* 파일명을 저장하고 있는 배열이 주어졌을 때
		 * 검색어를 입력하면 해당 검색어를 포함하는 파일을 출력
		 * 검색 결과가 없으면 "검색 결과가 없습니다."라고 출력
		 * */

		String[] files = { "이것이자바다.java", "java의 정석.java", "Array.txt", "array.java", "String Method.txt",
				"Array Method.jpg", "method.png", "java Method.java" };
		Scanner scan = new Scanner(System.in);
		String[] result = new String[files.length];

		// 1. 검색어 입력
		System.out.print("검색어를 입력하세요.> ");
		String find = scan.nextLine().toLowerCase(); // 대소문자 상관없이 검색
		scan.close();

		// 2. files에서 검색어를 포함하는 파일들을 result에 넣기
		for (int i = 0; i < files.length; i++) {
			if (files[i].toLowerCase().contains(find)) { // 대소문자 상관없이 검색
				result[i] = files[i];
			}
		}

		// 3. 검색 결과 출력
		int count = 0;
		for (String name : result) {
			if (name != null) {
				count++;
				System.out.println(count + ". " + name);
			}
		}
		if (count == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("총 " + count + "건");
		}
		
		// CRUD
		/* Create	생성
		 * Read		읽기/검색
		 * Update	수정
		 * Delete	삭제
		 * */
	}
}

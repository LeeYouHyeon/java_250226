package day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx01 {
	public static void main(String[] args) {
		/* 숫자를 입력받아서 list를 구성
		 * 전체 출력 => 전체 합계 출력
		 * ex) 입력 > 45, 89, 78, 58, 96, 85, ... , 36 enter
		 * 점수가 70점 이상인 인원 수 출력
		 * */
		
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int count = 0, sum = 0;
		
		System.out.println("정수를 쉼표로 구분하여 입력하세요.");
		System.out.print("> ");
		try {
			for(String s : scan.nextLine().split(",")) {
				int num = Integer.parseInt(s.trim());
				sum += num;
				list.add(num);
				if(num >= 70) {
					count++;
				}
			}
			
			System.out.println(list);
			System.out.println("합계 : " + sum);
			System.out.println("점수가 70점 이상인 인원 수 : " + count + "명");
		} catch(NumberFormatException e) {
			System.out.println("입력 오류");
		}
		
		scan.close();
	}
}

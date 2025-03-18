package day14;

import java.util.HashMap;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/* 과목과 점수를 입력받아 map에 저장
		 * 출력 / 합계 / 평균
		 * 종료 키워드가 나올 때까지 반복 (0 => 종료)
		 * */
		HashMap<String, Integer> score = new HashMap<String, Integer>();

		Scanner scan = new Scanner(System.in);
		String input[];
		int sum = 0;
		boolean cont = true;

		while(cont) {
			try {
				// 입력
				// score에는 유효한 입력만 반영됨
				System.out.print("> ");
				input = scan.nextLine().split(" ");
				switch (input.length) {
				case 2:
					// 2개를 입력받았으면 앞을 과목, 뒤를 점수로 간주
					int num = Integer.parseInt(input[1]);
					score.put(input[0], num);
					break;
				case 1:
					// 1개를 받았으면 0인 경우 break, 아니면 default로 넘김
					if(Integer.parseInt(input[0]) == 0) {
						cont = false;
						break;
					}
				default:
					// 그 외에는 에러
					throw new Exception("잘못된 입력");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		scan.close();
		
		for(String key : score.keySet()) {
			sum += score.get(key);
		}
		
		if(!score.isEmpty()) {
			System.out.println(score);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + sum/(double)score.size());
		}
	}

}

package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File04 {
	public static void main(String[] args) throws IOException {
		/* test.txt 파일을 읽어들여 map에 저장
		 * 명단 출력 / 합계 / 평균 출력
		 * 읽어들이는 파일은 모두 String
		 * 점수 => int
		 * Integer.parseInt()
		 * 점수가 80점 이상인 학생 명단
		 * */
		
		BufferedReader br = new BufferedReader(
				new FileReader("D:\\web_0226_lyh\\memo\\test.txt"));
		
		HashMap<String, Integer> scores = new HashMap<>();
		while(true) {
			String rawLine = br.readLine();
			if(rawLine == null) {
				break;
			}
			String line[] = rawLine.split(" ");
			
			scores.put(line[0], Integer.parseInt(line[1]));
		}
		
		// 명단, 합계, 평균
		int sum = 0;
		double count = 0.0;
		for(String name : scores.keySet()) {
			int score = scores.get(name);
			System.out.println(name + ":" + score);
			sum += score;
			count++;
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/count);
		
		// 80점 이상
		scores.keySet().stream()
			.filter(name -> scores.getOrDefault(name, -1) >= 80)
			.forEach(n -> System.out.println(n + ":" + scores.get(n)));
		
		br.close();
	}
}

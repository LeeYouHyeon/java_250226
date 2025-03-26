package studentProfessorManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static Map<String, Double> scoreMap; // 4.3점 만점의 평점표
	
	public static void main(String[] args) {
		// 평점표 제작
		scoreMap = new HashMap<>();
		int s = 1;
		for (char letter : new char[] { 'D', 'C', 'B', 'A' }) {
			int i = -1;
			for (String append : new String[] { "-", "", "+" }) {
				scoreMap.put(letter + append, s + i * 0.3);
				i++;
			}
			s++;
		}
		scoreMap.put("F", 0.0);
		
		// 메인 컨트롤러 시동
		Scanner scan = new Scanner(System.in);
		new MainController(scan).run();
		
		scan.close();
	}
}

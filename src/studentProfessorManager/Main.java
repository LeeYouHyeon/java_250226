package studentProfessorManager;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static Map<String, Double> scoreMap;

	public static void main(String[] args) {
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
		
		new MainController().run();
	}
}

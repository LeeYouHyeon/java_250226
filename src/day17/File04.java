package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File04 {
	public static void main(String[] args) throws IOException {
		/* test.txt ������ �о�鿩 map�� ����
		 * ��� ��� / �հ� / ��� ���
		 * �о���̴� ������ ��� String
		 * ���� => int
		 * Integer.parseInt()
		 * ������ 80�� �̻��� �л� ���
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
		
		// ���, �հ�, ���
		int sum = 0;
		double count = 0.0;
		for(String name : scores.keySet()) {
			int score = scores.get(name);
			System.out.println(name + ":" + score);
			sum += score;
			count++;
		}
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + sum/count);
		
		// 80�� �̻�
		scores.keySet().stream()
			.filter(name -> scores.getOrDefault(name, -1) >= 80)
			.forEach(n -> System.out.println(n + ":" + scores.get(n)));
		
		br.close();
	}
}

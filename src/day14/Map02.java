package day14;

import java.util.HashMap;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/* ����� ������ �Է¹޾� map�� ����
		 * ��� / �հ� / ���
		 * ���� Ű���尡 ���� ������ �ݺ� (0 => ����)
		 * */
		HashMap<String, Integer> score = new HashMap<String, Integer>();

		Scanner scan = new Scanner(System.in);
		String input[];
		int sum = 0;
		boolean cont = true;

		while(cont) {
			try {
				// �Է�
				// score���� ��ȿ�� �Է¸� �ݿ���
				System.out.print("> ");
				input = scan.nextLine().split(" ");
				switch (input.length) {
				case 2:
					// 2���� �Է¹޾����� ���� ����, �ڸ� ������ ����
					int num = Integer.parseInt(input[1]);
					score.put(input[0], num);
					break;
				case 1:
					// 1���� �޾����� 0�� ��� break, �ƴϸ� default�� �ѱ�
					if(Integer.parseInt(input[0]) == 0) {
						cont = false;
						break;
					}
				default:
					// �� �ܿ��� ����
					throw new Exception("�߸��� �Է�");
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
			System.out.println("�հ� : " + sum);
			System.out.println("��� : " + sum/(double)score.size());
		}
	}

}

package day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx01 {
	public static void main(String[] args) {
		/* ���ڸ� �Է¹޾Ƽ� list�� ����
		 * ��ü ��� => ��ü �հ� ���
		 * ex) �Է� > 45, 89, 78, 58, 96, 85, ... , 36 enter
		 * ������ 70�� �̻��� �ο� �� ���
		 * */
		
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int count = 0, sum = 0;
		
		System.out.println("������ ��ǥ�� �����Ͽ� �Է��ϼ���.");
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
			System.out.println("�հ� : " + sum);
			System.out.println("������ 70�� �̻��� �ο� �� : " + count + "��");
		} catch(NumberFormatException e) {
			System.out.println("�Է� ����");
		}
		
		scan.close();
	}
}

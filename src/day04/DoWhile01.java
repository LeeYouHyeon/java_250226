package day04;

import java.util.Scanner;

public class DoWhile01 {

	public static void main(String[] args) {
		/* �ݺ��� : for, while, do~while
		 * for, while : ������ �������� ������ �� ���� ������� ���� �� ����
		 * do~while : ���๮�� ���� �����ϰ�, ���ǽ��� ���߿� ��
		 * ������ �� ���� ���� �� ���ϴ� ����
		 * 
		 * do {
		 * 	���๮;
		 * } while(���ǽ�);
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		/* �� ���ڸ� �Է¹޾Ƽ� ���
		 * y => ����
		 * */
		
		char ch; // do �ȿ��� �����ϸ� while���� ���� �� ����
		do {
			System.out.print("�� ���� �Է�> ");
			ch = scan.next().charAt(0);
		} while (ch != 'y');
		
		System.out.println("����");
		scan.close();
	}

}

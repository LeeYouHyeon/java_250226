package day02;

import java.util.Scanner;

public class Input01 {

	public static void main(String[] args) {
		// Input Class
		// console input : �ֿܼ��� ���� �Է¹޴� ���� �ǹ�
		// Scanner Ŭ���� : ��ü�� ������ �� ��� new
		// cf) String�� �ʹ� ���� ���� ���� ������� ����
		// Ŭ������ ��ü�̸� = new Ŭ������(��);
		// ��ü��.next () : �� �ܾ �Է�(����)
		// ��ü��.nextLine() : ���� ����
		// ��ü��.nextInt() : ���� �Է�
		// ��ü��.next�ڷ���() : �ڷ����� �´� �� �Է�

		Scanner scan = new Scanner(System.in);
//		System.out.print("�����Է�> ");
//		int num = scan.nextInt();
//		System.out.println(num);
//
//		if (num % 2 == 0) {
//			System.out.println("¦��");
//		} else {
//			System.out.println("Ȧ��");
//		}
//		
//		System.out.print("�Ǽ��� �Է�> ");
//		double d = scan.nextDouble();
//		System.out.println(d);
		
		System.out.print("�����Է�> ");
		String s = scan.next();
		System.out.println(s);
		
		scan.nextLine(); //next() ���� ���͸� ������ �뵵
		
		System.out.print("���� �ܾ� �Է�> ");
		String s1 = scan.nextLine();
		System.out.println(s1);
		
		scan.close();
	}

}

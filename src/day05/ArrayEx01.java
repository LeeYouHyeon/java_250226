package day05;

import java.util.Scanner;

public class ArrayEx01 {
	public static void main(String[] args) {
		/* ���ϸ��� �����ϰ� �ִ� �迭�� �־����� ��
		 * �˻�� �Է��ϸ� �ش� �˻�� �����ϴ� ������ ���
		 * �˻� ����� ������ "�˻� ����� �����ϴ�."��� ���
		 * */

		String[] files = { "�̰����ڹٴ�.java", "java�� ����.java", "Array.txt", "array.java", "String Method.txt",
				"Array Method.jpg", "method.png", "java Method.java" };
		Scanner scan = new Scanner(System.in);
		String[] result = new String[files.length];

		// 1. �˻��� �Է�
		System.out.print("�˻�� �Է��ϼ���.> ");
		String find = scan.nextLine().toLowerCase(); // ��ҹ��� ������� �˻�
		scan.close();

		// 2. files���� �˻�� �����ϴ� ���ϵ��� result�� �ֱ�
		for (int i = 0; i < files.length; i++) {
			if (files[i].toLowerCase().contains(find)) { // ��ҹ��� ������� �˻�
				result[i] = files[i];
			}
		}

		// 3. �˻� ��� ���
		int count = 0;
		for (String name : result) {
			if (name != null) {
				count++;
				System.out.println(count + ". " + name);
			}
		}
		if (count == 0) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.println("�� " + count + "��");
		}
		
		// CRUD
		/* Create	����
		 * Read		�б�/�˻�
		 * Update	����
		 * Delete	����
		 * */
	}
}

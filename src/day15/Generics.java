package day15;

import java.util.Scanner;

public class Generics {
	public static void main(String[] args) {
		/* ���׸�(Generics) : �������� Ÿ���� ���߿� Ȯ���ϴ� ���
		 * Ŭ������ �޼��带 ������ �� � �����Ͱ� ������ Ȯ���� ���ٸ�...
		 * ���׸� Ÿ������ ���� => ���߿� ��ü�� ������ �� Ÿ���� Ȯ���Ͽ� ����
		 * 
		 * ��ü�� Ÿ���� ������ �� �� üũ�� �����Ͽ�,
		 * Ÿ���� �������� ��ġ�� �ʴ� ������ ������ ����ȯ�� ����
		 * ������ - �ǵ����� ���� Ÿ���� ��ü�� ����Ǵ� ���� ���� �ǹ�
		 * */

		// List<E> list = new ArrayList<E>();
		// HashMap<K, V> map = new HashMap<K, V>();

		/* Sale Ŭ������ ���׸����� ����
		 * main
		 * 1. �޴� �߰� | 2. �޴� ���� | 3. ��ǰ �ֹ� | 4. �ֹ� ���� ���� | 5. ����
		 * */

		Scanner scan = new Scanner(System.in);
		SaleController sc = new SaleController();
		int menu = 0;

		while (menu != 5) {
			try {
				System.out.println("1. �޴� �߰� | 2. �޴� ���� | 3. ��ǰ �ֹ� | 4. �ֹ� ���� ���� | 5. ����");
				System.out.print("> ");

				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {
				case 1:
					sc.add(scan);
					break;
				case 2:
					sc.print();
					break;
				case 3:
					sc.order(scan);
					break;
				case 4:
					sc.orderPrint();
					break;
				case 5:
					System.out.println("����");
					break;
				default:
					throw new Exception("�Է� ����");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		scan.close();
	}
}
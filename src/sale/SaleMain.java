package sale;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SaleMain {
	public static void main(String[] args) {
		/* Kiosk
		 * �޴�(�޴���, ����) / �ֹ�(�޴��� ���? / ����, �ݾ�)
		 * 
		 * -- menu --
		 * 1. �޴� ��� | 2. �޴� ���� | 3. ���� ����
		 * 4. �޴� ����(��ü �޴� ���) | 5. �ֹ� | 6. �ֹ� ���� ���(������)
		 * 7. ����
		 * */

		Scanner scan = new Scanner(System.in);
		SaleController c = new SaleController(scan);
		int input = 0;
		
		do {
			try {
				// ������ ���
				System.out.println("--menu--");
				System.out.println("1. �޴���� | 2. �޴����� | 3. ���ݼ��� | 4. �޴����� | 5. �ֹ� | 6. �ֹ�������� | 7. ����");
				System.out.print("> ");

				// ������ �Է�
				input = Integer.parseInt(scan.nextLine());

				// ������ ó��
				switch (input) {
				case 1:
					c.add();
					break;
				case 2:
					c.remove();
					break;
				case 3:
					c.update();
					break;
				case 4:
					c.showMenu();
					break;
				case 5:
					c.order();
					break;
				case 6:
					c.printOrders();
					break;
				case 7:
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("�߸��� �Է�");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("�ش��ϴ� �޴��� �����ϴ�.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (input != 7);

		System.out.println("����");
		scan.close();
	}

}

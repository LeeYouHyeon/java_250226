package sale;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SaleMain {
	public static void print(List<Menu> menus) {
		for (int i = 0; i < menus.size(); i++) {
			System.out.println(i + 1 + " " + menus.get(i).toString());
		}
	}

	public static void main(String[] args) {
		/* Kiosk
		 * �޴�(�޴���, ����) / �ֹ�(�޴��� ���? / ����, �ݾ�)
		 * 
		 * -- menu --
		 * 1. �޴� ��� | 2. �޴� ���� | 3. ���� ����
		 * 4. �޴� ����(��ü �޴� ���) | 5. �ֹ� | 6. �ֹ� ���� ���(������)
		 * 7. ����
		 * */
		
		Exception emptyMenu = new Exception("�޴��� �ƹ� ��ǰ�� ��ϵ��� �ʾҽ��ϴ�.");
		Scanner scan = new Scanner(System.in);
		List<Menu> menus = new ArrayList<Menu>();
		List<Order> orders = new ArrayList<Order>();
		String input = "";
		int idx;

		do {
			try {
				// �ɼ� ���
				System.out.println("--menu--");
				System.out.println("1. �޴���� | 2. �޴����� | 3. ���ݼ��� | 4. �޴����� | 5. �ֹ� �� ���� | 6. �ֹ�������� | 7. ����");
				System.out.print("> ");

				// �ɼ� �Է�
				input = scan.nextLine();
				switch (Integer.parseInt(input)) {
				case 1:
					// 1. �޴� ���
					// 1-1. �̸� �Է�
					System.out.print("�޴� �̸�> ");
					input = scan.nextLine();
					// 1-2. �̸� �ߺ� Ȯ��
					for (Menu m : menus) {
						if (m.getName().equals(input)) {
							throw new Exception("���� �̸��� �޴��� �ֽ��ϴ�.");
						}
					}
					// 1-3. ���� �Է�
					System.out.print("����> ");
					// 1-4. �̸��� �������� Menu ��ü�� ����� menus�� ���
					menus.add(new Menu(input, Integer.parseInt(scan.nextLine())));
					System.out.println("�߰��Ǿ����ϴ�.");
					break;

				case 2:
					// 2. �޴� ����
					if(menus.isEmpty()) {
						throw emptyMenu;
					}
					// 2-1. ������ �޴��� ��ȣ�� �Է�
					print(menus);
					System.out.print("������ �޴� ��ȣ> ");
					idx = Integer.parseInt(scan.nextLine()) - 1;

					// 2-2. �ش� �޴��� menus���� ����
					Menu removed = menus.remove(idx);
					System.out.println("�޴��� �����Ǿ����ϴ�.");

					// 2-3. ���� �ش� �޴��� �ֹ��ߴٸ� �ֹ� ��ϵ� ����
					for (int i = 0; i < orders.size(); i++) {
						if (orders.get(i).getName().equals(removed.getName())) {
							orders.remove(i);
							System.out.println("�ش� �޴��� �ֹ��� ����� �־�, �ֹ��� ���� �����Ǿ����ϴ�.");
						}
					}
					break;

				case 3:
					// 3. ���� ����
					if(menus.isEmpty()) {
						throw emptyMenu;
					}
					// 3-1. ������ �޴��� ��ȣ�� �Է�
					print(menus);
					System.out.print("������ ������ �޴� ��ȣ> ");
					idx = Integer.parseInt(scan.nextLine()) - 1;

					// 2-2. ������ �Է¹޴� �������� ����
					Menu update = menus.get(idx);
					System.out.print("����> ");
					update.setPrice(Integer.parseInt(scan.nextLine()));
					break;

				case 4:
					// 4. �޴� ����
					if (menus.isEmpty()) {
						throw emptyMenu;
					} else {
						print(menus);
					}
					break;

				case 5:
					// 5. �ֹ� �� ����
					if(menus.isEmpty()) {
						throw emptyMenu;
					}
					// 5-1. �ֹ��� �޴��� ��ȣ�� �Է�
					print(menus);
					System.out.print("�ֹ��� �޴� ��ȣ> ");
					idx = Integer.parseInt(scan.nextLine()) - 1;

					// 5-2. ���� �Է�
					System.out.print("����> ");
					int count = Integer.parseInt(scan.nextLine());

					// 5-3. �̹� �ֹ��� �޴����� Ȯ��
					int ordered = -1;
					for (int i = 0; i < orders.size(); i++) {
						if (orders.get(i).getName().equals(menus.get(idx).getName())) {
							ordered = i;
						}
					}

					// 5-4. �޴� �ֹ�
					if (ordered == -1) {
						//5-4-1. �ֹ��� ���� ���ٸ� orders�� �߰�
						orders.add(new Order(menus.get(idx), count));
					} else {
						// 5-4-2. �̹� �ֹ��� �޴���� �ֹ��� ����(����)
						int updatedCount = orders.get(ordered).getCount() + count;
						if (updatedCount == 0) {
							// count�� 0�̸� ���� ó��
							orders.remove(ordered);
							System.out.println("�� �ֹ� ������ 0�� �Ǿ� �ֹ� �������� �����Ǿ����ϴ�.");
						} else if (updatedCount < 0) {
							// count�� ������ �� ������, �̹� �ֹ��� �������� �հ谡 ������ ���� ����
							throw new Exception("������ ������ �� �� �����ϴ�.");
						} else {
							orders.get(ordered).setCount(updatedCount);
						}
					}
					break;

				case 6:
					// 6. �ֹ� ���� ���
					if (orders.isEmpty()) {
						System.out.println("�ֹ� ������ �����ϴ�.");
					} else {
						int total = 0;
						for (int i = 0; i < orders.size(); i++) {
							total += orders.get(i).getTotal();
							System.out.println(i + 1 + " " + orders.get(i).toString());
						}
						System.out.println("�� : " + total);
					}
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
		} while (!input.equals("7"));
		
		System.out.println("����");
		scan.close();
	}

}

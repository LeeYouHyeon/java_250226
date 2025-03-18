package sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleController {
	private List<Menu> menus;
	private List<Order> orders;
	private Scanner scan;

	public SaleController(Scanner scan) {
		menus = new ArrayList<>();
		orders = new ArrayList<Order>();
		this.scan = scan;
	}

	// ���� �޼��� 1. ������ �Է¹���
	// ���� > 0
	private int getPriceInput() throws Exception {
		System.out.print("����> ");
		int price = Integer.parseInt(scan.nextLine());
		if (price <= 0) {
			throw new Exception("������ 0 �����Դϴ�.");
		}

		return price;
	}
	// ���� �޼��� 2. �޴��� �����ְ� ��ȣ�� ���ù���
	private int getMenuIdx(String inputGuide) throws Exception {
		// 1. �޴��� ������
		showMenu();

		// 2. �ʿ��� �޼����� ������
		System.out.print(inputGuide);

		// 3. ���� ��ȣ�� return
		int idx = Integer.parseInt(scan.nextLine()) - 1;
		menus.get(idx); // Exception�� ������ ���� �ڵ�
		return idx;
	}

	// 1. �޴� ���
	public void add() throws Exception {
		// 1. �̸� �Է�
		System.out.print("�޴� �̸�> ");
		String name = scan.nextLine();
		// 1-1. �ߺ� Ȯ��
		for (Menu m : menus) {
			if (m.getName().equals(name)) {
				throw new Exception("���� �̸��� �޴��� �ֽ��ϴ�.");
			}
		}

		// 2. ���� �Է�
		int price = getPriceInput();

		// 2. �̸��� �������� Menu ��ü�� ����� menu�� ���
		menus.add(new Menu(name, price));
		System.out.println("�߰��Ǿ����ϴ�.");
	}

	// 2. �޴� ����
	public void remove() throws Exception {
		// �޴��� ��ȣ�� �Է¹޾� menus���� ����
		menus.remove(getMenuIdx("������ �޴� ��ȣ> "));
		System.out.println("�޴��� �����Ǿ����ϴ�.");
	}

	// 3. ���� ����
	// ���� > 0
	public void update() throws Exception {
		// 1. ������ �޴��� ��ȣ�� �Է�
		Menu menu = menus.get(getMenuIdx("������ �޴� ��ȣ> "));

		// 2. ���� �Է�
		int price = getPriceInput();

		// 3. ���� ����
		menu.setPrice(price);
		System.out.println("������ �����Ǿ����ϴ�.");
	}

	// 4. �޴� ����
	public void showMenu() throws Exception {
		if (menus.isEmpty())
			throw new Exception("�޴��� ��ϵ� ��ǰ�� �����ϴ�.");

		for (int i = 0; i < menus.size(); i++) {
			System.out.println(i + 1 + ". " + menus.get(i).toString());
		}
	}

	// 5. �ֹ�
	// �ֹ� ���� > 0
	public void order() throws Exception {
		// 1. �ֹ��� �޴��� ��ȣ�� �Է�
		int idx = getMenuIdx("�ֹ��� �޴� ��ȣ> ");

		// 2. ���� �Է�
		System.out.print("����> ");
		int count = Integer.parseInt(scan.nextLine());
		if (count <= 0) {
			throw new Exception("�ֹ� ������ 0 �����Դϴ�.");
		}

		// 3. �ֹ� ���
		orders.add(new Order(menus.get(idx), count));
		System.out.println("�ֹ� �Ϸ�");
	}

	// 6. �ֹ� ���� ���
	public void printOrders() throws Exception {
		if (orders.isEmpty()) {
			System.out.println("�ֹ� ������ �����ϴ�.");
		} else {
			int total = 0;
			for (int i = 0; i < orders.size(); i++) {
				total += orders.get(i).getTotal();
				System.out.println(i + 1 + ". " + orders.get(i).toString());
			}
			System.out.println("�� : " + total);
		}
	}

	public Scanner getScanner() {
		return scan;
	}
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}
}

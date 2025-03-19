package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleController {
	// ��������� Sale Ŭ���� ����Ʈ�� ����
	
	private ArrayList<Sale<String, Integer>> sales = new ArrayList<>();
	private ArrayList<Sale<String, Integer>> orders = new ArrayList<>();

	public void add(Scanner scan) throws Exception {
		// �޴��� �Է�
		System.out.print("�޴���> ");
		String menu = scan.nextLine();
		int price;
		
		for(Sale<String, Integer> s : sales) {
			if(s.getMenu().equals(menu)) {
				// �ִ� �޴���� ���� ���� ���θ� ���
				System.out.println("�̹� ��ϵ� ��ǰ�Դϴ�.");
				System.out.print("������ �����Ͻðڽ��ϱ�?(Y/N)> ");
				
				// �����Ѵٸ� ������ �� ����
				if(scan.nextLine().toLowerCase().equals("y")) {
					System.out.print("������ ����> ");
					price = Integer.parseInt(scan.nextLine());
					s.setPrice(price);
					System.out.println("���� ���� �Ϸ�");
				}
				return;
			}
		}
		
		// ���� �Է�
		System.out.print("����> ");
		price = Integer.parseInt(scan.nextLine());
		
		// �޴� ���
		sales.add(new Sale<>(menu, price));
		System.out.println("�޴� �߰� �Ϸ�");
	}

	public void print() {
		// �޴����
		if(sales.isEmpty()) {
			System.out.println("�޴��� �����ϴ�.");
		} else {
			for(Sale<String, Integer> sale : sales) {
				System.out.println(sale);
			}
		}
	}

	public void order(Scanner scan) {
		// �ֹ�
		/* �޴��� ������ �Է¹޾� list���� �޴��� ������ ã�ƿ�
		 * order �޴� / ����*������ price�� ����
		 * */
		
		// �޴� �Է�
		print();
		System.out.print("�޴�> ");
		String name = scan.nextLine();
		for(Sale<String, Integer> menu : sales) {
			// �޴� �˻�
			if(menu.getMenu().equals(name)) {
				
				// ���� �Է�
				System.out.print("����> ");
				int count = Integer.parseInt(scan.nextLine());
				if(count <= 0) {
					System.out.println("������ �߸� �Է��ϼ̽��ϴ�.");
					return;
				}
				
				orders.add(new Sale<>(name, count*menu.getPrice()));
				System.out.println("�ֹ� �Ϸ�");
				return;
			}
		}
		
		System.out.println("���� �޴��Դϴ�.");
	}

	public void orderPrint() {
		int sum = 0;
		if(orders.isEmpty()) {
			System.out.println("�ֹ� �̷��� �����ϴ�.");
		} else {
			for(Sale<String, Integer> order : orders) {
				System.out.println(order);
				sum += order.getPrice();
			}
			
			System.out.println("�հ� : " + sum);
		}
	}
	
}

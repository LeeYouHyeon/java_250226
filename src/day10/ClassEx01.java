package day10;

import java.util.Scanner;

public class ClassEx01 {
	public static void main(String[] args) {
		/* Product Ŭ���� ���� : ��ǰ�� ����ϴ� Ŭ����
		 * 	- ������� : ��ǰ��, ����
		 * 	- ��ǰ��� ������ ����ϴ� �޼���
		 * 	- ��ǰ�� �߰��ϴ� �޼���
		 * */

		/* main Ŭ�������� ó��
		 * ��ǰ 10�� ���
		 * ��ĳ�ʸ� ���ؼ� ��ǰ�� ��Ϲޱ�
		 * ����� ��ǰ�� ���
		 * */

		Product buy[] = new Product[10];
		Scanner scan = new Scanner(System.in);

		// ���� ��� �Է¹ޱ�
		System.out.println("����� ��ǰ ������ �Է��ϼ���.");
		System.out.print("�̸�> ");
		buy[0] = new Product();
		buy[0].setName(scan.nextLine());
		System.out.print("����> ");
		buy[0].setPrice(scan.nextInt());
		scan.nextLine();

		for (int i = 1; i < buy.length; i++) {
			String input = "";
			// �߰� ���� �ǻ� Ȯ��
			System.out.println("����� ��ǰ �̸��� �Է����ּ���.");
			System.out.println("�׸��ν÷��� Q/q�� �Է����ּ���.");
			System.out.print("> ");

			while (input.isBlank()) {
				input = scan.nextLine();
			}
			
			if(input.toLowerCase().replaceAll(" ", "").equals("q")) {
				break;
			} else {
				buy[i] = new Product();
				buy[i].setName(input);
				System.out.print("����> ");
				buy[i].setPrice(scan.nextInt());
				scan.nextLine();
			}
		}
		scan.close();

		// ���� ��� ���
		System.out.println();
		System.out.println("��ǰ ���");
		for (int i = 0; i < buy.length; i++) {
			if (buy[i] == null) {
				break;
			}

			System.out.print(i + 1 + ". ");
			System.out.println(buy[i]);
		}
	}
}

class Product {
	private String name = "";
	private int price;

	public Product() {}
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[" + name + " : " + price + "]";
	}

	public void insertInfo(String name, int price) {
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
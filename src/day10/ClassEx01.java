package day10;

import java.util.Scanner;

public class ClassEx01 {
	public static void main(String[] args) {
		/* Product 클래스 생성 : 상품을 등록하는 클래스
		 * 	- 멤버변수 : 상품명, 가격
		 * 	- 상품명과 가격을 출력하는 메서드
		 * 	- 상품을 추가하는 메서드
		 * */

		/* main 클래스에서 처리
		 * 상품 10개 등록
		 * 스캐너를 통해서 상품을 등록받기
		 * 등록한 상품을 출력
		 * */

		Product buy[] = new Product[10];
		Scanner scan = new Scanner(System.in);

		// 구매 목록 입력받기
		System.out.println("등록할 상품 정보를 입력하세요.");
		System.out.print("이름> ");
		buy[0] = new Product();
		buy[0].setName(scan.nextLine());
		System.out.print("가격> ");
		buy[0].setPrice(scan.nextInt());
		scan.nextLine();

		for (int i = 1; i < buy.length; i++) {
			String input = "";
			// 추가 구매 의사 확인
			System.out.println("등록할 상품 이름을 입력해주세요.");
			System.out.println("그만두시려면 Q/q를 입력해주세요.");
			System.out.print("> ");

			while (input.isBlank()) {
				input = scan.nextLine();
			}
			
			if(input.toLowerCase().replaceAll(" ", "").equals("q")) {
				break;
			} else {
				buy[i] = new Product();
				buy[i].setName(input);
				System.out.print("가격> ");
				buy[i].setPrice(scan.nextInt());
				scan.nextLine();
			}
		}
		scan.close();

		// 구매 목록 출력
		System.out.println();
		System.out.println("상품 목록");
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
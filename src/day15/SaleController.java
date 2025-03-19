package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleController {
	// 멤버변수로 Sale 클래스 리스트를 생성
	
	private ArrayList<Sale<String, Integer>> sales = new ArrayList<>();
	private ArrayList<Sale<String, Integer>> orders = new ArrayList<>();

	public void add(Scanner scan) throws Exception {
		// 메뉴명 입력
		System.out.print("메뉴명> ");
		String menu = scan.nextLine();
		int price;
		
		for(Sale<String, Integer> s : sales) {
			if(s.getMenu().equals(menu)) {
				// 있는 메뉴라면 가격 수정 여부를 물어봄
				System.out.println("이미 등록된 상품입니다.");
				System.out.print("가격을 변경하시겠습니까?(Y/N)> ");
				
				// 수정한다면 수정한 후 종료
				if(scan.nextLine().toLowerCase().equals("y")) {
					System.out.print("변경할 가격> ");
					price = Integer.parseInt(scan.nextLine());
					s.setPrice(price);
					System.out.println("가격 수정 완료");
				}
				return;
			}
		}
		
		// 가격 입력
		System.out.print("가격> ");
		price = Integer.parseInt(scan.nextLine());
		
		// 메뉴 등록
		sales.add(new Sale<>(menu, price));
		System.out.println("메뉴 추가 완료");
	}

	public void print() {
		// 메뉴출력
		if(sales.isEmpty()) {
			System.out.println("메뉴가 없습니다.");
		} else {
			for(Sale<String, Integer> sale : sales) {
				System.out.println(sale);
			}
		}
	}

	public void order(Scanner scan) {
		// 주문
		/* 메뉴와 수량을 입력받아 list에서 메뉴의 가격을 찾아와
		 * order 메뉴 / 수량*가격을 price에 저장
		 * */
		
		// 메뉴 입력
		print();
		System.out.print("메뉴> ");
		String name = scan.nextLine();
		for(Sale<String, Integer> menu : sales) {
			// 메뉴 검색
			if(menu.getMenu().equals(name)) {
				
				// 수량 입력
				System.out.print("수량> ");
				int count = Integer.parseInt(scan.nextLine());
				if(count <= 0) {
					System.out.println("수량을 잘못 입력하셨습니다.");
					return;
				}
				
				orders.add(new Sale<>(name, count*menu.getPrice()));
				System.out.println("주문 완료");
				return;
			}
		}
		
		System.out.println("없는 메뉴입니다.");
	}

	public void orderPrint() {
		int sum = 0;
		if(orders.isEmpty()) {
			System.out.println("주문 이력이 없습니다.");
		} else {
			for(Sale<String, Integer> order : orders) {
				System.out.println(order);
				sum += order.getPrice();
			}
			
			System.out.println("합계 : " + sum);
		}
	}
	
}

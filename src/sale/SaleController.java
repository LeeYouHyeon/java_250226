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

	// 보조 메서드 1. 가격을 입력받음
	// 가격 > 0
	private int getPriceInput() throws Exception {
		System.out.print("가격> ");
		int price = Integer.parseInt(scan.nextLine());
		if (price <= 0) {
			throw new Exception("가격이 0 이하입니다.");
		}

		return price;
	}
	// 보조 메서드 2. 메뉴를 보여주고 번호로 선택받음
	private int getMenuIdx(String inputGuide) throws Exception {
		// 1. 메뉴를 보여줌
		showMenu();

		// 2. 필요한 메세지를 보여줌
		System.out.print(inputGuide);

		// 3. 받은 번호를 return
		int idx = Integer.parseInt(scan.nextLine()) - 1;
		menus.get(idx); // Exception을 던지기 위한 코드
		return idx;
	}

	// 1. 메뉴 등록
	public void add() throws Exception {
		// 1. 이름 입력
		System.out.print("메뉴 이름> ");
		String name = scan.nextLine();
		// 1-1. 중복 확인
		for (Menu m : menus) {
			if (m.getName().equals(name)) {
				throw new Exception("같은 이름의 메뉴가 있습니다.");
			}
		}

		// 2. 가격 입력
		int price = getPriceInput();

		// 2. 이름과 가격으로 Menu 객체를 만들어 menu에 등록
		menus.add(new Menu(name, price));
		System.out.println("추가되었습니다.");
	}

	// 2. 메뉴 삭제
	public void remove() throws Exception {
		// 메뉴를 번호로 입력받아 menus에서 삭제
		menus.remove(getMenuIdx("삭제할 메뉴 번호> "));
		System.out.println("메뉴가 삭제되었습니다.");
	}

	// 3. 가격 수정
	// 가격 > 0
	public void update() throws Exception {
		// 1. 수정할 메뉴를 번호로 입력
		Menu menu = menus.get(getMenuIdx("수정할 메뉴 번호> "));

		// 2. 가격 입력
		int price = getPriceInput();

		// 3. 가격 수정
		menu.setPrice(price);
		System.out.println("가격이 수정되었습니다.");
	}

	// 4. 메뉴 보기
	public void showMenu() throws Exception {
		if (menus.isEmpty())
			throw new Exception("메뉴에 등록된 상품이 없습니다.");

		for (int i = 0; i < menus.size(); i++) {
			System.out.println(i + 1 + ". " + menus.get(i).toString());
		}
	}

	// 5. 주문
	// 주문 수량 > 0
	public void order() throws Exception {
		// 1. 주문할 메뉴를 번호로 입력
		int idx = getMenuIdx("주문할 메뉴 번호> ");

		// 2. 수량 입력
		System.out.print("수량> ");
		int count = Integer.parseInt(scan.nextLine());
		if (count <= 0) {
			throw new Exception("주문 수량이 0 이하입니다.");
		}

		// 3. 주문 등록
		orders.add(new Order(menus.get(idx), count));
		System.out.println("주문 완료");
	}

	// 6. 주문 내역 출력
	public void printOrders() throws Exception {
		if (orders.isEmpty()) {
			System.out.println("주문 내역이 없습니다.");
		} else {
			int total = 0;
			for (int i = 0; i < orders.size(); i++) {
				total += orders.get(i).getTotal();
				System.out.println(i + 1 + ". " + orders.get(i).toString());
			}
			System.out.println("총 : " + total);
		}
	}

	public Scanner getScanner() {
		return scan;
	}
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}
}

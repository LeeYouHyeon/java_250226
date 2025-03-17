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
		 * 메뉴(메뉴명, 가격) / 주문(메뉴를 상속? / 수량, 금액)
		 * 
		 * -- menu --
		 * 1. 메뉴 등록 | 2. 메뉴 삭제 | 3. 가격 수정
		 * 4. 메뉴 보기(전체 메뉴 출력) | 5. 주문 | 6. 주문 내역 출력(영수증)
		 * 7. 종료
		 * */
		
		Exception emptyMenu = new Exception("메뉴에 아무 상품도 등록되지 않았습니다.");
		Scanner scan = new Scanner(System.in);
		List<Menu> menus = new ArrayList<Menu>();
		List<Order> orders = new ArrayList<Order>();
		String input = "";
		int idx;

		do {
			try {
				// 옵션 출력
				System.out.println("--menu--");
				System.out.println("1. 메뉴등록 | 2. 메뉴삭제 | 3. 가격수정 | 4. 메뉴보기 | 5. 주문 | 6. 주문내역출력 | 7. 종료");
				System.out.print("> ");

				// 옵션 입력
				input = scan.nextLine();
				switch (Integer.parseInt(input)) {
				case 1:
					// 1. 메뉴 등록
					// 1-1. 이름 입력
					System.out.print("메뉴 이름> ");
					input = scan.nextLine();
					// 1-2. 이름 중복 확인
					for (Menu m : menus) {
						if (m.getName().equals(input)) {
							throw new Exception("같은 이름의 메뉴가 있습니다.");
						}
					}
					// 1-3. 가격 입력
					System.out.print("가격> ");
					// 1-4. 이름과 가격으로 Menu 객체를 만들어 menus에 등록
					menus.add(new Menu(input, Integer.parseInt(scan.nextLine())));
					System.out.println("추가되었습니다.");
					break;

				case 2:
					// 2. 메뉴 삭제
					if(menus.isEmpty()) {
						throw emptyMenu;
					}
					// 2-1. 삭제를 메뉴를 번호로 입력
					print(menus);
					System.out.print("삭제할 메뉴 번호> ");
					idx = Integer.parseInt(scan.nextLine()) - 1;

					// 2-2. 해당 메뉴를 menus에서 삭제
					menus.remove(idx);
					System.out.println("메뉴가 삭제되었습니다.");
					break;

				case 3:
					// 3. 가격 수정
					if(menus.isEmpty()) {
						throw emptyMenu;
					}
					// 3-1. 수정할 메뉴를 번호로 입력
					print(menus);
					System.out.print("가격을 수정할 메뉴 번호> ");
					idx = Integer.parseInt(scan.nextLine()) - 1;

					// 2-2. 새로이 입력받는 가격으로 수정
					Menu update = menus.get(idx);
					System.out.print("가격> ");
					update.setPrice(Integer.parseInt(scan.nextLine()));
					break;

				case 4:
					// 4. 메뉴 보기
					if (menus.isEmpty()) {
						throw emptyMenu;
					} else {
						print(menus);
					}
					break;

				case 5:
					// 5. 주문 및 수정
					if(menus.isEmpty()) {
						throw emptyMenu;
					}
					// 5-1. 주문할 메뉴를 번호로 입력
					print(menus);
					System.out.print("주문할 메뉴 번호> ");
					idx = Integer.parseInt(scan.nextLine()) - 1;

					// 5-2. 수량 입력
					System.out.print("수량> ");
					int count = Integer.parseInt(scan.nextLine());
					
					// 5-3. 주문 등록
					if(count <= 0) {
						throw new Exception("주문 수량이 0 이하입니다.");
					}
					orders.add(new Order(menus.get(idx), count));
					
					break;

				case 6:
					// 6. 주문 내역 출력
					if (orders.isEmpty()) {
						System.out.println("주문 내역이 없습니다.");
					} else {
						int total = 0;
						for (int i = 0; i < orders.size(); i++) {
							total += orders.get(i).getTotal();
							System.out.println(i + 1 + " " + orders.get(i).toString());
						}
						System.out.println("총 : " + total);
					}
					break;
				case 7:
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("해당하는 메뉴가 없습니다.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!input.equals("7"));
		
		System.out.println("종료");
		scan.close();
	}

}

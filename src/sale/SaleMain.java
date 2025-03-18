package sale;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SaleMain {
	public static void main(String[] args) {
		/* Kiosk
		 * 메뉴(메뉴명, 가격) / 주문(메뉴를 상속? / 수량, 금액)
		 * 
		 * -- menu --
		 * 1. 메뉴 등록 | 2. 메뉴 삭제 | 3. 가격 수정
		 * 4. 메뉴 보기(전체 메뉴 출력) | 5. 주문 | 6. 주문 내역 출력(영수증)
		 * 7. 종료
		 * */

		Scanner scan = new Scanner(System.in);
		SaleController c = new SaleController(scan);
		int input = 0;
		
		do {
			try {
				// 선택지 출력
				System.out.println("--menu--");
				System.out.println("1. 메뉴등록 | 2. 메뉴삭제 | 3. 가격수정 | 4. 메뉴보기 | 5. 주문 | 6. 주문내역출력 | 7. 종료");
				System.out.print("> ");

				// 선택지 입력
				input = Integer.parseInt(scan.nextLine());

				// 선택지 처리
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
				System.out.println("잘못된 입력");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("해당하는 메뉴가 없습니다.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (input != 7);

		System.out.println("종료");
		scan.close();
	}

}

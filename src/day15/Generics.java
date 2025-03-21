package day15;

import java.util.Scanner;

public class Generics {
	public static void main(String[] args) {
		/* 제네릭(Generics) : 데이터의 타입을 나중에 확정하는 기법
		 * 클래스나 메서드를 생성할 때 어떤 데이터가 들어올지 확신이 없다면...
		 * 제네릭 타입으로 구현 => 나중에 객체를 생성할 때 타입을 확정하여 구현
		 * 
		 * 객체의 타입을 컴파일 할 때 체크가 가능하여,
		 * 타입의 안정성을 해치지 않는 선에서 적당한 형변환이 가능
		 * 안정성 - 의도하지 않은 타입의 객체가 저장되는 것을 막는 의미
		 * */

		// List<E> list = new ArrayList<E>();
		// HashMap<K, V> map = new HashMap<K, V>();

		/* Sale 클래스를 제네릭으로 생성
		 * main
		 * 1. 메뉴 추가 | 2. 메뉴 보기 | 3. 제품 주문 | 4. 주문 내역 보기 | 5. 종료
		 * */

		Scanner scan = new Scanner(System.in);
		SaleController sc = new SaleController();
		int menu = 0;

		while (menu != 5) {
			try {
				System.out.println("1. 메뉴 추가 | 2. 메뉴 보기 | 3. 제품 주문 | 4. 주문 내역 보기 | 5. 종료");
				System.out.print("> ");

				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {
				case 1:
					sc.add(scan);
					break;
				case 2:
					sc.print();
					break;
				case 3:
					sc.order(scan);
					break;
				case 4:
					sc.orderPrint();
					break;
				case 5:
					System.out.println("종료");
					break;
				default:
					throw new Exception("입력 오류");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		scan.close();
	}
}
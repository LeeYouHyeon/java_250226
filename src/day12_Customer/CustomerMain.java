package day12_Customer;

public class CustomerMain {
	public static void main(String[] args) {
		/* 백화점
		 * - 일반 고객 / Gold 고객(할인) / VIP 고객(할인)
		 * 
		 * 1. 고객
		 * 1) 멤버 변수
		 * 	- 고객 ID : int customerID
		 * 	- 고객 이름 : String customerName
		 * 	- 고객 등급 : String customerGrade = Silver
		 * 		- Silver(기본) / Gold / VIP
		 * 	- 보너스 포인트 : int bonusPoint
		 *  - 보너스 적립 비율 : double bonusRatio = 0.01(= 1%)
		 * 
		 * class Customer {
		 * 	- 메서드
		 * 	1. 보너스 적립 계산 메서드 : int calcPrice(int item)
		 * 		- 구매 금액의 적립 보너스를 계산해 bonusPoint에 누적
		 * 		- 보너스 적립, 할인 여부를 체크해서 구매 price를 return
		 * 
		 * 	2. 출력 메서드 : void customerInfo()
		 * 		- 형식
		 * 			(customerName)님은 (customerGrade) 고객이며, 보너스 포인트는 (bonusPoint)점입니다.
		 * 		- VIP일 경우의 추가 문장
		 * 			전담 상담사는 (이름)이고, 번호는 (int)입니다.
		 * 
		 * 	3. 등급별 할인 적립 여부
		 * 		- Silver 등급 : 0% 할인, 1% 적립
		 * 		- Gold 등급 : 10% 할인, 2% 적립
		 * 		- VIP 등급 : 10% 할인, 3% 적립, 전담 상담사(String agentName, String agentNum)
		 * 
		 * Customer : Silver
		 * GoldCustomer extends Customer
		 * VIPCustomer extends Customer
		 * */
		
		Customer[] customers = new Customer[4];
		customers[0] = new Customer(101, "일반");
		customers[1] = new GoldCustomer(102, "고급");
		customers[2] = new VIPCustomer(103, "귀빈", "순이", "1001");
		customers[3] = new VIPCustomer(104, "김철수", "영수", "1002");
		for(Customer customer : customers) {
			customer.customerInfo();
			System.out.println("1만원짜리 상품을 삽니다. 지불할 가격은 " + customer.calcPrice(10000) + "원입니다.");
			customer.customerInfo();
			System.out.println();
		}
		
		// 다운캐스팅 사용
		// 1001.순이 상담사가 퇴사해서 1003으로 변경하는 것
		for(Customer c : customers) {
			if(c instanceof VIPCustomer) {
				VIPCustomer vip = (VIPCustomer)c;
				if(vip.getAgentNum().equals("1001")) {
					vip.setAgentName("상담");
					vip.setAgentNum("1003");
				}
			}
		}
		
		for(Customer c : customers) {
			c.customerInfo();
		}
	}
}
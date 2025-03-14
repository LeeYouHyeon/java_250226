package day12_Customer;

public class CustomerMain {
	public static void main(String[] args) {
		/* ��ȭ��
		 * - �Ϲ� �� / Gold ��(����) / VIP ��(����)
		 * 
		 * 1. ��
		 * 1) ��� ����
		 * 	- �� ID : int customerID
		 * 	- �� �̸� : String customerName
		 * 	- �� ��� : String customerGrade = Silver
		 * 		- Silver(�⺻) / Gold / VIP
		 * 	- ���ʽ� ����Ʈ : int bonusPoint
		 *  - ���ʽ� ���� ���� : double bonusRatio = 0.01(= 1%)
		 * 
		 * class Customer {
		 * 	- �޼���
		 * 	1. ���ʽ� ���� ��� �޼��� : int calcPrice(int item)
		 * 		- ���� �ݾ��� ���� ���ʽ��� ����� bonusPoint�� ����
		 * 		- ���ʽ� ����, ���� ���θ� üũ�ؼ� ���� price�� return
		 * 
		 * 	2. ��� �޼��� : void customerInfo()
		 * 		- ����
		 * 			(customerName)���� (customerGrade) ���̸�, ���ʽ� ����Ʈ�� (bonusPoint)���Դϴ�.
		 * 		- VIP�� ����� �߰� ����
		 * 			���� ����� (�̸�)�̰�, ��ȣ�� (int)�Դϴ�.
		 * 
		 * 	3. ��޺� ���� ���� ����
		 * 		- Silver ��� : 0% ����, 1% ����
		 * 		- Gold ��� : 10% ����, 2% ����
		 * 		- VIP ��� : 10% ����, 3% ����, ���� ����(String agentName, String agentNum)
		 * 
		 * Customer : Silver
		 * GoldCustomer extends Customer
		 * VIPCustomer extends Customer
		 * */
		
		Customer[] customers = new Customer[4];
		customers[0] = new Customer(101, "�Ϲ�");
		customers[1] = new GoldCustomer(102, "���");
		customers[2] = new VIPCustomer(103, "�ͺ�", "����", "1001");
		customers[3] = new VIPCustomer(104, "��ö��", "����", "1002");
		for(Customer customer : customers) {
			customer.customerInfo();
			System.out.println("1����¥�� ��ǰ�� ��ϴ�. ������ ������ " + customer.calcPrice(10000) + "���Դϴ�.");
			customer.customerInfo();
			System.out.println();
		}
		
		// �ٿ�ĳ���� ���
		// 1001.���� ���簡 ����ؼ� 1003���� �����ϴ� ��
		for(Customer c : customers) {
			if(c instanceof VIPCustomer) {
				VIPCustomer vip = (VIPCustomer)c;
				if(vip.getAgentNum().equals("1001")) {
					vip.setAgentName("���");
					vip.setAgentNum("1003");
				}
			}
		}
		
		for(Customer c : customers) {
			c.customerInfo();
		}
	}
}
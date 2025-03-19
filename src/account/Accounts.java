package account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ���� ��� �� Ȯ��
public class Accounts {
	private List<Account> accounts = new ArrayList<Account>();
	
	public Accounts() {}
	public Accounts(Account...accounts) {
		for(Account a : accounts) {
			this.accounts.add(a);
		}
	}
	
	// ID�� ������ ã�� ������ return
	// ������ null
	private Account searchID(String id) {
		for(Account a : accounts) {
			if(a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
	// 1. ���� ���
	public void register(Scanner scan) {
		System.out.println("ȸ�������մϴ�.");
		boolean condition;
		
		// 1. ID ���
		condition = false;
		String id;
		do {
			condition = true;
			
			// 1-1. ID �Է�
			System.out.print("ID> ");
			id = scan.nextLine();
			
			// 1-2. ID ���� �˻�
			// 1-2-1. �ߺ� �˻�
			if(findByID(id)) {
				System.out.println("�̹� �ִ� �����Դϴ�.");
				return;
			}
			//TODO
			
			if(!condition) {
				System.out.println("ID�� ���ǿ� ���� �ʽ��ϴ�.");
				System.out.print("�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
			
		} while(!condition);
		
		
		// 2. ��й�ȣ ���
		condition = false;
		String password;
		do {
			condition = true;
			
			// 2-1. ��й�ȣ �Է�
			System.out.print("��й�ȣ> ");
			password = scan.nextLine();
			
			// 2-2. ��й�ȣ ���� �˻�
			//TODO
			
			if(!condition) {
				System.out.println("��й�ȣ�� ���ǿ� ���� �ʽ��ϴ�.");
				System.out.print("�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
			
		} while(!condition);
		
		
		// 3. ��й�ȣ ���Է�
		condition = false;
		do {
			System.out.print("��й�ȣ �ٽ� �Է�> ");
			if(scan.nextLine().equals(password)) {
				condition = true;
			} else {
				System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
				System.out.print("�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
		} while(!condition);
		
		// 4. �̸��� ���
		condition = false;
		String email;
		do {
			condition = true;
			
			// 4-1. �̸��� �Է�
			System.out.print("�̸���> ");
			email = scan.nextLine();
			
			// 4-2. �̸��� ���� �˻�
			//TODO
			
			if(!condition) {
				System.out.println("�߸��� �̸����Դϴ�.");
				System.out.print("�ٽ� �Է��Ͻðڽ��ϱ�?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
		} while(!condition);
		
		
		// 4. ���� ���
		accounts.add(new Account(id, password, email));
		System.out.println("��ϵǾ����ϴ�.");
	}
	
	// 2. ID�� ��й�ȣ�� �޾Ƽ� �´��� Ȯ��
	public boolean check(String id, String password) {
		Account a = searchID(id);
		
		return (a == null) ? false : a.getPassword().equals(password);
	}
	
	// 3. ���� ����
	//TODO
	public void deleteAccount(Scanner scan) {
	}
	
	// 4. ID => ������ �ִ°�
	public boolean findByID(String id) {
		return searchID(id) != null;
	}
}

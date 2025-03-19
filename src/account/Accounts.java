package account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 계정 등록 및 확인
public class Accounts {
	private List<Account> accounts = new ArrayList<Account>();
	
	public Accounts() {}
	public Accounts(Account...accounts) {
		for(Account a : accounts) {
			this.accounts.add(a);
		}
	}
	
	// ID로 계정을 찾아 계정을 return
	// 없으면 null
	private Account searchID(String id) {
		for(Account a : accounts) {
			if(a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
	// 1. 계정 등록
	public void register(Scanner scan) {
		System.out.println("회원가입합니다.");
		boolean condition;
		
		// 1. ID 등록
		condition = false;
		String id;
		do {
			condition = true;
			
			// 1-1. ID 입력
			System.out.print("ID> ");
			id = scan.nextLine();
			
			// 1-2. ID 조건 검사
			// 1-2-1. 중복 검사
			if(findByID(id)) {
				System.out.println("이미 있는 계정입니다.");
				return;
			}
			//TODO
			
			if(!condition) {
				System.out.println("ID가 조건에 맞지 않습니다.");
				System.out.print("다시 입력하시겠습니까?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
			
		} while(!condition);
		
		
		// 2. 비밀번호 등록
		condition = false;
		String password;
		do {
			condition = true;
			
			// 2-1. 비밀번호 입력
			System.out.print("비밀번호> ");
			password = scan.nextLine();
			
			// 2-2. 비밀번호 조건 검사
			//TODO
			
			if(!condition) {
				System.out.println("비밀번호가 조건에 맞지 않습니다.");
				System.out.print("다시 입력하시겠습니까?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
			
		} while(!condition);
		
		
		// 3. 비밀번호 재입력
		condition = false;
		do {
			System.out.print("비밀번호 다시 입력> ");
			if(scan.nextLine().equals(password)) {
				condition = true;
			} else {
				System.out.println("비밀번호가 맞지 않습니다.");
				System.out.print("다시 입력하시겠습니까?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
		} while(!condition);
		
		// 4. 이메일 등록
		condition = false;
		String email;
		do {
			condition = true;
			
			// 4-1. 이메일 입력
			System.out.print("이메일> ");
			email = scan.nextLine();
			
			// 4-2. 이메일 조건 검사
			//TODO
			
			if(!condition) {
				System.out.println("잘못된 이메일입니다.");
				System.out.print("다시 입력하시겠습니까?(Y/N)> ");
				if(scan.nextLine().toLowerCase().equals("n")) {
					return;
				}
			}
		} while(!condition);
		
		
		// 4. 계정 등록
		accounts.add(new Account(id, password, email));
		System.out.println("등록되었습니다.");
	}
	
	// 2. ID와 비밀번호를 받아서 맞는지 확인
	public boolean check(String id, String password) {
		Account a = searchID(id);
		
		return (a == null) ? false : a.getPassword().equals(password);
	}
	
	// 3. 계정 삭제
	//TODO
	public void deleteAccount(Scanner scan) {
	}
	
	// 4. ID => 계정이 있는가
	public boolean findByID(String id) {
		return searchID(id) != null;
	}
}

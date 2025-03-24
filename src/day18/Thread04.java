package day18;

class Bank {
	// 계좌
	private int money = 10000;
	
	// 입금 : 동기화 (synchronized)
	public synchronized void saveMoney(int money) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.money += money;
	}
	
	// 출금 : 동기화 (synchronized)
	public synchronized void minusMoney(int money) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(this.money < money) {
			System.out.println("잔액이 부족합니다.");
		} else {
			this.money -= money;
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}

// 홍길동 객체 => 입금
class Hong extends Thread {

	@Override
	public void run() {
		System.out.println("홍길동 님이 입금합니다.");
		Thread04.myBank.saveMoney(10000);
		System.out.println("saveMoney(10000) > " + Thread04.myBank.getMoney());
	}
	
}

// 홍길동 와이프 객체 => 출금
class HongWife extends Thread {

	@Override
	public void run() {
		System.out.println("홍길동 와이프 님이 출금합니다.");
		Thread04.myBank.minusMoney(5000);
		System.out.println("saveMoney(5000) > " + Thread04.myBank.getMoney());
	}
	
}

public class Thread04 {
	// 계좌 생성 : 공유영역에 생성
	public static Bank myBank = new Bank();
	
	public static void main(String[] args) {
		
		Hong h = new Hong();
		HongWife hw = new HongWife();
		
		hw.start();
		System.out.println("---------------");
		h.start();
		System.out.println("---------------");
		
		
		/* critical section(임계영역 : 공유영역)
		 * 두 개 이상의 thread가 동시에 접근할 수 있는 구역
		 * 동시에 여러 개의 thread가 공유영역의 값을 가지려고 하면 충돌이 발생할 수 있음
		 * 교착상태(deadlock)가 발생
		 * 한 순간에 하나의 thread만 사용가능 : 세마포어(semaphore)
		 * 세마포어를 얻은 스레드만 접근 가능 / 나머지는 대기상태
		 * 
		 * 동기화(순서화) : synchronized
		 * 동기화가 필요한 메서드 앞에 키워드로 선언
		 * */
		
		/* Bank 클래스 생성
		 * 계좌 1개 생성 : 급여통장 => 공유영역 (static)
		 * 홍길동 : hong / 홍길동와이프 : hongwife
		 * 잔액 : 10000
		 * */
	}
}


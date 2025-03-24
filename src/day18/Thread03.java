package day18;

public class Thread03 {
	public static void main(String[] args) {
		/* 1~50, 51~100의 합을 구하는 두 개의 Thread 생성
		 * 
		 * 두 개의 Thread가 실행되고 난 뒤
		 * Thread-0 : 1~50 출력 후 합계 출력
		 * Thread-1 : 51~100 출력 후 합계 출력
		 * 
		 * main : 두 스레드의 결과의 합을 출력
		 * 
		 * Thread.sleep() : 기다렸다가 실행
		 * millisecond 단위 => 1초 = 1000
		 * */
		JoinTest jt1 = new JoinTest(1, 50),
				jt2 = new JoinTest(51, 100);
		
		jt1.start();
		try {
			jt1.join();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(jt1.getSum());
		
		jt2.start();
		try {
			jt2.join();
			Thread.sleep(1000);
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
		System.out.println(jt2.getSum());
		
		System.out.println(jt1.getSum() + jt2.getSum());
	}
}

class JoinTest extends Thread {
	private int sum;
	private int start, end;
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			System.out.println(i + ". " + getName());
			sum += i;
		}
	}

	public int getSum() {
		return sum;
	}
}
package day18;

public class Thread01 {
	public static void main(String[] args) {
		/* Thread(쓰레드) : 실제 작업을 수행하는 단위
		 * - 프로그램이 실행되면 OS로부터 메모리를 할당받아 process의 상태가 됨
		 * - process 안에 작은 작업단위 Thread 단위로 실제 작업을 수행
		 * - Thread가 실제 CPU가 작업을 처리하는 단위
		 * - multi-thread : 여러 개의 thread가 동시에 수행되는 프로그램
		 * - CPU는 시간을 잘게 쪼개서 thread를 번갈아 수행함(시분할 처리)
		 * - 사용자들을 동시에 처리되는 듯한 효과를 가지게 됨
		 * - thread는 각자의 자신만의 작업공간을 가짐(context)
		 * - 각 thread는 공유자원이 있을 수 있음.
		 * - 여러 thread들이 그 공유자원을 사용하려고 경쟁이 발생함 => critical section(임계영역)
		 * - 임계영역의 충돌 => deadlock(교착상태)가 발생하지 않도록 동기화(순차 처리)를 구현하여 오류를 막음
		 * */
		
		/* thread를 구현하는 방법 2가지
		 * 1. Thread 클래스를 상속해서 만들기(쉬움)
		 * 2. runnable 인터페이스를 구현하여 만들기(어려움)
		 * 자바는 다중상속을 허용하지 않기 때문에, 다른 클래스를 상속중이라면 인터페이스를 구현해야 함.
		 * */
		
		// 현재 실행중인 스레드 이름
		System.out.println(Thread.currentThread().getName());
		
		MyThread th = new MyThread();
		// run() 메서드 실행
		th.start();
		
		MyThread th2 = new MyThread();
		th2.start();
		
		System.out.println("thread end");
	}
}

class MyThread extends Thread {
	
	// 반드시 run() 메서드를 구현해야 함
	@Override
	public void run() {
		// 1~500 반복실행
		for(int i = 0; i < 500; i++) {
			System.out.println(i + 1 + ". " + getName()); // getName() : thread의 이름
		}
	}
	
}
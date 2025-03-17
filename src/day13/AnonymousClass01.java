package day13;

public class AnonymousClass01 {
	public static void main(String[] args) {
		/* 익명 클래스(Anonymous Class) : 내부 클래스의 일종
		 * 나중에 다시 객체를 만들 일이 없음을 의미
		 * 한 번 쓰고 버려지는 객체(일회용 클래스)
		 * 
		 * 인터페이스를 사용하여 객체를 생성할 경우
		 * - 인터페이스의 구현 외 다른 구현이 없고,
		 * - 해당 객체를 하나만 사용하는 경우
		 * - 인터페이스의 기능이 적은 경우
		 * - 메서드의 매개변수로 사용하는 케이스에서 주로 사용
		 * */
		new AnonymousClass01().product(new Power() {
			@Override
			public void turnOn() {
				System.out.println("전원이 켜집니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("전원이 꺼집니다.");
			}
		});
	}

	public void product(Power p) {
		p.turnOn();
		System.out.println("작동중...");
		p.turnOff();
	}
}

interface Power {
	void turnOn();

	void turnOff();
}
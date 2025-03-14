package day11;

public class Interface01 {
	public static void main(String[] args) {
		/* 인터페이스 : 추상 메서드와 상수(final)로만 이루어진 추상 클래스
		 * 추상 메서드 : 메서드의 선언부만 있고, 구현부는 없는 메서드
		 * 추상 클래스 / 인터페이스 => 반드시 구현해야 객체를 생성할 수 있음
		 * 
		 * 인터페이스 키워드 : interface
		 * - 기능 요약서 : 매뉴얼화
		 * - 자체적으로 사용할 수 없고, 인터페이스를 구현한 클래스로 활용
		 * - 구현 키워드 : implements
		 * - 인터페이스는 멤버변수가 없음
		 * 
		 * - 상속 : 다중 상속이 불가능 (단일 상속이 원칙)
		 * - 구현 : 다중 구현이 가능
		 * - 상속 + 구현 동시에 가능
		 * */
		TV tv = new TV();
		tv.turnOn();
		tv.chUp();
		tv.volUp();
		tv.turnOff();
		
	}
}

interface Power {
	void turnOn();

	void turnOff();
}

interface Remocon {
	void volUp();

	void volDown();

	void chUp();

	void chDown();
}

// class TV extends A implements B, C, ... {}

class TV implements Power, Remocon {
	private boolean power;
	private int vol, ch;

	@Override
	public void volUp() {
		if (power) {
			vol++;
			printVol();
		}
	}

	@Override
	public void volDown() {
		if (power) {
			vol--;
			printVol();
		}
	}

	@Override
	public void turnOn() {
		power = true;
		System.out.println("TV ON");
	}

	@Override
	public void turnOff() {
		System.out.println("TV OFF");
		power = false;
	}

	@Override
	public void chUp() {
		if (power) {
			ch++;
			printCh();
		}

	}

	@Override
	public void chDown() {
		if (power) {
			ch--;
			printCh();
		}

	}

	public void printVol() {
		System.out.println("vol:" + vol);
	}

	public void printCh() {
		System.out.println("ch:" + ch);
	}
}
package day12;

public class Polymorphism {

	public static void main(String[] args) {
		/* 객체지향 프로그램의 4가지 특징
		 * - 프로그램 : 독립적인 단위인 객체들을 모아서 처리하는 모임
		 * - 각각의 객체는 메시지를 주고받으면서 데이터를 처리
		 * - 추상화, 캡슐화(정보은닉), 상속, 다형성
		 * 
		 * - 추상화(Abstraction) : 공통적인 코드만 제공
		 *	- 구현된 부분과(공통코드), 구현되지 않은 부분(개별코드)을 분리
		 *	- 개별적인 부분은 표현되지 않는 기능
		 *
		 * - 캡슐화(Encapsulation) : 데이터 보호(정보은닉)
		 * 	- 멤버변수는 숨기고, 메서드를 통해 접근
		 * 	- 멤버변수와 메서드를 하나로 묶어서 처리
		 * 	- 은닉 : 객체 내부의 정보를 숨겨서 외부로 드러나지 않게 하는 것
		 * 	- 은닉의 이유 : 외부에서 데이터에 직접 접근하는 것을 막음
		 * 
		 * - 상속(Inheritance) : 코드 재사용(확장)
		 * 	- 클래스가 상속받아서 일부만 수정하면 중복 코드를 줄일 수 있음
		 * 	- 유지보수가 편함
		 * 
		 * - 다형성(Polymorphism) : 객체의 형변환
		 * 	- 하나의 코드(부모 객체)가 여러 자료(자식 객체)형으로 구현되어 실행되는 것
		 * 	- 코드는 같은데 들어오는 객체에 따라 다른 실행결과를 얻을 수 있음
		 * 	- 유연하고 확장성 있는, 유지보수가 편리한 프로그램을 만들 수있다.
		 * */

		// Human, tiger, eagle, dog 객체를 각자 생성
//		Human h = new Human();
//		h.move();
//		h.readBook();
//		System.out.println();
//		
//		Tiger t = new Tiger();
//		t.move();
//		t.hunt();
//		System.out.println();
//		
//		Eagle e = new Eagle();
//		e.move();
//		e.fly();
//		System.out.println();
//		
//		Dog d = new Dog();
//		d.move();
//		System.out.println();

		Animal[] animals = new Animal[5];
		// up-casting : 자동으로 처리됨
		animals[0] = new Human();
		animals[1] = new Tiger();
		animals[2] = new Eagle();
		animals[3] = new Dog();
		animals[4] = new Animal();

		for (Animal a : animals) {
			new Polymorphism().moveAnimal(a);
			System.out.println();
		}
	}

	public void moveAnimal(Animal animal) {
		// Animal(부모 클래스)에 있는 메서드라 객체에 상관없이 가능
		animal.move();
		
		// 자식 객체만 가지고 있는 기능은 다운캐스팅 후에 사용 가능
		// 다운캐스팅은 자동으로 되지 않아, casting을 명시해줘야 함
		// instanceof 연산자 사용
		// ※ 캐스팅 오류는 Exception으로, 문법 단계에서는 오류를 확인할 수 없다. 
		if (animal instanceof Human) {
			((Human) animal).readBook();
		}
		if (animal instanceof Tiger) {
			((Tiger) animal).hunt();
		}
		if (animal instanceof Eagle) {
			((Eagle) animal).fly();
		}
	}
}

class Animal {
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Dog extends Animal {

	@Override
	public void move() {
		System.out.println("강아지가 아장아장 걷습니다.");
	}
}

class Tiger extends Animal {

	@Override
	public void move() {
		System.out.println("호랑이가 네 발로 어슬렁거립니다.");
	}

	public void hunt() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

class Eagle extends Animal {

	@Override
	public void move() {
		System.out.println("독수리가 하늘을 납니다.");
	}

	public void fly() {
		System.out.println("독수리가 하늘에서 사냥을 합니다.");
	}
}

class Human extends Animal {

	@Override
	public void move() {
		System.out.println("사람은 두 발로 걷습니다.");
	}

	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}
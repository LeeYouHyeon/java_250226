package day11;

public class Abstract01 {
	public static void main(String[] args) {
		/* 추상 메서드 : 메서드의 선언부만 있고 구현은 없는 메서드
		 * 추상 클래스 : 추상 메서드( + 일반 메서드 + 멤버 변수 + 상수(final))
		 * 추상 클래스는 미완성 클래스이므로 객체를 생성할 수 없음
		 * 키워드 : abstract
		 * 	- 메서드 : 접근제한자 abstract 리턴타입 메서드명(매개변수);
		 * 	- 클래스 : 접근제한자 abstract class 클래스명 {}
		 * 	- 인터페이스 : 접근제한자 interface 인터페이스명 {}
		 * 		- 인터페이스는 추상 메서드만 가지는 추상 클래스
		 * 		- 인터페이스는 abstract 키워드를 생략할 수 있음
		 * 	- 리턴타입, class, interface 키워드 전에 오는 키워드들은 순서 상관없음
		 * 
		 * - 상속을 하기 위한 부모 클래스를 만들기 위해 사용
		 * - 상속을 받은 자식 클래스는 반드시 추상 메서드를 구현해야 함.
		 * 	- 자식도 추상 클래스면 일부를 미완성으로 남길 수 있음
		 * */
		
		Dog dog = new Dog("뽀삐", "개");
		dog.printInfo();
		dog.howl();
		dog.eating("고기");
		
		Cat cat = new Cat("송이", "고양이");
		cat.printInfo();
		cat.howl();
	}
}

class Cat extends Animal {
	private String toy;
	
	public Cat(String name, String category) {
		setName(name);
		setCategory(category);
	}

	@Override
	public void howl() {
		System.out.println(name + " 울음소리 : " + "야옹");
		
	}
	
	public void playing(String toy) {
		setToy(toy);
		System.out.println(name + "은 " + toy + "를 좋아합니다.");
	}

	public String getToy() {
		return toy;
	}

	public void setToy(String toy) {
		this.toy = toy;
	}
}

class Dog extends Animal {
	private String eat;
	
	public Dog(String name, String category) {
		super.setName(name);
		super.setCategory(category);
	}
	
	@Override
	public void howl() {
		System.out.println(super.name + " 울음소리 : " + "멍멍");
	}
	
	public void eating(String eat) {
		setEat(eat);
		System.out.println(name + "은 " + eat + "를 좋아합니다.");
	}

	public String getEat() {
		return eat;
	}

	public void setEat(String eat) {
		this.eat = eat;
	}
}

abstract class Animal {
	protected String name, category;
	
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("종 : " + category);
	}
	public abstract void howl();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
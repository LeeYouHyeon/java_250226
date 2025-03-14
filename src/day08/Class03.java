package day08;

public class Class03 {
	public static void main(String[] args) {
		Car1 c = new Car1(); // 기본생성자 호출 => 기본값으로 세팅
		c.printInfo();
		System.out.println("-----------");
		Car1 c1 = new Car1("모닝", "2025");
		c1.printInfo();
		System.out.println("-----------");
		Car1 c2 = new Car1("아반떼", "2022", "검정", 4);
		c2.printInfo();
	}
}

// class Car {}
// 같은 패키지에 같은 이름의 클래스를 사용하면 error
class Car1 {

	// 멤버변수 : name, year, color, door(갯수), power, speed
	private String name, year, color;
	private int door;
	
	private int speed;
	private boolean power;
	
	//생성자 위치 - 멤버변수 아래, 메서드 위
	/* 객체를 생성할 때 초깃값을 지정해주는 역할
	 * 기본생성자 : 0, null (컴파일 시 자동 제공)
	 * - 생성자는 여러 개 생성 가능(생성자 오버로딩)
	 * - 오버로딩 조건 : 매개변수의 갯수, 타입이 달라야 함(둘 중에 하나라도)
	 * - 사용자가 생성자를 만들면 기본 생성자는 사라진다.
	 * - => 생성자를 만들 때는 곡 기본생성자와 같이 생성해야 한다.
	 * - public 클래스명(매개변수) {
	 * 	초깃값 지정;
	 * }
	 * - 생성자는 리턴 타입이 없는 메서드와 같은 형태
	 * */
	
	public Car1() {} // 기본생성자
	
	// 생성자 오버로딩
	public Car1(String name, String year) {
		this.name = name;
		this.year = year;
	}
	public Car1(String name, String year, String color, int door) {
		// 생성자 호출
		// - 가장 윗줄에서만 가능
		this(name, year);
		this.color = color;
		this.door = door;
	}

	// 차량 정보 출력
	public void printInfo() {
		System.out.println(name + "(" + year + ")");
		System.out.println(color + "(" + door + ")");
	}

	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}
}
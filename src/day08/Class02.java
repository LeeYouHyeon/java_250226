package day08;

public class Class02 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.setName("모닝");
		myCar.setColor("검정");
		myCar.setYear("2025");
		myCar.printCar();
		myCar.power();
		myCar.setSpeed(180);
		for (int i = 0; i < 5; i++)
			myCar.speedUp();

		myCar.setSpeed(20);
		for (int i = 0; i < 5; i++)
			myCar.speedDown();
		myCar.power();
		myCar.speedPrint();
	}
}

class Car {
	// 멤버변수 : name, color, year, power, speed => private
	// year(출고 연도)는 연산을 행하지 않으므로 String
	private String name, color, year;

	private boolean power = false;
	private int speed;

	// 메서드 => public

	// 현재 멤버변수의 상태 출력
	public void printCar() {
		System.out.println(name + "(" + color + ") : " + year);
	}

	public void speedPrint() {
		System.out.println((power ? "ON" : "OFF") + " / " + speed);
	}

	// 시동 켜기/끄기 메서드 (하나의 메서드로)
	public void power() {
		if (speed == 0) {
			power = !power;
		} else {
			System.out.println("error");
		}
	}

	// 속도를 올리는 메서드 speedUp()
	public void speedUp() {
		if (power) {
			if (speed < 190)
				speed += 10;
			else
				speed = 200;
			speedPrint();
		}
	}

	// 속도를 내리는 메서드 speedDown()
	public void speedDown() {
		if (power) {
			if (speed > 10)
				speed -= 10;
			else
				speed = 0;
			speedPrint();
		}
	}

	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
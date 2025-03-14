package day08;

public class Class02 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.setName("���");
		myCar.setColor("����");
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
	// ������� : name, color, year, power, speed => private
	// year(��� ����)�� ������ ������ �����Ƿ� String
	private String name, color, year;

	private boolean power = false;
	private int speed;

	// �޼��� => public

	// ���� ��������� ���� ���
	public void printCar() {
		System.out.println(name + "(" + color + ") : " + year);
	}

	public void speedPrint() {
		System.out.println((power ? "ON" : "OFF") + " / " + speed);
	}

	// �õ� �ѱ�/���� �޼��� (�ϳ��� �޼����)
	public void power() {
		if (speed == 0) {
			power = !power;
		} else {
			System.out.println("error");
		}
	}

	// �ӵ��� �ø��� �޼��� speedUp()
	public void speedUp() {
		if (power) {
			if (speed < 190)
				speed += 10;
			else
				speed = 200;
			speedPrint();
		}
	}

	// �ӵ��� ������ �޼��� speedDown()
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
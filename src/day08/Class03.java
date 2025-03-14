package day08;

public class Class03 {
	public static void main(String[] args) {
		Car1 c = new Car1(); // �⺻������ ȣ�� => �⺻������ ����
		c.printInfo();
		System.out.println("-----------");
		Car1 c1 = new Car1("���", "2025");
		c1.printInfo();
		System.out.println("-----------");
		Car1 c2 = new Car1("�ƹݶ�", "2022", "����", 4);
		c2.printInfo();
	}
}

// class Car {}
// ���� ��Ű���� ���� �̸��� Ŭ������ ����ϸ� error
class Car1 {

	// ������� : name, year, color, door(����), power, speed
	private String name, year, color;
	private int door;
	
	private int speed;
	private boolean power;
	
	//������ ��ġ - ������� �Ʒ�, �޼��� ��
	/* ��ü�� ������ �� �ʱ갪�� �������ִ� ����
	 * �⺻������ : 0, null (������ �� �ڵ� ����)
	 * - �����ڴ� ���� �� ���� ����(������ �����ε�)
	 * - �����ε� ���� : �Ű������� ����, Ÿ���� �޶�� ��(�� �߿� �ϳ���)
	 * - ����ڰ� �����ڸ� ����� �⺻ �����ڴ� �������.
	 * - => �����ڸ� ���� ���� �� �⺻�����ڿ� ���� �����ؾ� �Ѵ�.
	 * - public Ŭ������(�Ű�����) {
	 * 	�ʱ갪 ����;
	 * }
	 * - �����ڴ� ���� Ÿ���� ���� �޼���� ���� ����
	 * */
	
	public Car1() {} // �⺻������
	
	// ������ �����ε�
	public Car1(String name, String year) {
		this.name = name;
		this.year = year;
	}
	public Car1(String name, String year, String color, int door) {
		// ������ ȣ��
		// - ���� ���ٿ����� ����
		this(name, year);
		this.color = color;
		this.door = door;
	}

	// ���� ���� ���
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
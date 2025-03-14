package day11;

public class Abstract01 {
	public static void main(String[] args) {
		/* �߻� �޼��� : �޼����� ����θ� �ְ� ������ ���� �޼���
		 * �߻� Ŭ���� : �߻� �޼���( + �Ϲ� �޼��� + ��� ���� + ���(final))
		 * �߻� Ŭ������ �̿ϼ� Ŭ�����̹Ƿ� ��ü�� ������ �� ����
		 * Ű���� : abstract
		 * 	- �޼��� : ���������� abstract ����Ÿ�� �޼����(�Ű�����);
		 * 	- Ŭ���� : ���������� abstract class Ŭ������ {}
		 * 	- �������̽� : ���������� interface �������̽��� {}
		 * 		- �������̽��� �߻� �޼��常 ������ �߻� Ŭ����
		 * 		- �������̽��� abstract Ű���带 ������ �� ����
		 * 	- ����Ÿ��, class, interface Ű���� ���� ���� Ű������� ���� �������
		 * 
		 * - ����� �ϱ� ���� �θ� Ŭ������ ����� ���� ���
		 * - ����� ���� �ڽ� Ŭ������ �ݵ�� �߻� �޼��带 �����ؾ� ��.
		 * 	- �ڽĵ� �߻� Ŭ������ �Ϻθ� �̿ϼ����� ���� �� ����
		 * */
		
		Dog dog = new Dog("�ǻ�", "��");
		dog.printInfo();
		dog.howl();
		dog.eating("���");
		
		Cat cat = new Cat("����", "�����");
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
		System.out.println(name + " �����Ҹ� : " + "�߿�");
		
	}
	
	public void playing(String toy) {
		setToy(toy);
		System.out.println(name + "�� " + toy + "�� �����մϴ�.");
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
		System.out.println(super.name + " �����Ҹ� : " + "�۸�");
	}
	
	public void eating(String eat) {
		setEat(eat);
		System.out.println(name + "�� " + eat + "�� �����մϴ�.");
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
		System.out.println("�̸� : " + name);
		System.out.println("�� : " + category);
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
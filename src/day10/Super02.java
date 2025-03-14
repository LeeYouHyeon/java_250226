package day10;

public class Super02 {
	public static void main(String[] args) {
		
		Dog d = new Dog("�ǻ�", "����");
		d.printInfo();
		d.howl();
		
		System.out.println();
		Cat c = new Cat("����", "����̰�");
		c.printInfo();
		c.howl();
	}
}

class Cat extends Animal {
	public Cat(String name, String category) {
		setName(name);
		setCategory(category);
	}

	@Override
	public void howl() {
		// TODO Auto-generated method stub
		super.howl();
		System.out.println("�߿�");
	}
}

class Dog extends Animal {
	public Dog(String name, String category) {
		// 1) �θ��� ������ ȣ��
		super(name, category);
		
		// 2) �θ��� setter ȣ��
//		super.setName(name);
//		super.setCategory(category);
	}

	@Override
	public void howl() {
		super.howl();
		System.out.println("�۸�");
	}
}

class Animal { // �θ�
	private String name; // �̸�
	private String category; // ��

	// ������
	public Animal() {
	}
	public Animal(String name, String category) {
		this.name = name;
		this.category = category;
	}

	// ��� �޼���
	public void printInfo() {
		System.out.println("�̸�:" + name);
		System.out.println("��:" + category);
	}
	// �����Ҹ� �޼���
	public void howl() {
		System.out.println("--" + name + " �����Ҹ�--");
	}
	
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
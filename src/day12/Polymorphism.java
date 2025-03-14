package day12;

public class Polymorphism {

	public static void main(String[] args) {
		/* ��ü���� ���α׷��� 4���� Ư¡
		 * - ���α׷� : �������� ������ ��ü���� ��Ƽ� ó���ϴ� ����
		 * - ������ ��ü�� �޽����� �ְ�����鼭 �����͸� ó��
		 * - �߻�ȭ, ĸ��ȭ(��������), ���, ������
		 * 
		 * - �߻�ȭ(Abstraction) : �������� �ڵ常 ����
		 *	- ������ �κа�(�����ڵ�), �������� ���� �κ�(�����ڵ�)�� �и�
		 *	- �������� �κ��� ǥ������ �ʴ� ���
		 *
		 * - ĸ��ȭ(Encapsulation) : ������ ��ȣ(��������)
		 * 	- ��������� �����, �޼��带 ���� ����
		 * 	- ��������� �޼��带 �ϳ��� ��� ó��
		 * 	- ���� : ��ü ������ ������ ���ܼ� �ܺη� �巯���� �ʰ� �ϴ� ��
		 * 	- ������ ���� : �ܺο��� �����Ϳ� ���� �����ϴ� ���� ����
		 * 
		 * - ���(Inheritance) : �ڵ� ����(Ȯ��)
		 * 	- Ŭ������ ��ӹ޾Ƽ� �Ϻθ� �����ϸ� �ߺ� �ڵ带 ���� �� ����
		 * 	- ���������� ����
		 * 
		 * - ������(Polymorphism) : ��ü�� ����ȯ
		 * 	- �ϳ��� �ڵ�(�θ� ��ü)�� ���� �ڷ�(�ڽ� ��ü)������ �����Ǿ� ����Ǵ� ��
		 * 	- �ڵ�� ������ ������ ��ü�� ���� �ٸ� �������� ���� �� ����
		 * 	- �����ϰ� Ȯ�强 �ִ�, ���������� ���� ���α׷��� ���� ���ִ�.
		 * */

		// Human, tiger, eagle, dog ��ü�� ���� ����
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
		// up-casting : �ڵ����� ó����
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
		// Animal(�θ� Ŭ����)�� �ִ� �޼���� ��ü�� ������� ����
		animal.move();
		
		// �ڽ� ��ü�� ������ �ִ� ����� �ٿ�ĳ���� �Ŀ� ��� ����
		// �ٿ�ĳ������ �ڵ����� ���� �ʾ�, casting�� �������� ��
		// instanceof ������ ���
		// �� ĳ���� ������ Exception����, ���� �ܰ迡���� ������ Ȯ���� �� ����. 
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
		System.out.println("������ �����Դϴ�.");
	}
}

class Dog extends Animal {

	@Override
	public void move() {
		System.out.println("�������� ������� �Ƚ��ϴ�.");
	}
}

class Tiger extends Animal {

	@Override
	public void move() {
		System.out.println("ȣ���̰� �� �߷� ����Ÿ��ϴ�.");
	}

	public void hunt() {
		System.out.println("ȣ���̰� ����� �մϴ�.");
	}
}

class Eagle extends Animal {

	@Override
	public void move() {
		System.out.println("�������� �ϴ��� ���ϴ�.");
	}

	public void fly() {
		System.out.println("�������� �ϴÿ��� ����� �մϴ�.");
	}
}

class Human extends Animal {

	@Override
	public void move() {
		System.out.println("����� �� �߷� �Ƚ��ϴ�.");
	}

	public void readBook() {
		System.out.println("����� å�� �н��ϴ�.");
	}
}
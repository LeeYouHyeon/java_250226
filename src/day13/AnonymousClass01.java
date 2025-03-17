package day13;

public class AnonymousClass01 {
	public static void main(String[] args) {
		/* �͸� Ŭ����(Anonymous Class) : ���� Ŭ������ ����
		 * ���߿� �ٽ� ��ü�� ���� ���� ������ �ǹ�
		 * �� �� ���� �������� ��ü(��ȸ�� Ŭ����)
		 * 
		 * �������̽��� ����Ͽ� ��ü�� ������ ���
		 * - �������̽��� ���� �� �ٸ� ������ ����,
		 * - �ش� ��ü�� �ϳ��� ����ϴ� ���
		 * - �������̽��� ����� ���� ���
		 * - �޼����� �Ű������� ����ϴ� ���̽����� �ַ� ���
		 * */
		new AnonymousClass01().product(new Power() {
			@Override
			public void turnOn() {
				System.out.println("������ �����ϴ�.");
			}

			@Override
			public void turnOff() {
				System.out.println("������ �����ϴ�.");
			}
		});
	}

	public void product(Power p) {
		p.turnOn();
		System.out.println("�۵���...");
		p.turnOff();
	}
}

interface Power {
	void turnOn();

	void turnOff();
}
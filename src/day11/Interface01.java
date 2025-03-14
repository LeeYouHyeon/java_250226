package day11;

public class Interface01 {
	public static void main(String[] args) {
		/* �������̽� : �߻� �޼���� ���(final)�θ� �̷���� �߻� Ŭ����
		 * �߻� �޼��� : �޼����� ����θ� �ְ�, �����δ� ���� �޼���
		 * �߻� Ŭ���� / �������̽� => �ݵ�� �����ؾ� ��ü�� ������ �� ����
		 * 
		 * �������̽� Ű���� : interface
		 * - ��� ��༭ : �Ŵ���ȭ
		 * - ��ü������ ����� �� ����, �������̽��� ������ Ŭ������ Ȱ��
		 * - ���� Ű���� : implements
		 * - �������̽��� ��������� ����
		 * 
		 * - ��� : ���� ����� �Ұ��� (���� ����� ��Ģ)
		 * - ���� : ���� ������ ����
		 * - ��� + ���� ���ÿ� ����
		 * */
		TV tv = new TV();
		tv.turnOn();
		tv.chUp();
		tv.volUp();
		tv.turnOff();
		
	}
}

interface Power {
	void turnOn();

	void turnOff();
}

interface Remocon {
	void volUp();

	void volDown();

	void chUp();

	void chDown();
}

// class TV extends A implements B, C, ... {}

class TV implements Power, Remocon {
	private boolean power;
	private int vol, ch;

	@Override
	public void volUp() {
		if (power) {
			vol++;
			printVol();
		}
	}

	@Override
	public void volDown() {
		if (power) {
			vol--;
			printVol();
		}
	}

	@Override
	public void turnOn() {
		power = true;
		System.out.println("TV ON");
	}

	@Override
	public void turnOff() {
		System.out.println("TV OFF");
		power = false;
	}

	@Override
	public void chUp() {
		if (power) {
			ch++;
			printCh();
		}

	}

	@Override
	public void chDown() {
		if (power) {
			ch--;
			printCh();
		}

	}

	public void printVol() {
		System.out.println("vol:" + vol);
	}

	public void printCh() {
		System.out.println("ch:" + ch);
	}
}
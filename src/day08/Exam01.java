package day08;

public class Exam01 {
	public static void main(String[] args) {
		/* TV Ŭ���� ����
		 * ������� : brand, power, ch(1~30), vol(0~10)(���Ұ�)
		 * 
		 * �޼���
		 * power()
		 * chUp() / chDown()
		 * - 1�� ����
		 * - 1~30�� ����� ��ȯ
		 * 
		 * volUp() / volDown()
		 * - 1�� ���� 
		 * - 0~10�� ����� ����
		 * - 0�̸� ���ҰŶ� ���
		 * */

		TV tv = new TV("�Ｚ");

		tv.power();
		tv.chUp();
		tv.chUp();
		tv.setCh(28);
		tv.chUp();
		tv.chUp();
		tv.chUp();
		tv.chUp();
		tv.chUp();
		System.out.println();
		tv.chDown();
		tv.chDown();
		tv.chDown();
		tv.chDown();
		tv.chDown();
		tv.chDown();
		System.out.println();
		tv.volUp();
		tv.volUp();
		tv.volUp();
		tv.volUp();
		tv.volUp();
		tv.volUp();
		tv.volUp();
		tv.volUp();
		tv.setVol(2);
		tv.volDown();
		tv.volDown();
		tv.volDown();
		tv.volDown();
	}
}

class TV {
	// ��� : ������ �ʴ� �� => final
	// �Ϲ����� ������� �����ϱ� ���� �������� �빮�ڸ����� �ۼ�
	// final ������ setter�� ������ ����
	private final String BRAND;
	private boolean power;
	private int ch, vol;

	// ������
	public TV(String brand) {
		this.BRAND = brand;
		ch = 1;
		vol = 3;
	}
	
	public TV() {
		this("LG");
	}

	public void print() {
		System.out.println(BRAND + "TV, ch:" + ch + " / vol:" + vol);
	}


	// �޼���
	public void power() {
		if (power) {
			System.out.println("������ �����ϴ�.");
		} else {
			System.out.println("������ �����ϴ�.");
			print();
		}
		power = !power;
	}

	public void chUp() {
		if (power) {
			if (++ch > 30) {
				while (ch > 30) {
					ch -= 30;
				}
			}
			System.out.println("ch:" + ch);
		}
	}

	public void chDown() {
		if (power) {
			if (--ch <= 0) {
				while (ch <= 0) {
					ch += 30;
				}
			}
			System.out.println("ch:" + ch);
		}
	}

	public void volUp() {
		if (power) {
			if (vol <= 9) {
				vol++;
			} else {
				vol = 10;
			}
			System.out.println(vol);
		}
	}
	
	public void volDown() {
		if (power) {
			if (vol > 0) {
				vol--;
			} else {
				vol = 0;
			}

			if (vol == 0) {
				System.out.println("���Ұ�");
			} else {
				System.out.println("vol:" + vol);
			}
		}
	}

	// getter/setter
	// brand�� �Һ����̹Ƿ� setter�� ����
	public String getBrand() {
		return BRAND;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
}
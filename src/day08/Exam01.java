package day08;

public class Exam01 {
	public static void main(String[] args) {
		/* TV 클래스 생성
		 * 멤버변수 : brand, power, ch(1~30), vol(0~10)(음소거)
		 * 
		 * 메서드
		 * power()
		 * chUp() / chDown()
		 * - 1씩 증감
		 * - 1~30을 벗어나면 순환
		 * 
		 * volUp() / volDown()
		 * - 1씩 증감 
		 * - 0~10을 벗어나면 멈춤
		 * - 0이면 음소거라 출력
		 * */

		TV tv = new TV("삼성");

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
	// 상수 : 변하지 않는 값 => final
	// 일반적인 변수들과 구분하기 위해 변수명을 대문자만으로 작성
	// final 변수는 setter를 가지지 않음
	private final String BRAND;
	private boolean power;
	private int ch, vol;

	// 생성자
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


	// 메서드
	public void power() {
		if (power) {
			System.out.println("전원이 꺼집니다.");
		} else {
			System.out.println("전원이 켜집니다.");
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
				System.out.println("음소거");
			} else {
				System.out.println("vol:" + vol);
			}
		}
	}

	// getter/setter
	// brand는 불변값이므로 setter가 없음
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
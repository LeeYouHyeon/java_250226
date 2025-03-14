package onecard;

public class Card {
	// 카드 1장
	/* 1. 멤버변수
	 * 	- int number = 1
	 * 		- 카드의 번호를 숫자로 저장
	 * 		- A = 1, J = 11, Q = 12, K = 13
	 * 		- 범위 : 1 ~ 13
	 * 	- char shape = '♥'
	 * 		- 카드의 모양
	 * 		- 범위 : ♥, ◆, ♠, ♣
	 * 
	 * 2. 생성자
	 * 1) Card() : 기본생성자
	 * 2) Card(int, char) : 특정한 카드를 생성하고 싶을 때
	 * 	- 멤버변수 항목에서 설명한 범위를 벗어나는 입력은 기본값으로 설정
	 * 
	 * 3. 메서드
	 * 1) print() : 카드의 정보를 콘솔에 출력
	 * 	- toString() 참조
	 * 
	 * 4. getter/setter
	 * 	- getter는 일반적인 getter
	 * 	- setter는 범위를 벗어나는 입력은 무시
	 * 	- 스캐너의 next()와의 호환을 위해 setShape(String) 지원
	 * */

	// 멤버변수
	private int number = 1;
	private char shape = '♥';

	// 생성자
	public Card() {
	}
	public Card(int number, char shape) {
		this();
		setNumber(number);
		setShape(shape);
	}

	// 메서드
	@Override
	public String toString() {
		String num = "";

		switch (number) {
			case 1:
				num = "A";
				break;
			case 11:
				num = "J";
				break;
			case 12:
				num = "Q";
				break;
			case 13:
				num = "K";
				break;
			default:
				num = String.valueOf(number);
		}
		return shape + num;
	}
	
	public void print() {
		System.out.print(this);
	}
		public void println() {
		System.out.println(this);
	}

	// getter/setter
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		if (number >= 1 && number <= 13)
			this.number = number;
	}
	public char getShape() {
		return shape;
	}
	public void setShape(char shape) {
		if (shape == '◆' || shape == '♣' || shape == '♠')
			this.shape = shape;
	}
	public void setShape(String shape) {
		if(shape.length() == 1) {
			setShape(shape.charAt(0));
		}
	}
}

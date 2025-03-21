package day08;

public class Class01 {

	/* 클래스의 구성요소 : 멤버변수, 메서드(, 생성자)
	 * 멤버변수 먼저, 메서드가 뒤에 선언
	 * 
	 * 클래스 - 객체를 생성하기 위한 설계도
	 * 객체 - 제품
	 * 메서드 - 기능
	 * 멤버변수 - 속성(메서드의 기능에 필요한), 정보
	 * 
	 * 예) 프린트 클래스
	 * - 속성(멤버변수) : 크기, 색, 제조사, 제품명, 종류 
	 * - 기능(메서드) : 인쇄, 복사, 스캔, 팩스
	 * 
	 * 클래스는 다른 클래스와 겹쳐지지 않게 정의
	 * 클래스 선언
	 * class 클래스명
	 * - public class => 파일명과 같은 이름의 클래스에게만 부여
	 * 
	 * 객체 선언 > 객체 생성
	 * 클래스명 객체명 = new 클래스명();
	 * 
	 * 객체 선언
	 * 클래스명 객체명; => null
	 * 객체명 = new 클래스명();
	 * 
	 * 메서드 사용법(static이 안 붙은 일반 메서드)
	 * - 다른 클래스에서 호출할 경우 => 객체 선언 후 객체명.메서드명(); 
	 * - 같은 클래스 안에서 메서드를 호출할 경우 => 메서드명();
	 * 
	 * 접근제어자(제한자)
	 * public		: 모두 사용가능
	 * protected	: 나 + 패키지 + 자식 클래스
	 * (default)	: 나 + 패키지 
	 * private		: 나
	 * 
	 * private < default < protected < public
	 * 
	 * - 하나의 파일 안에 하나의 클래스만 있을 수 있는 건 아니다.
	 * - 그러나 일반적으로 하나의 파일엔 하나의 클래스를 사용
	 * - 클래스에서 public을 붙일 수 있는 건 파일명과 클래스명이 같을 경우에만
	 * - 멤버변수나 메서드에서는 public 가능
	 * - 멤버변수는 private, 메서드는 public이 일반적
	 * - 멤버변수는 private면 다른 클래스에서 접근 불가능
	 * - private으로 선언된 멤버변수는 getter/setter 메서드를 만들어서 해당 변수로 접근 가능하도록 만들어줌
	 * */

	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);
		p.setY(5);
		System.out.println(p.getX());
		System.out.println(p.getY());
		p.print();

		Point p2 = new Point();
		p2.setX(5);
		p2.setY(3);
		p2.print();
		
		p2.setX(p2.getX() + p2.getY());
		p2.print();
		
	}
}

// (x, y)
class Point {
	// 멤버변수 위치
	// 멤버변수는 초깃값을 설정하지 않아도 자동으로 설정됨(0, null)
	// 별도의 초깃값을 주고 싶을 때만 설정
	private int x, y;

	// 멤버변수 선언 후 메서드
	/* 멤버변수와 매개변수의 이름이 같은 경우
	 * 그냥 부르면 매개변수, 멤버변수는 this.멤버변수
	 * */

	// x, y 출력 메서드
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}

	// getter / setter 메서드 생성
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
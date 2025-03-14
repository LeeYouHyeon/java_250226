package day10;

public class Super01 {
	public static void main(String[] args) {
		/* ��� : �θ��� ���� �ڽĿ��� �����ִ� ��
		 * - �������/�޼��常 ���(������ X)
		 * - Ŭ������ Ȯ�� ����
		 * - ����� �ϴ� ���� : ������ �ؼ� �ߺ��ڵ带 ���̰�, ���������� ���� �ϱ� ����
		 * 
		 * class A(�θ�), class B(�ڽ�)
		 * 
		 * class B extends A {}
		 * 
		 * ��� Ű���� : extends
		 * - ����� ������ �θ��� �������/�޼��带 ����� �� �ִ�.
		 * - ���������ڰ� private�̸� �ڽ��� ���� �Ұ�
		 * - ���������ڰ� protected �̻��̸� ���� ����
		 * - ����� 1���� ����(�θ� 2�� X)
		 * 
		 * */
		
		A a = new A();
		a.setA(1);
		a.setB(2);
		a.setC(3);
		a.num = 10; // protected�� ���� ����
		a.print();
		
		System.out.println("-----------------");
		B b = new B();
		b.setA(10);
		b.setB(20);
		b.setC(30);
		b.setD(40);
		b.setE(50);
		b.setF(60);
		b.num = 100;
		b.print();
	}
}

class A { //�θ� Ŭ����
	private int a, b, c; // ���� ��밡��
	protected int num; // ��Ӱ��� ����
	
	public void print() {
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
		System.out.println("num:"+num);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

class B extends A {
	private int d, e, f;
	
	// override(�������̵�) : �θ��� �޼��带 �������Ͽ� ����ϴ� ��
	// super : �θ��� ���� ������ ���� Ű����
	// this : �� ���� ����� ���� Ű����
	
	
	@Override
	public void print() {
		super.print(); // �θ��� ���� ȣ��
		System.out.println("d=" + d + ", e=" + e + ", f=" + f);
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
}
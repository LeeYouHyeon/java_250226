package onecard;

public class Card {
	// ī�� 1��
	/* 1. �������
	 * 	- int number = 1
	 * 		- ī���� ��ȣ�� ���ڷ� ����
	 * 		- A = 1, J = 11, Q = 12, K = 13
	 * 		- ���� : 1 ~ 13
	 * 	- char shape = '��'
	 * 		- ī���� ���
	 * 		- ���� : ��, ��, ��, ��
	 * 
	 * 2. ������
	 * 1) Card() : �⺻������
	 * 2) Card(int, char) : Ư���� ī�带 �����ϰ� ���� ��
	 * 	- ������� �׸񿡼� ������ ������ ����� �Է��� �⺻������ ����
	 * 
	 * 3. �޼���
	 * 1) print() : ī���� ������ �ֿܼ� ���
	 * 	- toString() ����
	 * 
	 * 4. getter/setter
	 * 	- getter�� �Ϲ����� getter
	 * 	- setter�� ������ ����� �Է��� ����
	 * 	- ��ĳ���� next()���� ȣȯ�� ���� setShape(String) ����
	 * */

	// �������
	private int number = 1;
	private char shape = '��';

	// ������
	public Card() {
	}
	public Card(int number, char shape) {
		this();
		setNumber(number);
		setShape(shape);
	}

	// �޼���
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
		if (shape == '��' || shape == '��' || shape == '��')
			this.shape = shape;
	}
	public void setShape(String shape) {
		if(shape.length() == 1) {
			setShape(shape.charAt(0));
		}
	}
}

package day02;

public class MathClass {

	public static void main(String[] args) {
		// ���� ���� ����� �ִ� Ŭ����
		// Math.(�޼���)
		// Math.round() : �ݿø� / Math.ceil() : �ø� / Math.floor() : ����
		// �Ҽ� �ڸ����� ������ 0
		
		double num = 3.14258;
		//long roundNum = Math.round(num);
		int roundNum = (int)Math.round(num);
		System.out.println(roundNum);
		
		//double ceilNum = Math.ceil(num);
		int ceilNum = (int)Math.ceil(num);
		System.out.println(ceilNum);
		
		//double floorNum = Math.floor(num);
		int floorNum = (int)Math.floor(num);
		System.out.println(floorNum);
		
		//Math.max() : �ִ� / Math.min() : �ּڰ�
		System.out.println(Math.max(3, 5));
		System.out.println(Math.min(6, 1));
		
		//Math.random() : [0, 1)�� ������ ����
		//(int)(Math.random()*count) + start
		//(int)Math.random()*count == 0 : ����ȯ�� �������� �����̹Ƿ� �ݵ�� ��ȣ�� �־���� ��
		System.out.println((int)(Math.random()*10)); //0~9
		System.out.println((int)(Math.random()*10) + 1); //1~10
		System.out.println((int)(Math.random()*6) + 1); //1~6
	}

}

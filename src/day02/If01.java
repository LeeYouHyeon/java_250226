package day02;

public class If01 {
	
	public static void main(String[] args) {
		/* ���ǹ� : if��, switch��
		 * if�� : ���ǽ��� �ְ�, ���ǽ��� ���̸� / �����̸� ���� �ִ� ����
		 * if(���ǽ�){ ���๮; }
		 * if������ ���๮�� �� ���̸� �߰�ȣ�� ������ �� �ִ�. (����õ)
		 * ���๮�� �� �� �̻��̸� �ݵ�� �߰�ȣ�� ��� �Ѵ�.
		 * */
		
		// 1. num�� 0���� ũ�� ���, 0���� ������ ����, 0�̸� 0�̶�� ���
		// 2. num�� ¦������ Ȧ������ ���
		int num;
		String sig, even;
		
		num = -2; // ������ ���� �Է�
		
		if(num > 0) {
			sig = "���";
		} else if(num < 0) {
			sig = "����";
		} else {
			sig = "0";
		}
		
		//------------------- : ������� �ϼ��� ����
		
		if(num % 2 == 0) {
			even = "¦��";
		} else {
			even = "Ȧ��";
		}
		
		System.out.println(num);
		System.out.println(sig);
		System.out.println(even);
	}
	
}

package day05;

public class Array05 {
	public static void main(String[] args) {
		/* ���� �迭 ����
		 * */
		String arr[] = new String[5];
		arr[0] = "ȫ�浿";
		arr[1] = "�迵��";
		arr[2] = "�ڿ�ö";
		arr[3] = "�ּ�ö";
		arr[4] = "�̼���";
		
		// ���� for������ ���
		for(String name : arr) {
			System.out.print(name + ' ');
		}
	}
}

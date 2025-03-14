package day03;

public class While02 {

	public static void main(String[] args) {
		/* 1~50 �� ¦�� ���
		 * 2 4 6 8 10
		 * 12 14 16 18 20
		 * ...
		 * */
//		int i = 2;
//		while(i <= 50) {
//			if(i%10 == 0) {
//				System.out.println(i);
//			} else {
//				System.out.print(i + " ");
//			}
//			i += 2;
//		}

		int i = 2, count = 1;
		while (i <= 50) {
			if (count == 5) {
				System.out.printf("%3d%n", i);
				count = 1;
			} else {
				System.out.printf("%3d", i);
				count++;
			}
			i += 2;
		}

		/* println() : �ٹٲ��� �ִ� ���
		 * print() : �ٹٲ��� ���� ���, ��� ���� ������ error
		 * printf() : �����ڸ� �̿��ϴ� ���, ���� ������ error
		 * 
		 * ������
		 * %d(������), %f(�Ǽ���), %c(�� ����), %s(���ڿ�), %n(�ٹٲ�)
		 * �Ҽ��� ���� ����, ���� �߰� ����
		 * */
		System.out.println("------------------");
		
		System.out.printf("%.2f%n", 1.66666666666);
		
		// 3 + 5 = 8
		int a = 3, b = 5;
		
		System.out.println(a + "+" + b + "=" + (a+b));
		System.out.printf("%d + %d = %d%n", a, b, a+b);
		
		double score = 89.333333;
		double cnt = 5;
		
		System.out.printf("%.1f/%.0f = %.2f%n", score, cnt, score/cnt);
	}

}

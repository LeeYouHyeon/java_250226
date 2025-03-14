package day04;

public class For08 {

	public static void main(String[] args) {
		// 이중 for문
		for (int i = 1; i <= 5; i++) { // i = 1 2 3 4 5
			for (int j = 1; j <= 5; j++) { // j = 1 2 3 4 5
				System.out.print(j + " ");
			}
			System.out.println(); // j 출력 후 줄바꿈
		}

		System.out.println("------------");

		/* 별 찍기 => 5개씩 5줄
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * */

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("------------");

		/* *
		 * **
		 * ***
		 * ****
		 * *****
		 * */
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("------------");
		
		/* *****
		 * ****
		 * ***
		 * **
		 * *
		 * */
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 6 - i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("------------");
		
		/*     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 * */
		for (int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print((j < 6 - i) ? ' ' : '*');
//				if(j < 6 - i) {
//					System.out.print(' ');
//				} else {
//					System.out.print('*');
//				}
			}
			System.out.println();
		}
		System.out.println("------------");
		
		/*     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 * */
		/* 4 1 4
		 * 3 3 3
		 * 2 5 2
		 * 1 7 1
		 * 0 9 0
		 * */
		for (int i = 1; i <= 5; i++) {
			int j = 1;
			for (; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= 2*i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------");
		
		/* 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * 3줄씩 3개의 숫자 (이중 for)
		 * */
		int print = 1;
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				System.out.print(print + " ");
				print++;
			}
			System.out.println();
		}
	}
}

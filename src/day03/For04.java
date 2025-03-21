package day03;

import java.util.Scanner;

public class For04 {

	public static void main(String[] args) {
		/* 약수 : 나누어서 떨어지는 수의 집합
		 * 6의 약수 : 1, 2, 3, 6
		 * */
		
		System.out.println("약수를 구하고 싶은 자연수를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int num = scan.nextInt();
			if(num <= 0) {
				System.out.println("자연수를 입력해주세요.");
			} else {
				for(int i = 1; i <= num; i++) {
					if(num%i == 0) {
						System.out.println(i);
					}
				}
				break;
			}
		}
		
		scan.close();
	}

}

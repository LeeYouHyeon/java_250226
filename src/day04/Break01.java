package day04;

import java.util.Scanner;

public class Break01 {

	public static void main(String[] args) {
		/* break; : 반복문을 빠져나오게 하는 키워드
		 * - 반복문에서 조건문(if)을 동반하여 조건이 맞을 때 벗어나게 하는 역할
		 * for, while
		 * */

		// 1~10 출력
		// for문에 무한루프 생성, break로 빠져나옴
		for(int i = 1; ; i++) {
			System.out.print(i + " ");
			if(i == 10) break;
		}
		
		System.out.println();
		System.out.println("---------------");
		// 한 글자를 입력받아 출력 (반복)
		// y를 입력받으면 종료(break)
		Scanner scan = new Scanner(System.in);
		char input;
		
		while(true) {
			System.out.print("> ");
			input = scan.next().charAt(0);
			if(input == 'y') {
				break;
			}
		}
		
		scan.close();
		
		// 중첩 반복문 경우 break;는 나를 감싸는 가장 안 쪽의 반복문을 벗어남
		// 반복문에 이름을 줄 수 있음.
		int i = 0, j = 0, k = 0;
		a: for(;;) {
			j++;
			for(;;) {
				k++;
				for(;;) {
					i++;
					System.out.println("i:" + i + ", k:" + k + ", j:" + j);
					if(i == 10) {
						break a;
					}
				}
			}
		}
	}

}

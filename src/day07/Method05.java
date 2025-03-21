package day07;

public class Method05 {

	// 두 정수를 입력받아, 최대공약수를 return
	public static int gcd(int num1, int num2) {
		if (num1 <= 0 || num2 <= 0) {
			return 0;
		}

		int answer = num2;
		while (true) {
			if (num1 % answer == 0 && num2 % answer == 0) {
				return answer;
			}
			answer--;
		}
	}

	// 두 정수를 입력받아, 최소공배수를 return
	public static int lcm(int num1, int num2) {
		if (num1 <= 0 || num2 <= 0) {
			return 0;
		}

		int answer = num2;
		while (true) {
			if (answer % num1 == 0) {
				return answer;
			}
			answer += num2;
		}
	}

	public static void main(String[] args) {
		/* 최대공약수와 최소공배수를 return
		 * */
		int num1, num2;
		num1 = (int) (Math.random() * 100) + 1;
		num2 = (int) (Math.random() * 100) + 1;

		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println(gcd(num1, num2));
		System.out.println(lcm(num1, num2));
		
	}

}

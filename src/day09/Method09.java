package day09;

public class Method09 {
	public static void main(String[] args) {
		/* 재귀메서드 : 메서드 안에서 본인을 호출하는 메서드
		 * ! : 팩토리얼
		 * */

		Method09 m9 = new Method09();

		System.out.println(m9.f(6));
	}

	public int f(int n) {
		if (n < 0)
			return 0;

		return (n <= 1) ? 1 : f(n - 1) * n;
	}
}

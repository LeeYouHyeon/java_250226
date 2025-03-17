package day13;

public class Exception06 {
	public static void main(String[] args) {
		int start = -100, count = 100, size = 2;
		try {
			for(int num : new Exception06().randoms(size, start, count)) {
				System.out.print(num + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/* size를 입력받아 size만큼의 길이를 가지는 배열을 생성
	 * 랜덤값을 채워 배열을 리턴
	 * 랜덤값의 범위는 start(시작), count(개수)
	 * - size가 0보다 작으면 예외발생
	 * - count가 0보다 작으면 예외발생
	 * */
	
	public int[] randoms(int size, int start, int count) throws Exception {
		if(size < 0) {
			throw new Exception("size가 음수입니다.");
		} else if(count < 0) {
			throw new Exception("count가 음수입니다.");
		}
		
		int answer[] = new int[size];
		
		for(int i = 0; i < size; i++) {
			answer[i] = start + (int)(Math.random()*count);
		}
		return answer;
	}
}
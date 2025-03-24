package word;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static String types[] = { "명사", "자동사", "타동사", "형용사", "부사", "접속사", "전치사", "감탄사" };

	public static void main(String[] args) {
		/* map을 이용한 단어장 프로그램
		 * 하나의 단어에 뜻이 여러 개
		 * class 활용 / Map<String, ArrayList<String>> map
		 * 
		 * 1. 단어 등록 | 2. 단어 검색 | 3. 뜻 수정 |
		 * 4. 단어 목록 출력 | 5. 단어 삭제 | 6. 단어를 파일로 출력 | 7. 종료
		 * WordController를 생성하여 메서드 구현
		 * 
		 * 단어, 뜻(ArrayList)
		 * 클래스로 사용한다면 equals() 사용
		 * */

		Scanner scan = new Scanner(System.in);
		WordController wc = new WordController(scan);

		int input = 0;
		
		do {
			try {
				// 1. 메뉴 출력
				System.out.println("--menu--");
				System.out.println("1. 단어 등록 / 뜻 추가 | 2. 단어 검색 | 3. 단어 뜻 수정/삭제 |");
				System.out.println("4. 단어장 출력 | 5. 단어 삭제 | 6. 단어장 저장 | 7. 종료");
				System.out.print("> ");
				input = Integer.parseInt(scan.nextLine());
				switch (input) {
				case 1:
					wc.addWord();
					break;
				case 2:
					wc.searchWord();
					break;
				case 3:
					wc.updateWord();
					break;
				case 4:
					wc.printWords();
					break;
				case 5:
					wc.deleteWord();
					break;
				case 6:
					wc.saveWords();
					break;
				case 7:
					if (wc.quit()) {
						System.out.println("종료합니다.");
					} else {
						input = 0;
					}
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (input != 7);

		scan.close();
	}
}

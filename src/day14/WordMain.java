package day14;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/* map을 이용한 단어장 프로그램
		 * 1. 단어 등록 | 2. 단어 검색 | 3. 뜻 수정 |
		 * 4. 단어 목록 출력 | 5. 단어 삭제 | 6. 종료
		 * WordController를 생성하여 메서드 구현
		 * */
		WordController wc = new WordController();
		Scanner scan = new Scanner(System.in);
		boolean cont = true;

		while (cont) {
			try {
				System.out.println("1. 단어 등록 | 2. 단어 검색 | 3. 뜻 수정 | 4. 단어 출력 | 5. 단어 삭제 | 6. 종료");
				System.out.print("> ");
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:
					wc.addWord(scan);
					break;
				case 2:
					wc.search(scan);
					break;
				case 3:
					wc.update(scan);
					break;
				case 4:
					wc.printWords(scan);
					break;
				case 5:
					wc.deleteWord(scan);
					break;
				case 6:
					cont = false;
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력");
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("종료");
		scan.close();
	}

}

class WordController {
	Map<String, String> words;

	public WordController() {
		words = new HashMap<>();

		// 기본값들
		words.put("apple", "사과");
		words.put("calculate", "계산하다");
		words.put("tree", "나무");
	}

	// 1. 단어 등록
	public void addWord(Scanner scan) throws Exception {
		String word, meaning;

		// 1. 단어 입력
		System.out.print("단어> ");
		word = scan.nextLine().trim();
		// 1-1. 중복 처리
		if (words.containsKey(word)) {
			throw new Exception("이미 등록된 단어입니다.");
		}

		// 2. 뜻 입력
		System.out.print("뜻> ");
		meaning = scan.nextLine().trim();
		words.put(word, meaning);
		System.out.println("등록 완료");
	}

	// 2. 단어 검색
	public void search(Scanner scan) {
		// 1. 단어 입력
		System.out.print("단어> ");
		String word = scan.nextLine().trim();

		// 2. 단어가 있으면 뜻 출력
		if (words.containsKey(word)) {
			System.out.println(word + " : " + words.get(word));
		} else {
			System.out.println("등록되지 않은 단어입니다.");
		}
	}

	// 3. 단어 수정
	public void update(Scanner scan) {
		// 1. 단어 입력
		System.out.print("수정할 단어> ");
		String word = scan.nextLine().trim();

		// 1-1. 단어가 없으면 오류 메시지 출력 후 종료
		if (!words.containsKey(word)) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}

		// 2. 수정할 뜻 입력
		System.out.print("뜻> ");
		String meaning = scan.nextLine().trim();

		// 3. 단어 수정
		words.put(word, meaning);
		System.out.println("수정 완료");
	}

	// 4. 단어 출력
	public void printWords(Scanner scan) {
		if (words.isEmpty()) {
			System.out.println("등록된 단어가 없습니다.");
		} else {
			for (String word : words.keySet()) {
				System.out.println(word + " : " + words.get(word));
			}
		}
	}

	// 5. 단어 삭제
	public void deleteWord(Scanner scan) {
		// 1. 단어 입력
		System.out.print("삭제할 단어> ");
		String word = scan.nextLine().trim();

		// 2. 삭제 후 결과 출력
		if (words.remove(word) == null) {
			System.out.println("등록되지 않은 단어입니다.");
		} else {
			System.out.println("삭제 완료");
		}
	}
}
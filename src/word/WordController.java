package word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WordController {
	boolean saved = true;
	private List<Word> words;
	Scanner scan;

	public WordController(Scanner scan) {
		words = new ArrayList<Word>();
		this.scan = scan;

		// 저장된 단어 불러오기
		/* 저장된 단어 형식 예시
		 * smart
		 * 형용사
		 * 1. 눈치 빠른; 재치 있는, 영리한, 현명한; 조숙한(precocious); 건방진, 겉치레만의, 멋만의
		 * 2. 맵시 있는, 스마트한, <옷차림이> 말쑥한, 단정한, 멋있는
		 * 부사
		 * 1. (=SMARTLY)
		 * 자동사
		 * 1. 아리다, 따끔따끔 쓰리다
		 * 2. 괴로워하다, 상심하다; 양심에 찔리다 
		 * */
		try {
			// 1. 파일 읽기
			BufferedReader br = new BufferedReader(new FileReader("Words.txt"));

			// 2. 파일을 한 줄씩 읽으면서 단어를 불러오기
			while (true) {
				// 2-1. 단어 읽기
				// 첫 줄이 null이거나 비어있으면 중지
				String text = br.readLine();
				if (text == null || text.isBlank()) {
					break;
				}
				Word word = new Word(text);

				type: while (true) {
					//2-2. 품사 읽기
					String type = br.readLine();
					String mean;

					//2-3. 품사별 뜻 읽기
					while (true) {
						// 하나의 뜻은 전부 한 줄로 저장됨
						mean = br.readLine();

						// 뜻이 더 없으면 type을 종료
						if (mean == null || mean.isBlank()) {
							break type;
						}

						// 첫 글자가 번호가 아니면 품사이므로 type을 갱신하고 다음 줄로 넘어감
						char start = mean.charAt(0);
						if (start < '0' || start > '9') {
							type = mean;
							continue;
						}

						// 뜻에서 번호는 떼고 품사에 저장
						word.addMeaning(type, mean.substring(mean.indexOf(' ')));
					}
					
				}
				// 3. 뜻을 전부 불러왔으면 단어장에 추가
				inputWord(word);
			}
			br.close();
		} catch (IOException e) {
			// 파일이 없을 경우 아무 것도 하지 않음 
		}
	}

	// 이미 저장된 값을 불러올 때 쓰이는 보조 메서드
	private void inputWord(Word word) {
		words.add(word);
	}

	public void addWord() {
		// 1. 등록할 단어 입력
		System.out.print("단어> ");
		String line = scan.nextLine();
		// 1-1. 이미 등록한 단어는 받지 않음
		if (words.contains(new Word(line))) {
			System.out.println("이미 등록된 단어입니다.");
			return;
		} else if (line.indexOf(' ') > -1) {
			System.out.println("단어엔 공백이 있을 수 없습니다.");
			return;
		} else if (line.isBlank()) {
			System.out.println("단어를 입력하지 않았습니다.");
			return;
		}
		Word word = new Word(line);

		// 2. 뜻 입력
		System.out.println("뜻을 입력합니다. 그만두시려면 엔터를 눌러주세요.");

		String mean = "";
		String type = "";
		type: while (true) {
			System.out.print("품사 입력> ");
			type = scan.nextLine();

			if (type.isBlank()) {
				break;
			}

			boolean typecheck = false;
			for (String temp : Main.types) {
				if (type.equals(temp)) {
					typecheck = true;
					break;
				}
			}
			if (!typecheck) {
				System.out.println("없는 품사입니다. 다시 입력해주세요.");
				continue;
			}

			System.out.println("뜻을 입력해주세요. 품사를 바꾸시려면 t를 입력해주세요.");
			while (true) {
				System.out.print("> ");
				mean = scan.nextLine();
				if (mean.isBlank()) {
					break type;
				} else if (mean.toLowerCase().equals("t")) {
					continue type;
				}

				word.addMeaning(type, mean);
			}
		}

		if (word.isEmpty()) {
			System.out.println("뜻을 입력하지 않아 단어를 등록하지 못했습니다.");
		} else {
			words.add(word);
			System.out.println("등록되었습니다.");
			saved = false;
		}
	}

	private Word findWord(String name) throws Exception {
		for (Word word : words) {
			if (word.equals(new Word(name))) {
				return word;
			}
		}

		throw new Exception("단어를 찾을 수 없습니다.");
	}

	public void searchWord() {
		try {
			System.out.print("검색할 단어> ");
			System.out.println(findWord(scan.nextLine()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateWord() {
		try {
			System.out.print("뜻을 수정할 단어> ");
			Word word = findWord(scan.nextLine());

			System.out.println(word);

			System.out.println("수정할 부분을 정해주세요.");
			System.out.print("품사> ");
			String type = scan.nextLine();
			ArrayList<String> meanings = word.getMeanings().getOrDefault(type, new ArrayList<String>());

			if (meanings.isEmpty()) {
				throw new Exception("해당하는 품사엔 뜻이 없습니다.");
			}

			System.out.print("뜻 번호> ");
			int index = Integer.parseInt(scan.nextLine()) - 1;
			if (index < 0 || index >= meanings.size()) {
				throw new InputMismatchException();
			}

			System.out.println("새로 등록할 뜻을 입력해주세요. 삭제하시려면 엔터를 눌러주세요.");
			System.out.print("> ");
			String mean = scan.nextLine();

			if (mean.isBlank()) {
				meanings.remove(index);
			} else {
				meanings.set(index, mean);
				System.out.println("수정되었습니다.");
				saved = false;
			}

		} catch (InputMismatchException e) {
			System.out.println("해당하는 번호의 뜻이 없습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void printWords() {
		if (words.isEmpty()) {
			System.out.println("아직 단어가 등록되지 않았습니다.");
		} else {
			for (Word word : words) {
				System.out.println(word);
			}
		}
	}

	public void deleteWord() {
		try {
			System.out.print("삭제할 단어> ");
			if (words.remove(findWord(scan.nextLine()))) {
				System.out.println("삭제되었습니다.");
				saved = false;
			} else {
				System.out.println("해당하는 단어가 없습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void saveWords() {
		if (saved) {
			System.out.println("저장 완료");
			return;
		}

		try {
			FileWriter fw = new FileWriter("Words.txt");
			for (Word word : words) {
				fw.write(word.getWord() + "\n");
				for (String type : Main.types) {
					List<String> means = word.getMeanings().get(type);
					if (!means.isEmpty()) {
						fw.write(type + "\n");
						for (int i = 0; i < means.size(); i++) {
							fw.write((i + 1) + ". " + means.get(i) + "\n");
						}
					}
				}
				fw.write("\n");
			}
			fw.close();
			System.out.println("저장 완료");
			saved = true;
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}

	private String askYN() {
		System.out.print("> ");
		return scan.nextLine().toLowerCase();
	}

	public boolean quit() {
		if (saved) {
			return true;
		}

		System.out.println("저장되지 않은 변경사항이 있습니다. 저장하시겠습니까?(Y/N)");
		String input = askYN();
		if (input.equals("y")) {
			saveWords();
			return true;
		} else if (input.equals("n")) {
			System.out.println("저장하지 않은 변경사항은 사라집니다. 종료하시겠습니까?(Y/N)");
			input = askYN();
			if (input.equals("y")) {
				return true;
			} else if (input.equals("n")) {
				return false;
			} else {
				System.out.println("잘못된 입력");
				return false;
			}
		} else {
			System.out.println("잘못된 입력");
			return false;
		}
	}

	public List<Word> getWords() {
		return words;
	}
}

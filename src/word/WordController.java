package word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordController {
	boolean saved = true; // 수정사항들이 전부 저장되었는가
	private List<Word> words;
	Scanner scan;

	// 생성자에서 파일 로드를 겸함
	public WordController(Scanner scan) {
		words = new ArrayList<Word>();
		this.scan = scan;

		// 저장된 단어 불러오기
		// 저장 형식은 Word 클래스의 toString() 메서드 참고
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

				// 2-2. 뜻 등록
				type: while (true) {
					// 2-2-1. 품사 읽기
					String type = br.readLine();
					String mean;

					// 2-2-2. 품사별 뜻 읽기
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
						word.addMeaning(type, mean.substring(mean.indexOf(' ') + 1));
					}

				}
				// 3. 뜻을 전부 불러왔으면 단어장에 추가
				words.add(word);
			}
			br.close();
		} catch (IOException e) {
			// 파일이 없을 경우 아무 것도 하지 않음 
		} catch (Exception e) {
			// 파일에 에러가 있을 경우 이제까지 읽어온 데이터를 무시
			System.out.println("Words.txt에 이상이 있어 불러오지 못했습니다.");
			words.clear();
		}
	}

	// 1. 단어 등록
	public void addWord() throws Exception {
		// 1. 등록할 단어 입력
		System.out.print("단어> ");
		String line = scan.nextLine();
		// 1-1. 오류 처리
		if (line.indexOf(' ') > -1) {
			System.out.println("단어엔 공백이 있을 수 없습니다.");
			return;
		} else if (line.isBlank()) {
			System.out.println("단어를 입력하지 않았습니다.");
			return;
		}
		
		// 1-2. 이미 등록된 단어면 뜻을 추가할 수 있음
		Word word = new Word(line);
		for(Word w : words) {
			if (w.equals(word)) {
				System.out.println("이미 등록된 단어입니다. 뜻을 추가하시겠습니까?");
				if(askYN()) {
					word = w;
				} else {
					return;
				}
				break;
			}
		}

		// 2. 뜻 입력
		System.out.println("뜻을 입력합니다. 그만두시려면 엔터를 눌러주세요.");

		String mean = "";
		String type = "";
		type: while (true) {
			// 2-1. 품사 입력
			for (String t : Main.types) {
				System.out.print(t + " ");
			}
			System.out.println();
			System.out.print("품사 입력> ");
			type = scan.nextLine();

			// 실제로 있는 품사인지 검사
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

			// 2-2. 뜻 입력
			System.out.println("뜻을 입력해주세요. 품사를 바꾸시려면 t를 입력해주세요.");
			while (true) {
				// 입력이 빈칸이 아니면 전부 뜻으로 추가
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

		// 3. 입력된 뜻이 없으면 에러, 있으면 등록
		if (word.isEmpty()) {
			System.out.println("뜻을 입력하지 않아 단어를 등록하지 못했습니다.");
		} else {
			words.add(word);
			System.out.println("등록되었습니다.");
			saved = false;
		}
	}

	// 단어를 찾는 보조 메서드
	private Word findWord(String name) throws Exception {
		for (Word word : words) {
			if (word.equals(new Word(name))) {
				return word;
			}
		}

		throw new Exception("단어를 찾을 수 없습니다.");
	}

	// 2. 단어 검색
	public void searchWord() {
		try {
			System.out.print("검색할 단어> ");
			System.out.println(findWord(scan.nextLine()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 3. 단어 수정
	public void updateWord() {
		try {
			// 3-1. 수정할 단어 입력
			System.out.print("뜻을 수정할 단어> ");
			Word word = findWord(scan.nextLine());

			// 3-2. 단어의 뜻 출력
			System.out.println(word);

			// 3-3. 수정할 뜻을 지정(품사, 번호)
			System.out.println("수정할 부분을 정해주세요.");
			// 3-3-1. 품사 지정
			System.out.print("품사> ");
			String type = scan.nextLine();
			ArrayList<String> meanings = word.getMeanings().getOrDefault(type, new ArrayList<String>());
			// 지정한 품사에 뜻이 없으면 에러
			if (meanings.isEmpty()) {
				throw new InputMismatchException();
			}
			// 3-3-2. 뜻 번호 지정
			System.out.print("뜻 번호> ");
			int index = Integer.parseInt(scan.nextLine()) - 1;
			// 지정한 번호에 뜻이 없으면 에러
			if (index < 0 || index >= meanings.size()) {
				throw new InputMismatchException();
			}

			// 3-4. 뜻 수정(삭제)
			System.out.println("새로 등록할 뜻을 입력해주세요. 입력 없이 엔터만 누르면 해당 뜻이 삭제됩니다.");
			System.out.print("> ");
			String mean = scan.nextLine();

			if (mean.isBlank()) {
				meanings.remove(index);
				System.out.println("삭제되었습니다.");
			} else {
				meanings.set(index, mean);
				System.out.println("수정되었습니다.");
			}
			saved = false;
		} catch (InputMismatchException e) {
			System.out.println("해당하는 번호의 뜻이 없습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 4. 단어 출력
	public void printWords() {
		if (words.isEmpty()) {
			System.out.println("아직 단어가 등록되지 않았습니다.");
		} else {
			for (Word word : words) {
				System.out.println(word);
			}
		}
	}

	// 5. 단어 삭제
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

	// 6. 단어를 파일로 출력
	public void saveWords() {
		if (saved) {
			System.out.println("저장 완료");
			return;
		}

		try {
			FileWriter fw = new FileWriter("Words.txt");

			// 단어를 정렬해서 저장
			for (Word word : words.stream().sorted(new Comparator<Word>() {

				@Override
				public int compare(Word o1, Word o2) {
					return o1.getWord().compareTo(o2.getWord());
				}
			}).collect(Collectors.toList())) {
				fw.write(word.toString());
				fw.write("\n");
			}
			fw.close();

			System.out.println("저장 완료");
			saved = true;
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}

	// Y/N을 입력받는 보조 메서드
	private boolean askYN() throws Exception {
		System.out.print("> ");
		String input = scan.nextLine().toLowerCase();

		if (input.equals("y")) {
			return true;
		} else if (input.equals("n")) {
			return false;
		} else {
			throw new Exception("잘못된 입력");
		}
	}

	// 7. 종료
	// 저장 여부를 판단하기 위해 별도의 메서드로 처리
	public boolean quit() {
		if (saved) {
			return true;
		}

		try {
			System.out.println("저장되지 않은 변경사항이 있습니다. 저장하시겠습니까?(Y/N)");
			if (askYN()) {
				saveWords();
				return true;
			} else {
				System.out.println("저장하지 않은 변경사항은 사라집니다. 종료하시겠습니까?(Y/N)");
				return askYN();
			}
		} catch (Exception e) {
			System.out.println("잘못된 입력");
			return false;
		}
	}

	// getter
	public List<Word> getWords() {
		return words;
	}
}

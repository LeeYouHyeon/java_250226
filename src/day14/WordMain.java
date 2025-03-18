package day14;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/* map�� �̿��� �ܾ��� ���α׷�
		 * 1. �ܾ� ��� | 2. �ܾ� �˻� | 3. �� ���� |
		 * 4. �ܾ� ��� ��� | 5. �ܾ� ���� | 6. ����
		 * WordController�� �����Ͽ� �޼��� ����
		 * */
		WordController wc = new WordController();
		Scanner scan = new Scanner(System.in);
		boolean cont = true;

		while (cont) {
			try {
				System.out.println("1. �ܾ� ��� | 2. �ܾ� �˻� | 3. �� ���� | 4. �ܾ� ��� | 5. �ܾ� ���� | 6. ����");
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
				System.out.println("�߸��� �Է�");
			} catch (NumberFormatException e) {
				System.out.println("�߸��� �Է�");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("����");
		scan.close();
	}

}

class WordController {
	Map<String, String> words;

	public WordController() {
		words = new HashMap<>();

		// �⺻����
		words.put("apple", "���");
		words.put("calculate", "����ϴ�");
		words.put("tree", "����");
	}

	// 1. �ܾ� ���
	public void addWord(Scanner scan) throws Exception {
		String word, meaning;

		// 1. �ܾ� �Է�
		System.out.print("�ܾ�> ");
		word = scan.nextLine().trim();
		// 1-1. �ߺ� ó��
		if (words.containsKey(word)) {
			throw new Exception("�̹� ��ϵ� �ܾ��Դϴ�.");
		}

		// 2. �� �Է�
		System.out.print("��> ");
		meaning = scan.nextLine().trim();
		words.put(word, meaning);
		System.out.println("��� �Ϸ�");
	}

	// 2. �ܾ� �˻�
	public void search(Scanner scan) {
		// 1. �ܾ� �Է�
		System.out.print("�ܾ�> ");
		String word = scan.nextLine().trim();

		// 2. �ܾ ������ �� ���
		if (words.containsKey(word)) {
			System.out.println(word + " : " + words.get(word));
		} else {
			System.out.println("��ϵ��� ���� �ܾ��Դϴ�.");
		}
	}

	// 3. �ܾ� ����
	public void update(Scanner scan) {
		// 1. �ܾ� �Է�
		System.out.print("������ �ܾ�> ");
		String word = scan.nextLine().trim();

		// 1-1. �ܾ ������ ���� �޽��� ��� �� ����
		if (!words.containsKey(word)) {
			System.out.println("��ϵ��� ���� �ܾ��Դϴ�.");
			return;
		}

		// 2. ������ �� �Է�
		System.out.print("��> ");
		String meaning = scan.nextLine().trim();

		// 3. �ܾ� ����
		words.put(word, meaning);
		System.out.println("���� �Ϸ�");
	}

	// 4. �ܾ� ���
	public void printWords(Scanner scan) {
		if (words.isEmpty()) {
			System.out.println("��ϵ� �ܾ �����ϴ�.");
		} else {
			for (String word : words.keySet()) {
				System.out.println(word + " : " + words.get(word));
			}
		}
	}

	// 5. �ܾ� ����
	public void deleteWord(Scanner scan) {
		// 1. �ܾ� �Է�
		System.out.print("������ �ܾ�> ");
		String word = scan.nextLine().trim();

		// 2. ���� �� ��� ���
		if (words.remove(word) == null) {
			System.out.println("��ϵ��� ���� �ܾ��Դϴ�.");
		} else {
			System.out.println("���� �Ϸ�");
		}
	}
}
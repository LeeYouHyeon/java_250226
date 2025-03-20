package studentManager_List_Score;

import java.util.Scanner;

public interface Program {
	/* 1. �л� ���					=> void insertStudent(Scanner scan);
	 * 2. �л� ����Ʈ ���				=> void printStudents();
	 * 3. �л� �˻�(�л� ����, ���� ����)	=> void searchStudent(Scanner scan);
	 * 4. ������û(�� �л��� ����)			=> void insertSubject(Scanner scan);
	 * 5. ����öȸ(�� �л��� ����)			=> void deleteSubject(Scanner scan);
	 * 6. ����
	 * */

	void insertStudent(Scanner scan) throws Exception;

	void printStudents();

	void searchStudent(Scanner scan);

	void insertSubject(Scanner scan);

	void deleteSubject(Scanner scan);
}

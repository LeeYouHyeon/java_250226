package day16_StudentManager_List;

import java.util.Scanner;

public interface TODO {
	// �л� ���
	public void insertStudent(Scanner scan);
	
	// �л� ��� ���
	public void printStudents();
	
	// �л� �˻�(�⺻���� ���)
	public void searchStudent(Scanner scan);
	
	// �л� ���� ����
	public void updateStudent(Scanner scan);
	
	// �л� ����
	public void deleteStudent(Scanner scan);
	
	// ���� ��� ���
	public void printSubjects();
	
	// ������û
	public void insertSubject(Scanner scan);
	
	// ����öȸ
	public void deleteSubject(Scanner scan);
	
	// ���� ��û�� ����Ʈ
	// ������ �Է¹޾� ��û�� �л����� �⺻���� ���
	public void studentsOfSubject(Scanner scan);
	
	// �л��� ����ǥ ���
	// ���� ��յ� ���
	public void printStudentScore(Scanner scan);
}

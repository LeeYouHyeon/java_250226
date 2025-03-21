package day16_StudentManager_List;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Controller sc = new Controller();
		
		// �⺻��
		String subNames[] = {
				"java", "python", "C", "SQL", "JS"
		};
		
		for(int i = 0; i < subNames.length; i++) {
			sc.insertSubject(new Subject(i + 1 + "", subNames[i], 3));
		}
		
		int choice = 0;
		
		while (choice != 11) {
			try {
				System.out.println("--menu--");
				System.out.println("1. �л� ��� | 2. �л� ��� | 3. �л� �˻� | 4. �л� ���� ����");
				System.out.println("5. �л� ���� | 6. ���� ��� | 7. ���� ��û | 8. ���� öȸ");
				System.out.println("9. ���� �л� | 10. �л� ����ǥ | 11. ����");
				System.out.print("> ");
				choice = Integer.parseInt(scan.nextLine());
				
				switch(choice) {
				case 1:
					sc.insertStudent(scan);
					break;
				case 2:
					sc.printStudents();
					break;
				case 3:
					sc.searchStudent(scan);
					break;
				case 4:
					sc.updateStudent(scan);
					break;
				case 5:
					sc.deleteStudent(scan);
					break;
				case 6:
					sc.printSubjects();
					break;
				case 7:
					sc.insertSubject(scan);
					break;
				case 8:
					sc.deleteSubject(scan);
					break;
				case 9:
					sc.studentsOfSubject(scan);
					break;
				case 10:
					sc.printStudentScore(scan);
					break;
				case 11:
					System.out.println("����");
					break;
				default:
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("�Է� ����");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		scan.close();
	}
}
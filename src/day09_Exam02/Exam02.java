package day09_Exam02;

public class Exam02 {
	public static void main(String[] args) {
		/* �л� ������ �����ϱ� ���� Ŭ���� ���� (Student)
		 * - �л� �⺻���� : �̸�, �������, ��ȭ��ȣ, ����
		 * - �п� ���� : �п���=KOREAIT, ����
		 * - ���� ���� : ��������, �Ⱓ
		 * 		- ���� ���� ����
		 * 		- �ִ� 5���� => 5ĭ¥�� array�� ó��
		 * 
		 * 	ex) 
		 * �л��� �⺻ ����
		 * 		ȫ�浿 010101 010-.... (25)
		 * ��������
		 * 		KOREAIT(����)
		 * 		���������� ���� (25-02-26 ~ 25-08-01)
		 * 		java (25-01-05 ~ 25-01-30)
		 * 		DB (25-02-01 ~ 25-02-28)
		 * 
		 * 	�޼���
		 * 	- �л��� �⺻������ ����ϴ� �޼���
		 * 	- �л��� ���������� ����ϴ� �޼���
		 * 	- �л��� ���������� �߰��ϴ� �޼���
		 * */
		Student st = new Student("hong", "010-1234-4567", "����");

		st.setAge(23);
		st.setBirth("030101");
		st.insertCourse("java", "25-01-05 ~ 25-01-30");
		st.insertCourse("���������� ����", "25-02-26 ~ 25-08-01");

		Student st1 = new Student("kim", "010-2222-3333", "����");
		st1.setAge(25);
		st1.setBirth("010101");
		st1.insertCourse("java", "25-01-05 ~ 25-01-30");
		st1.insertCourse("���������� ����", "25-02-26 ~ 25-08-01");

		Student[] studentArr = new Student[8];
		studentArr[0] = st;
		studentArr[1] = st1;

		// �߰� 6��
		for (int i = 2; i < 8; i++) {
			Student s = new Student(String.valueOf(i),
					"010-" + ((int) (Math.random() * 9000) + 1000) + "-" + ((int) (Math.random() * 9000) + 1000), "����");
			s.setAge((int) (Math.random() * 8) + 20);
			s.setBirth("0" + (int) (Math.random() * 10));

			if (Math.random() >= 0.5) {
				s.insertCourse("java", "25-01-05 ~ 25-01-30");
			}
			if (Math.random() >= 0.8) {
				s.insertCourse("���������� ����", "25-02-26 ~ 25-08-01");
			}
			if (Math.random() >= 0.5) {
				s.insertCourse("DB", "25-02-01 ~ 25-02-28");
			}
			studentArr[i] = s;
		}

//		for(Student stu : studentArr) {
//			stu.printInfo();
//			stu.printCompany();
//			stu.printCourse();
//			System.out.println();
//		}

//		System.out.println("---------------------------");
		// �̸� �˻�
		String searchName = "7";
		int searchCount = 0;
		for (Student stu : studentArr) {
			if (stu.getName().equals(searchName)) {
				searchCount++;
				stu.printInfo();
				stu.printCompany();
				stu.printCourse();
				System.out.println();
			}
		}
		if (searchCount == 0) {
			System.out.println("�л��� ã�� �� �����ϴ�.");
		}

		System.out.println("-");
		System.out.println();
		String searchCourse = "DB"; // => �л� ����, ȸ�� ����
		System.out.println("--" + searchCourse + "�� �����л� ���--");
		searchCount = 0;
		for (Student stu : studentArr) {
			for (String course : stu.getCourse()) {
				if (course == null) {
					break;
				}

				if (course.equals(searchCourse)) {
					searchCount++;
					stu.printInfo();
					stu.printCompany();
					break;
				}
			}
		}
		if (searchCount == 0) {
			System.out.println("�л��� ã�� �� �����ϴ�.");
		} else {
			System.out.println("�� " + searchCount + "��");
		}

		System.out.println("-");
		System.out.println();
		String searchBranch = "����";
		System.out.println("--" + searchBranch + "�� �����л� ���--");
		searchCount = 0;
		for (Student stu : studentArr) {
			if(stu.getBranch() == null) {
				continue;
			}
			if (stu.getBranch().equals(searchBranch)) {
				searchCount++;
				stu.printInfo();
			}
		}
		if (searchCount == 0) {
			System.out.println("�л��� ã�� �� �����ϴ�.");
		} else {
			System.out.println("�� " + searchCount + "��");
		}
	}
}

package examStd;

public class StudentMain {
	public static void main(String[] args) {
		StudentController sc = new StudentController();
		sc.addStudent();
		sc.addSubject();

		int menu = 0;
		do {
			// 메뉴넣기
			try {
				menu = sc.menuPrint();
				switch (menu) {
				case 1:
					sc.insertStudnet();
					break;
				case 2:
					sc.printStudent();
					break;
				case 3:
					sc.searchStudent();
					break;
				case 4:
					sc.modifyStudent();
					break;
				case 5:
					sc.removeStudent();
					break;
				case 6:
					sc.insertSubject();
					break;
				case 7:
					sc.removeSubject();
					break;
				case 8:
					sc.searchSubject();
					break;
				case 9:
					sc.insertScore();
					break;
				case 10:
					sc.printScore();
					break;
				case 11:
					System.out.println("종료");
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (menu != 11);
	}
}

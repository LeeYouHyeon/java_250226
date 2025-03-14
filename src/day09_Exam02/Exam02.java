package day09_Exam02;

public class Exam02 {
	public static void main(String[] args) {
		/* 학생 정보를 관리하기 위한 클래스 생성 (Student)
		 * - 학생 기본정보 : 이름, 생년월일, 전화번호, 나이
		 * - 학원 정보 : 학원명=KOREAIT, 지점
		 * - 수강 정보 : 수강과목, 기간
		 * 		- 여러 과목 가능
		 * 		- 최대 5과목 => 5칸짜리 array로 처리
		 * 
		 * 	ex) 
		 * 학생의 기본 정보
		 * 		홍길동 010101 010-.... (25)
		 * 수강정보
		 * 		KOREAIT(강남)
		 * 		공공데이터 국비 (25-02-26 ~ 25-08-01)
		 * 		java (25-01-05 ~ 25-01-30)
		 * 		DB (25-02-01 ~ 25-02-28)
		 * 
		 * 	메서드
		 * 	- 학생의 기본정보를 출력하는 메서드
		 * 	- 학생의 수강정보를 출력하는 메서드
		 * 	- 학생의 수강정보를 추가하는 메서드
		 * */
		Student st = new Student("hong", "010-1234-4567", "강남");

		st.setAge(23);
		st.setBirth("030101");
		st.insertCourse("java", "25-01-05 ~ 25-01-30");
		st.insertCourse("공공데이터 국비", "25-02-26 ~ 25-08-01");

		Student st1 = new Student("kim", "010-2222-3333", "강남");
		st1.setAge(25);
		st1.setBirth("010101");
		st1.insertCourse("java", "25-01-05 ~ 25-01-30");
		st1.insertCourse("공공데이터 국비", "25-02-26 ~ 25-08-01");

		Student[] studentArr = new Student[8];
		studentArr[0] = st;
		studentArr[1] = st1;

		// 추가 6명
		for (int i = 2; i < 8; i++) {
			Student s = new Student(String.valueOf(i),
					"010-" + ((int) (Math.random() * 9000) + 1000) + "-" + ((int) (Math.random() * 9000) + 1000), "수원");
			s.setAge((int) (Math.random() * 8) + 20);
			s.setBirth("0" + (int) (Math.random() * 10));

			if (Math.random() >= 0.5) {
				s.insertCourse("java", "25-01-05 ~ 25-01-30");
			}
			if (Math.random() >= 0.8) {
				s.insertCourse("공공데이터 국비", "25-02-26 ~ 25-08-01");
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
		// 이름 검색
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
			System.out.println("학생을 찾을 수 없습니다.");
		}

		System.out.println("-");
		System.out.println();
		String searchCourse = "DB"; // => 학생 정보, 회사 정보
		System.out.println("--" + searchCourse + "의 수강학생 목록--");
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
			System.out.println("학생을 찾을 수 없습니다.");
		} else {
			System.out.println("총 " + searchCount + "건");
		}

		System.out.println("-");
		System.out.println();
		String searchBranch = "강남";
		System.out.println("--" + searchBranch + "의 수강학생 목록--");
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
			System.out.println("학생을 찾을 수 없습니다.");
		} else {
			System.out.println("총 " + searchCount + "건");
		}
	}
}

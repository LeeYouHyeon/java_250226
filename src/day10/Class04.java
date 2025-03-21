package day10;

public class Class04 {
	public static void main(String[] args) {
		/* 객체를 생성할 때 값을 초기화하는 방법
		 * - 기본값, 명시적 초깃값, 초기화 블럭, 생성자
		 * 1. 기본값 : 멤버변수 선언 시 기본적으로 주는 값
		 * 		기본 자료형 : 0(false)
		 * 		참조 자료형 : null
		 * 2. 명시적 초깃값 : 기본값을 직접 주는 것
		 * 		brand = "LG"
		 * 3. 초기화 블럭 : {초깃값 지정} => 멤버변수 초기화
		 * 4. 생성자 : 객체를 생성할 때 초기화해서 생성
		 * 
		 * 초깃값의 우선순위
		 * 낮음 								높음
		 * 기본값 -> 명시적 초깃값 -> 초기화 블럭 -> 생성자
		 * */
		System.out.println(new Student("강남", "이유현", "010-1234-5678"));
	}
}

class Student{
	private String branch = "강남"; // 명시적 초깃값
	private String name; // 기본값 null
	private String phone; // 기본값 null
	
	// 초기화 블럭
	{
		branch = "수원";
		name = "미정";
		phone = "000";
	}
	
	public Student() {}

	public Student(String branch, String name, String phone) {
		this.branch = branch;
		this.name = name;
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Student [branch=" + branch + ", name=" + name + ", phone=" + phone + "]";
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
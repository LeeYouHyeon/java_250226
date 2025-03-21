package day06;

/* 학생에 대한 정보를 모은 class Student
 * 1. 멤버변수
 * 	- String name : 학생의 이름
 * 	- int kor, eng, math : 각 과목의 점수
 * 	- int sum, double avg : 점수의 합계와 평균
 * 	- int rank = 1 : 합계를 기준으로 한 등수
 * 
 * 2. 생성자
 * 1) public Student()
 * 	- 기본 생성자
 * 2) public Student(String, int, int, int)
 * 	- 이름과 점수들을 알고 있을 때 사용
 * 	- 등수는 추후 사용자가 직접 계산해야 함
 * 
 * 3. 메서드
 * 0) private void update()
 * 	- sum과 avg를 다시 계산
 * 	- 각 과목의 점수가 바뀌었을 때 합계와 평균을 업데이트하기 위한 용도
 * 1) public void print()
 * 	- 학생의 정보를 출력
 * 	- 순서는 이름, 국어, 영어, 수학, 합계, 평균, 등수이며, 각 항목은 \t로 구분한다.
 * 	- toString() 참조
 * 2) public void rankDown()
 * 	- 학생의 등수를 한 단계 내림(실제 숫자는 증가) 
 * 3) public void rankUp()
 * 	- 학생의 등수를 한 단계 올림(실제 숫자는 감소)
 * 	- 이미 1등이라면 아무 일도 하지 않음
 * 
 * 4. getter/setter
 * 	- getter는 모든 멤버변수에 대해 제공
 * 		- setter를 제공하지 않는 변수의 getter는 메서드명에 get을 지워 간결하게 표현
 * 	- setter는 이름과 각 점수, 등수에만 제공
 * 		- sum과 avg는 세 점수를 통해 자동으로 결정되므로 setter를 지원하지 않음
 * */

public class Student {
	// 1. 멤버변수
	private String name;
	private int kor, eng, math, sum, rank = 1;
	private double avg;

	// 2. 생성자
	public Student() {
	}

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		update();
	}
	
	// 3. 메서드
	private void update() {
		sum = kor + eng + math;
		avg = sum / 3.0;
	}

	@Override
	public String toString() {
		return String.format("%s\t%d\t%d\t%d\t%d\t%.2f\t%d", name, kor, eng, math, sum, avg, rank);
	}

	public void print() {
		System.out.println(this);
	}

	public void rankDown() {
		rank++;
	}

	public void rankUp() {
		if (rank < 2) {
			rank = 1;
		} else {
			rank--;
		}
	}

	// 4. getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		update();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		update();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		update();
	}

	public int sum() {
		return sum;
	}

	public double avg() {
		return avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
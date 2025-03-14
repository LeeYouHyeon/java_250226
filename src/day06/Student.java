package day06;

/* �л��� ���� ������ ���� class Student
 * 1. �������
 * 	- String name : �л��� �̸�
 * 	- int kor, eng, math : �� ������ ����
 * 	- int sum, double avg : ������ �հ�� ���
 * 	- int rank = 1 : �հ踦 �������� �� ���
 * 
 * 2. ������
 * 1) public Student()
 * 	- �⺻ ������
 * 2) public Student(String, int, int, int)
 * 	- �̸��� �������� �˰� ���� �� ���
 * 	- ����� ���� ����ڰ� ���� ����ؾ� ��
 * 
 * 3. �޼���
 * 0) private void update()
 * 	- sum�� avg�� �ٽ� ���
 * 	- �� ������ ������ �ٲ���� �� �հ�� ����� ������Ʈ�ϱ� ���� �뵵
 * 1) public void print()
 * 	- �л��� ������ ���
 * 	- ������ �̸�, ����, ����, ����, �հ�, ���, ����̸�, �� �׸��� \t�� �����Ѵ�.
 * 	- toString() ����
 * 2) public void rankDown()
 * 	- �л��� ����� �� �ܰ� ����(���� ���ڴ� ����) 
 * 3) public void rankUp()
 * 	- �л��� ����� �� �ܰ� �ø�(���� ���ڴ� ����)
 * 	- �̹� 1���̶�� �ƹ� �ϵ� ���� ����
 * 
 * 4. getter/setter
 * 	- getter�� ��� ��������� ���� ����
 * 		- setter�� �������� �ʴ� ������ getter�� �޼���� get�� ���� �����ϰ� ǥ��
 * 	- setter�� �̸��� �� ����, ������� ����
 * 		- sum�� avg�� �� ������ ���� �ڵ����� �����ǹǷ� setter�� �������� ����
 * */

public class Student {
	// 1. �������
	private String name;
	private int kor, eng, math, sum, rank = 1;
	private double avg;

	// 2. ������
	public Student() {
	}

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		update();
	}
	
	// 3. �޼���
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
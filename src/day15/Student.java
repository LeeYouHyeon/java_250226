package day15;

public class Student implements Comparable<Student> {
	// 학생 클래스 
	// name, score만 가지는 클래스
	private String name;
	private int score;
	
	public Student() {}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return "[" + name + " : " + score + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

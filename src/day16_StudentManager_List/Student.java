package day16_StudentManager_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
	private String stdCode, stdName, stdPhone, stdAddress;
	private int age;
	private List<Subject> subjects;

	public Student() {
		subjects = new ArrayList<Subject>();
	}

	public Student(String stdCode, String stdName) {
		this();
		this.stdCode = stdCode;
		this.stdName = stdName;
	}

	public Student(String stdCode, String stdName, String stdPhone, String stdAddress, int age) {
		this(stdCode, stdName);
		this.stdPhone = stdPhone;
		this.stdAddress = stdAddress;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("%s. %s(%d) : %s", stdCode, stdName, age, stdPhone);
	}

	public boolean isLearned(Subject sub) {
		return subjects.contains(sub);
	}

	public void addSubject(Subject sub) {
		subjects.add(sub);
	}

	public boolean deleteSubject(Subject sub) {
		return subjects.remove(sub);
	}

	public void printScores(Map<String, Double> valueOfScore) throws Exception {
		double sum = 0;
		int count = 0;
		for (Subject sub : subjects) {
			String score = sub.studentScore(this);
			System.out.println(String.format("%s. %s : %s", sub.getSubCode(), sub.getSubName(), score));
			double cal = valueOfScore.getOrDefault(score, -1.0);
			if (cal > -1) {
				count++;
				sum += cal;
			}
		}

		if (count > 0) {
			System.out.println("∆Ú¡° : " + sum / count);
		}
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}

	public String getStdAddress() {
		return stdAddress;
	}

	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStdCode() {
		return stdCode;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
}

package day16_StudentManager_List;

import java.util.HashMap;

public class Subject {
	private String subCode, subName, subProfessor, subTimeTable, subPlace;
	private int point, hours;
	private HashMap<Student, String> scores;
	
	public Subject() {}
	public Subject(String subCode, String subName, int point) {
		this.subCode = subCode;
		this.subName = subName;
		this.point = point;
		this.scores = new HashMap<Student, String>();
	}
	public Subject(String subCode, String subName, String subProfessor, String subTimeTable, String subPlace, int point, int hours) {
		this(subCode, subName, point);
		this.subProfessor = subProfessor;
		this.subTimeTable = subTimeTable;
		this.subPlace = subPlace;
		this.hours = hours;
	}

	@Override
	public String toString() {
		return String.format("%s. %s : %d", subCode, subName, point);
	}
	public void addStudent(Student s) {
		scores.put(s, "I");
	}
	public void addStudent(Student s, String score) {
		scores.put(s, score);
	}
	public void deleteStudent(Student std) {
		scores.remove(std);
	}
	public void printStduents() {
		for(Student s : scores.keySet()) {
			System.out.println(s);
		}
	}
	public String studentScore(Student s) {
		return scores.get(s);
	}
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubProfessor() {
		return subProfessor;
	}
	public void setSubProfessor(String subProfessor) {
		this.subProfessor = subProfessor;
	}
	public String getSubTimeTable() {
		return subTimeTable;
	}
	public void setSubTimeTable(String subTimeTable) {
		this.subTimeTable = subTimeTable;
	}
	public String getSubPlace() {
		return subPlace;
	}
	public void setSubPlace(String subPlace) {
		this.subPlace = subPlace;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public HashMap<Student, String> getScores() {
		return scores;
	}
}

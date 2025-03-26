package studentProfessorManager;

import java.util.HashMap;
import java.util.Objects;

public class Subject {
	private String subCode, subName, professor, professorName, table, place;
	private int point;
	private HashMap<String, String> students = new HashMap<>();
	
	public Subject() {}
	public Subject(String subCode, String subName, String professor, String professorName, String table, String place, int point) {
		this.subCode = subCode;
		this.subName = subName;
		this.professor = professor;
		this.professorName = professorName;
		this.table = table;
		this.place = place;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "["+subName+"("+subCode+") / 담당교수 : "+professorName+", 이수학점 : "+point+"]"
				+ "\r\n  >강의 일정 : "+table+"("+place+")";
	}
	@Override
	public int hashCode() {
		return Objects.hash(subCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(subCode, other.subCode);
	}
	
	//-------------------
	// 수강신청
	//-------------------
	public void addStudent(String sid) {
	//학생ID check->수강신청
		students.put(sid, "I");
	}
	
	//------------------------
	// 수강철회
	//------------------------
	public void removeStudent(String sid) {
		students.remove(sid);
	}
	
	//------------------------
	// 수강 여부 확인 (있으면 true, 없으면 false)
	//------------------------
	public boolean hasApplied(String stdCode) {
		boolean tf = students.containsKey(stdCode);
		return tf;
	}

	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getSubCode() {
		return subCode;
	}
	public HashMap<String, String> getStudents() {
		return students;
	}
	public void addStudent(String stdCode, String score) {
		students.put(stdCode, score);
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public void printScores() {
		System.out.println(subCode + "의 평점 목록");
		for(String stdCode : students.keySet()) {
			System.out.println("(학번)" + stdCode + " : " + students.get(stdCode));
		}
	}
}

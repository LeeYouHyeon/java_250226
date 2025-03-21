package examStd;

import java.util.Objects;

public class Subject {
	private String subNum;
	private String subName;
	private int subPoint;
	private int subTime;
	private String subProfessor;
	private String subTimeTable;
	private String subRoom;
	private int subScore;

	public Subject() {
	}
	// 중복체크용
	public Subject(String subNum) {
		this.subNum = subNum;
	}
	public Subject(String subNum, String subName, int subPoint, int subTime, String subProfessor, String subTimeTable,
			String subRoom) {
		this.subNum = subNum;
		this.subName = subName;
		this.subPoint = subPoint;
		this.subTime = subTime;
		this.subProfessor = subProfessor;
		this.subTimeTable = subTimeTable;
		this.subRoom = subRoom;
	}
	public Subject(Subject s) {
		// 객체 copy
		subNum = s.subNum;
		subName = s.subName;
		subPoint = s.subPoint;
		subTime = s.subTime;
		subProfessor = s.subProfessor;
		subTimeTable = s.subTimeTable;
		subRoom = s.subRoom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(subNum);
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
		return Objects.equals(subNum, other.subNum);
	}
	
	@Override
	public String toString() {
		return "Subject [subNum=" + subNum + ", subName=" + subName + ", subPoint=" + subPoint + ", subTime=" + subTime
				+ ", subProfessor=" + subProfessor + ", subTimeTable=" + subTimeTable + ", subRoom=" + subRoom
				+ ", subScore=" + subScore + "]";
	}
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getSubPoint() {
		return subPoint;
	}
	public void setSubPoint(int subPoint) {
		this.subPoint = subPoint;
	}
	public int getSubTime() {
		return subTime;
	}
	public void setSubTime(int subTime) {
		this.subTime = subTime;
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
	public String getSubRoom() {
		return subRoom;
	}
	public void setSubRoom(String subRoom) {
		this.subRoom = subRoom;
	}
	public int getSubScore() {
		return subScore;
	}
	public void setSubScore(int subScore) {
		this.subScore = subScore;
	}
	public String getSubNum() {
		return subNum;
	}
}

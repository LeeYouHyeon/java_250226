package studentManager_List;

public class Subject {
	// 과목코드, 과목명, 학점, 시수, 교수명, 시간표, 강의장...
	private String subCode, subName, subProfessor, subTimeTable, subRoom;
	private int subPoint, subTime;

	// 생성자
	public Subject() {}
	public Subject(String subCode, String subName, String subProfessor, String subTimeTable, String subRoom,
			int subPoint, int subTime) {
		this(subCode, subName);
		this.subProfessor = subProfessor;
		this.subTimeTable = subTimeTable;
		this.subRoom = subRoom;
		this.subPoint = subPoint;
		this.subTime = subTime;
	}
	public Subject(String subCode, String subName) {
		this.subCode = subCode;
		this.subName = subName;
	}

	@Override
	public String toString() {
		return subCode + ". " + subName;
	}
	
	// getter/setter
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
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
}

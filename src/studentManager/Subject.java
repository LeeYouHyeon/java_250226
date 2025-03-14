package studentManager;

public class Subject {
	private String code, name;

	private int credit, hours;
	private String teacher, place;

	public Subject() {
	}
	public Subject(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public Subject(String code, String name, int credit, int hours, String teacher, String place) {
		super();
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.hours = hours;
		this.teacher = teacher;
		this.place = place;
	}

	@Override
	public String toString() {
		return code + ". " + name + "(" + credit + ")";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}

package studentManager;

public class Student {
	private String id, name, phone, place;
	private int age;
	private Subject[] subjects = new Subject[5];
	private int countSub;

	public Student() {}
	public Student(String id, String name, String phone, String place, int age) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.place = place;
		this.age = age;
	}

	@Override
	public String toString() {
		String result = id + ". " + name;
		if(countSub > 0) {
			result += " : " + subjects[0].getCode();
			for(int i = 1; i < countSub; i++) {
				result += ", " + subjects[i].getCode();
			}
		}
		
		return result;
	}

	public void insertSubject(Subject subject) {
		// 1. 같은 과목을 이미 듣고 있는지 확인
		for (Subject sub : subjects) {
			if (sub == null) {
				break;
			}
			if (sub.equals(subject)) {
				System.out.println("이미 신청한 과목입니다.");
				return;
			}
		}

		// 2. subjects가 다 찼으면 array를 늘림
		if (countSub == subjects.length) {
			Subject[] subjects = new Subject[this.subjects.length + 5];
			System.arraycopy(this.subjects, 0, subjects, 0, countSub);
			this.subjects = subjects;
		}

		// 3. subjects의 빈 자리에 subject를 추가
		subjects[countSub] = subject;
		countSub++;
		System.out.println("신청했습니다.");
	}

	public void deleteSubject(Subject subject) {
		boolean found = false;
		if(subject == null) return;
		
		for (int i = 0; i < subjects.length; i++) {
			if (subjects[i] == null) {
				continue;
			}

			if (subjects[i].equals(subject)) {
				found = true;
				for(int k = i; k < countSub - 1; k++) {
					subjects[k] = subjects[k + 1];
				}
				countSub--;
				subjects[countSub] = null;
				System.out.println("수강신청을 취소했습니다.");
			}
		}

		if (!found) {
			System.out.println("신청하지 않은 과목입니다.");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCountSub() {
		return countSub;
	}

	public void setCountSub(int countSub) {
		this.countSub = countSub;
	}

	public Subject[] getSubjects() {
		return subjects;
	}
}

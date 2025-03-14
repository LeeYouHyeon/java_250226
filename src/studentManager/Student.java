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
		// 1. ���� ������ �̹� ��� �ִ��� Ȯ��
		for (Subject sub : subjects) {
			if (sub == null) {
				break;
			}
			if (sub.equals(subject)) {
				System.out.println("�̹� ��û�� �����Դϴ�.");
				return;
			}
		}

		// 2. subjects�� �� á���� array�� �ø�
		if (countSub == subjects.length) {
			Subject[] subjects = new Subject[this.subjects.length + 5];
			System.arraycopy(this.subjects, 0, subjects, 0, countSub);
			this.subjects = subjects;
		}

		// 3. subjects�� �� �ڸ��� subject�� �߰�
		subjects[countSub] = subject;
		countSub++;
		System.out.println("��û�߽��ϴ�.");
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
				System.out.println("������û�� ����߽��ϴ�.");
			}
		}

		if (!found) {
			System.out.println("��û���� ���� �����Դϴ�.");
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

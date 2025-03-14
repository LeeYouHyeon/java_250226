package day10;

public class Class04 {
	public static void main(String[] args) {
		/* ��ü�� ������ �� ���� �ʱ�ȭ�ϴ� ���
		 * - �⺻��, ����� �ʱ갪, �ʱ�ȭ ��, ������
		 * 1. �⺻�� : ������� ���� �� �⺻������ �ִ� ��
		 * 		�⺻ �ڷ��� : 0(false)
		 * 		���� �ڷ��� : null
		 * 2. ����� �ʱ갪 : �⺻���� ���� �ִ� ��
		 * 		brand = "LG"
		 * 3. �ʱ�ȭ �� : {�ʱ갪 ����} => ������� �ʱ�ȭ
		 * 4. ������ : ��ü�� ������ �� �ʱ�ȭ�ؼ� ����
		 * 
		 * �ʱ갪�� �켱����
		 * ���� 								����
		 * �⺻�� -> ����� �ʱ갪 -> �ʱ�ȭ �� -> ������
		 * */
		System.out.println(new Student("����", "������", "010-1234-5678"));
	}
}

class Student{
	private String branch = "����"; // ����� �ʱ갪
	private String name; // �⺻�� null
	private String phone; // �⺻�� null
	
	// �ʱ�ȭ ��
	{
		branch = "����";
		name = "����";
		phone = "000";
	}
	
	public Student() {}

	public Student(String branch, String name, String phone) {
		this.branch = branch;
		this.name = name;
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Student [branch=" + branch + ", name=" + name + ", phone=" + phone + "]";
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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
	
}
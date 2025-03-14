package day09_Exam02;

public class Student {
	/* �л������� �����ϱ� ���� Ŭ���� ���� (Student)
	 * - �л� �⺻���� : �̸�, �������, ��ȭ��ȣ, ����
	 * - �п� ���� : �п���="KOREAIT"(final), ����
	 * - ���� ���� : ��������, �Ⱓ 
	 *    => ���������� ���� �� ����.[5] (�迭�� ó�� 5��������� ����)
	 * */
	//1. ������� ���� / 2. ������ / 3. getter/setter / 4. �޼��� ����
	private String name;
	private String birth;
	private String phone;
	private int age;
	private final String COMPANY = "KOREAIT"; // final�� �빮�� ó��
	private String branch;
	private String[] course = new String[5]; //��������
	private String[] period = new String[5]; //�Ⱓ
	private int cnt; // �迭�� index ó����
	
	// ������
	public Student() {} //�⺻������
	public Student(String name, String phone, String branch) {
		this.name = name;
		this.phone = phone;
		this.branch = branch;
	}
	// ������ �����ε�
	public Student(String name, String birth, String phone, 
			int age, String branch) {
		//������ ȣ�� : �������� ù���ο����� ȣ�� ����
		this(name, phone, branch);
		this.age = age;
		this.birth = birth;
	}
	
	//method
	//- �л��� �⺻������ ����ϴ� �޼���
	public void printInfo() {
		System.out.println("--�л�����--");
		System.out.println("�̸�:"+name+"("+age+"��"+"/"+birth+") "+phone);
	}
	
	//- �л��� �п������� ����ϴ� �޼���
	public void printCompany() {
		System.out.println(COMPANY+"("+branch+")");
		System.out.println("--------------------------");
	}
	
	//- �л��� ���������� ����ϴ� �޼���
	public void printCourse() {
		if(cnt==0) { //����� ������ ����.
			System.out.println("���������� �����ϴ�.");
			return;
		}
		//cnt������ ��� => ��ϵ��� ���� ���� ��� X
		for(int i=0; i<cnt; i++) {
			System.out.println(course[i]+"("+period[i]+")");
		}
	}
	
	//- �л��� ���������� �߰��ϴ� �޼���
	// �Ű����� : ��������, �Ⱓ => �迭�� �߰� / ����Ÿ�� : void
	public void insertCourse(String coures, String period) {
		//cnt = 0 => ���� �߰��� ���� ����. 
		if(cnt>=5) {
//			System.out.println("�� �̻� �����Ͻ� �� �����ϴ�.");
//			return;
			
			// ���̻� ���� ������ ���� => �迭�� ���� �ٽ� ���� (�迭����)
			String courseTmp[] = new String[course.length+5];
			String periodTmp[] = new String[this.period.length+5];
			// arraycopy
			System.arraycopy(course, 0, courseTmp, 0, course.length);
			System.arraycopy(this.period, 0, periodTmp, 0, this.period.length);
			// ���� �迭�� ���������� ��ü�� �ٲ�ġ��
			this.course = courseTmp;
			this.period = periodTmp;
		}
		this.course[cnt] = coures;
		this.period[cnt] = period;
		cnt++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public String[] getPeriod() {
		return period;
	}
	public void setPeriod(String[] period) {
		this.period = period;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getCOMPANY() {
		return COMPANY;
	}
	
}
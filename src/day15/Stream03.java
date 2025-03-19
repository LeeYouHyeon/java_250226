package day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream03 {
	public static void main(String[] args) {
		// List<Student> ����
		
		List<Student> list = new ArrayList<Student>();
		for(String name : new String[]
				{"ȫ�浿", "�����", "�̿���", "�ڼ�ö", "��ö��", "ȫ����", "�ڱ浿", "�ּ���"}) {
			list.add(new Student(name, new memos.Randoms().random(50, 100)));
		}
		
		// ��Ʈ������ ��� => ȫ�浿 : 56
		// toString() �̿�
		list.stream()
			.forEach(s -> System.out.println(s));
		System.out.println("----------------");
		// toString() ����
		// cf) effectively final
		String[] prints = {"", ""};
		list.stream()
			.forEach(s -> {
				prints[0] += s.getName() + "\t";
				prints[1] += s.getScore() + "\t";
			});
		System.out.println(prints[0]);
		System.out.println(prints[1]);
		System.out.println();
		
		// list�� ���� �հ�
		int sum = list.stream()
				.mapToInt(s -> s.getScore())
				.sum();
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + sum/(double)list.size());
		
		// list�� �ο���
		System.out.println("�ο��� : " + list.stream().count());
		
		// �̸� �����ټ� ����
		System.out.println("---------------------");
		String[] sortName = {"", ""};
		list.stream()
			.sorted()	// Comparable<Student>���� ������ ����
			.forEach(s -> {
				sortName[0] += s.getName() + "\t";
				sortName[1] += s.getScore() + "\t";
			});
		System.out.println(sortName[0]);
		System.out.println(sortName[1]);
		
		// ���� �������� ����
		System.out.println("---------------------");
		String[] sortScoreDesc = {"", ""};
		list.stream()
			.sorted(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o2.getScore() - o1.getScore();
				}
			}).forEach(s -> {
				sortScoreDesc[0] += s.getName() + "\t";
				sortScoreDesc[1] += s.getScore() + "\t";
			});
		System.out.println(sortScoreDesc[0]);
		System.out.println(sortScoreDesc[1]);
	}
}

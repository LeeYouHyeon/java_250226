package day16;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamEx01 {
	public static void main(String[] args) {
		/* ����� ��ǰ
		 * ���� ����� 15�� �̻��� 100����, 15�� �̸��� 50�������� ���
		 * 
		 * �� 5���� ��Ű�� ������ �����ٰ� �� ���
		 * 1. ����� ��� => ���
		 * 2. ����� ���
		 * 
		 * ��(Customer) Ŭ���� ���� => ArrayList�� ����
		 * 
		 * ��)
		 * �̸�:ȫ�浿	����:40	���:100
		 * �̸�:�̼���	����:40	���:100
		 * �̸�:�����	����:20	���:100
		 * �̸�:ȫ����	����:15	���:100
		 * �̸�:ȫ����	����:10	���:50
		 * �� ������ : ___
		 * 
		 * 
		 * 3. 20�� �̻��� �� ��� => �̸������� ����
		 * */
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		for (String name : new String[] { "ȫ�浿", "�̼���", "�����", "�ֱ⿵", "������" }) {
			list.add(new Customer(name, (int)(Math.random()*30) + 5));
		}
		
		System.out.println("1. �� ���");
		list.stream()
			.forEach(c -> System.out.println(c));
		
		System.out.println();
		System.out.println("2. 20�� �̻� �� ���");
		list.stream()
			.filter(c -> c.age >= 20)
			.sorted(new Comparator<Customer>() {

				@Override
				public int compare(Customer o1, Customer o2) {
					return o1.name.compareTo(o2.name);
				}
			})
			.forEach(d -> System.out.println(d));
	}
}

class Customer {
	String name;
	int age;
	int price;

	public Customer() {}
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		price = age >= 15 ? 100 : 50;
	}
	
	@Override
	public String toString() {
		return String.format("�̸�:%s\t ����:%d\t���:%d", name, age, price);
	}
}
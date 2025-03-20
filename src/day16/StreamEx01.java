package day16;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamEx01 {
	public static void main(String[] args) {
		/* 여행사 상품
		 * 여행 비용이 15세 이상은 100만원, 15세 미만은 50만원으로 계산
		 * 
		 * 고객 5명이 패키지 여행을 떠난다고 할 경우
		 * 1. 비용을 계산 => 출력
		 * 2. 고객명단 출력
		 * 
		 * 고객(Customer) 클래스 생성 => ArrayList로 관리
		 * 
		 * 예)
		 * 이름:홍길동	나이:40	비용:100
		 * 이름:이순신	나이:40	비용:100
		 * 이름:김순길	나이:20	비용:100
		 * 이름:홍순찬	나이:15	비용:100
		 * 이름:홍수미	나이:10	비용:50
		 * 총 여행경비 : ___
		 * 
		 * 
		 * 3. 20세 이상의 고객 명단 => 이름순으로 정렬
		 * */
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		for (String name : new String[] { "홍길동", "이순신", "김순길", "최기영", "남영길" }) {
			list.add(new Customer(name, (int)(Math.random()*30) + 5));
		}
		
		System.out.println("1. 고객 명단");
		list.stream()
			.forEach(c -> System.out.println(c));
		
		System.out.println();
		System.out.println("2. 20세 이상 고객 명단");
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
		return String.format("이름:%s\t 나이:%d\t비용:%d", name, age, price);
	}
}
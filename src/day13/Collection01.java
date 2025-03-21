package day13;

import java.util.ArrayList;
import java.util.List;

public class Collection01 {
	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		/* 컬렉션 프레임워크 : 표준화된 방식의 자료구조
		 * List, Set, Map => 인터페이스. 반드시 구현 클래스로 객체를 생성
		 * 데이터를 묶어서 관리할 때 사용
		 * 주로 배열 대신 사용
		 * 
		 * List(배열과 동일)
		 * - 값을 하나씩 저장
		 * - 순서를 보장 (index)
		 * - 중복 허용
		 * - 배열 대신에 가장 많이 사용하는 구조
		 * 
		 * Set
		 * - 값을 하나씩 저장
		 * - 순서를 보장하지 않음(index가 없음)
		 * - 중복을 허용하지 않음(같은 자료가 입력되면 버려짐)
		 * 
		 * Map
		 * - 값을 두 개씩 key/value 쌍으로 묶어서 저장
		 * - 순서를 보장하지 않음(index가 없음)
		 * - key 중복 불가능 / value 중복 가능
		 * - key가 중복되면 key에 해당되는 value를 덮어씀
		 * - 물건명/가격	아이디/패스워드	학생명/성적
		 * - 두 값을 하나의 자료로 묶어서 사용해야 할 때 사용
		 * 
		 * 배열은 기본 자료형, 클래스 자료형 가능 (여러 가지 구성이 가능)
		 * 	- int arr[], String arr[], Student arr[]
		 * 
		 * Collection에서는 클래스 자료형만 가능(기본 자료형 X)
		 * 기본 자료형에 대응되는 클래스 자료형(wrapper class)을 사용
		 * 
		 * Wrapper Class : 기본 타입에 대응되는 클래스 타입
		 * 기본 타입		래퍼 클래스
		 * int			Integer
		 * char			Character
		 * 나머지 기본 자료형의 래퍼 클래스는 첫 글자만 대문자로 바꾸면 된다.
		 * 
		 * 기본 타입 => 클래스 타입 : 박싱(Boxing)
		 * 클래스 타입 => 기본 타입 : 언박싱(Unboxing)
		 * 
		 * - 언박싱 이유
		 * 	래퍼 클래스는 산술 연산을 위해 정의된 클래스가 아님.
		 * 	객체의 값만 참조할 수 있기 때문에, 그 안의 저장된 값은 직접 변경이 불가능
		 *	래퍼 클래스를 언박싱한 뒤 값을 변경한 후 다시 박싱해야 함
		 *
		 * List<클래스명> 객체명 = new 구현클래스<클래스명>();
		 * 인터페이스	구현 클래스
		 * List		ArrayList, LinkedList, ...
		 * Set		HashSet, TreeSet, ...
		 * Map		HashMap, TreeMap, ...
		 * */
		
		/* ArrayList : 검색이 빠르다. (배열과 비슷)
		 *  - 미리 길이를 지정하지 않음
		 *  - 추가되면 자동 늘어남
		 *  - 삭제되면 자동 줄어듦
		 *  - 추가, 삭제가 쉬움.(속도는 느림), 검색이 쉽고 빠름.
		 *  
		 * LinkedList
		 * - 추가, 삭제가 빠름. 검색이 느림.
		 * */
		
		// 부모를 기준으로 자식을 생성
		List<Integer> list = new ArrayList<Integer>();
		
		// 자식을 기준으로 자식을 생성
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		// 클래스명을 생략하고 생성
		ArrayList list3 = new ArrayList(); // 최상위 객체인 Object의 list로 생성
		
		// 앞에 클래스를 지정했으면 뒷쪽 클래스는 생략 가능
		ArrayList<Integer> list4 = new ArrayList<>();
	}
}
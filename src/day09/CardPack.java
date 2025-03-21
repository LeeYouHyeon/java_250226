package day09;

import memos.Randoms;

public class CardPack {
	// Card를 묶은 pack
	/* 1. 멤버변수
	 * 	- pack : Card의 array
	 * 	- count : null이 아닌 카드들의 숫자(빼내면 null로 채움)
	 * 
	 * 2. 생성자 
	 *  - 기본 생성자: 52장이 순서대로 들어있도록 생성
	 * 
	 * 3. 메서드
	 * 1) public void print() : 카드들을 순서대로 출력
	 * 2) public void shuffle() : 카드 섞기
	 * 3) 카드 뽑기
	 * 	[1] public Card pickOne()
	 * 		- 카드 한 장 뽑기
	 * 		- 덱이 비어있다면 null을 return
	 * 	[2] public void pick(Card[] user)
	 * 		- user에서 null인 부분을 덱에서 뽑아서 채움
	 * 		- 카드가 부족하면 user의 null이 그대로 남을 수 있음
	 * 	[3] public Card[] pick(int n)
	 * 		- 덱에서 n개의 카드를 뽑아 array 형태로 return
	 * 		- 덱의 카드 수가 부족하면 null을 포함할 수 있음
	 * 4) 카드를 덱에 넣기
	 * 	[1] public boolean addOne(Card card)
	 * 		- card가 덱에 없으면 넣고 true를 return
	 * 		- 이미 있는 카드라면 넣지 않고 false를 return
	 * 	[2] public boolean add(Card[] user)
	 * 		- user에 있는 모든 카드를 덱에 넣고 null로 채움
	 * 		- 이미 있는 카드들은 안 들어가고 user에 남음
	 * 		- 하나라도 안 들어간 카드가 있으면 false를, 전부 들어갔다면 true를 return
	 * 5) public int count() : count의 getter
	 * 	- setter는 지원하지 않음
	 * */

	// 1. 멤버변수
	private Card pack[] = new Card[52];
	private int count; // 생성자에 의해 52로 초기화됨
	private Randoms ran = new Randoms(); // 보조 변수. 팩 하나를 만들고 여러 번 섞기 위해 미리 선언해둠

	// 2. 생성자
	public CardPack() {
		for (char shape : new char[] { '♥', '◆', '♠', '♣' }) {
			for (int j = 1; j <= 13; count++, j++) {
				pack[count] = new Card(j, shape);
			}
		}
	}

	// 3. 메서드
	public void print() {
		if (count == 0) {
			System.out.println("카드가 없습니다.");
		}
		for (int i = 0; i < count; i++) {
			pack[i].print();
			System.out.print(" ");
		}
		System.out.println();
	}

	public void shuffle() {
		int[] idxs = ran.randomsD(count, 0, count - 1);
		Card pack[] = new Card[count];
		for (int i = 0; i < count; i++) {
			pack[i] = this.pack[idxs[i]];
		}
		this.pack = pack;
	}

	public Card pickOne() {
		if (count > 0) {
			count--;
			Card card = pack[count];
			pack[count] = null;
			return card;
		}

		return null;
	}

	public void pick(Card[] user) {
		for (int i = 0; i < user.length; i++) {
			if (user[i] == null) {
				user[i] = pickOne();
			}
		}
	}

	public Card[] pick(int n) {
		Card[] user = new Card[n];
		pick(user);
		return user;
	}

	public boolean addOne(Card card) {
		if (count >= 52) {
			return false;
		}

		for (int i = 0; i < count; i++) {
			if (pack[i].equals(card)) {
				return false;
			}
		}

		Card[] pack = new Card[count + 1];
		for (int i = 0; i < count; i++) {
			pack[i] = this.pack[i];
		}
		pack[count] = card;
		this.pack = pack;
		count++;

		return true;
	}

	public boolean add(Card[] user) {
		boolean answer = true;
		for (int i = 0; i < user.length; i++) {
			boolean inserted = addOne(user[i]);
			if (inserted) {
				user[i] = null;
			} else {
				answer = false;
			}
		}

		return answer;
	}

	public int count() {
		return count;
	}
	
	
	public Card[] getPack() {
		return pack;
	}
}

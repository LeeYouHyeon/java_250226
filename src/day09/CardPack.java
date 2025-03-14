package day09;

import memos.Randoms;

public class CardPack {
	// Card�� ���� pack
	/* 1. �������
	 * 	- pack : Card�� array
	 * 	- count : null�� �ƴ� ī����� ����(������ null�� ä��)
	 * 
	 * 2. ������ 
	 *  - �⺻ ������: 52���� ������� ����ֵ��� ����
	 * 
	 * 3. �޼���
	 * 1) public void print() : ī����� ������� ���
	 * 2) public void shuffle() : ī�� ����
	 * 3) ī�� �̱�
	 * 	[1] public Card pickOne()
	 * 		- ī�� �� �� �̱�
	 * 		- ���� ����ִٸ� null�� return
	 * 	[2] public void pick(Card[] user)
	 * 		- user���� null�� �κ��� ������ �̾Ƽ� ä��
	 * 		- ī�尡 �����ϸ� user�� null�� �״�� ���� �� ����
	 * 	[3] public Card[] pick(int n)
	 * 		- ������ n���� ī�带 �̾� array ���·� return
	 * 		- ���� ī�� ���� �����ϸ� null�� ������ �� ����
	 * 4) ī�带 ���� �ֱ�
	 * 	[1] public boolean addOne(Card card)
	 * 		- card�� ���� ������ �ְ� true�� return
	 * 		- �̹� �ִ� ī���� ���� �ʰ� false�� return
	 * 	[2] public boolean add(Card[] user)
	 * 		- user�� �ִ� ��� ī�带 ���� �ְ� null�� ä��
	 * 		- �̹� �ִ� ī����� �� ���� user�� ����
	 * 		- �ϳ��� �� �� ī�尡 ������ false��, ���� ���ٸ� true�� return
	 * 5) public int count() : count�� getter
	 * 	- setter�� �������� ����
	 * */

	// 1. �������
	private Card pack[] = new Card[52];
	private int count; // �����ڿ� ���� 52�� �ʱ�ȭ��
	private Randoms ran = new Randoms(); // ���� ����. �� �ϳ��� ����� ���� �� ���� ���� �̸� �����ص�

	// 2. ������
	public CardPack() {
		for (char shape : new char[] { '��', '��', '��', '��' }) {
			for (int j = 1; j <= 13; count++, j++) {
				pack[count] = new Card(j, shape);
			}
		}
	}

	// 3. �޼���
	public void print() {
		if (count == 0) {
			System.out.println("ī�尡 �����ϴ�.");
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

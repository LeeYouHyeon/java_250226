package onecard;

import java.util.ArrayList;
import java.util.List;

public class Cards {
	protected List<Card> cards = new ArrayList<>();

	/* ������
	 *  - �ʱ�����ڴ� �� ���� ���� ��
	 *  - ī�带 �� ��� �� ī����� ���� �־ ��
	 *  - �Է� ī����� �ߺ� ����
	 * */
	public Cards() {
	}
	public Cards(Card... cards) {
		add(cards);
	}

	// cards�� ī�带 �ֱ�
	public void add(Card... cards) {
		for (Card card : cards) {
			if (card != null && !contains(card)) {
				this.cards.add(card);
			}
		}
	}
	// cards ����
	public void shuffle() {
		Shuffle.shuffle(cards);
	}
	// cards�� ī�尡 �ִ°�
	public boolean contains(Card card) {
		for (Card c : cards) {
			if (card.equals(c))
				return true;
		}
		return false;
	}
	
	// getter/setter
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
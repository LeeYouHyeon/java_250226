package onecard;

import java.util.ArrayList;
import java.util.List;

public class Cards {
	protected List<Card> cards = new ArrayList<>();

	/* 생성자
	 *  - 초기생성자는 빈 덱을 만들어서 줌
	 *  - 카드를 줄 경우 그 카드들을 덱에 넣어서 줌
	 *  - 입력 카드들은 중복 불허
	 * */
	public Cards() {
	}
	public Cards(Card... cards) {
		add(cards);
	}

	// cards에 카드를 넣기
	public void add(Card... cards) {
		for (Card card : cards) {
			if (card != null && !contains(card)) {
				this.cards.add(card);
			}
		}
	}
	// cards 섞기
	public void shuffle() {
		Shuffle.shuffle(cards);
	}
	// cards에 카드가 있는가
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
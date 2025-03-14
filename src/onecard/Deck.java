package onecard;

import java.util.ArrayList;
import java.util.List;

public class Deck extends Cards {
	/* 멤버변수
	 * cards : Cards에서 상속
	 * opened : 오픈된 카드들 
	 * */
	private List<Card> opened = new ArrayList<>();

	// 생성자
	// cards에 정렬된 52개의 카드를 만들고, option이 true면 섞음
	// option의 기본값은 true
	public Deck(boolean option) {
		for (char shape : new char[] { '♥', '◆', '♣', '♠' }) {
			for (int num = 1; num <= 13; num++) {
				cards.add(new Card(num, shape));
			}
		}
		if (option)
			shuffle();
	}
	public Deck() {
		this(true);
	}

	// 공개된 카드들을 맨 위 하나만 빼고 전부 덱으로 되돌린 후 셔플함
	public void merge() {
		while (opened.size() > 1) {
			add(opened.remove(0));
		}
		shuffle();
	}
	
	// 덱에서 카드를 하나 뽑음
	// cards와 opened 모두 비어있을 경우 Exception
	public Card pick() throws Exception {
		if (cards.isEmpty()) {
			if(opened.isEmpty())
				throw new Exception("카드가 없습니다.");
			else merge();
		}
		
		return cards.remove(0);
	}
	
	// 마지막에 나온 카드의 정보와 덱의 남은 카드 수를 보여줌
	@Override
	public String toString() {
		return opened.get(opened.size() - 1).toString() + " / " + cards.size();
	}
	
	// getter/setter
	public List<Card> getOpened() {
		return opened;
	}
	public void setOpened(List<Card> opened) {
		this.opened = opened;
	}
}

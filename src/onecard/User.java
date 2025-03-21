package onecard;

public class User extends Cards {
	// 카드를 하나 골라서 내는 메서드
	// 매개변수가 없으면 랜덤으로 낸다.
	public Card layCard() throws Exception {
		return layCard((int)(Math.random()*cards.size()));
	}
	public Card layCard(int i) throws Exception {
		return cards.remove(i);
	}
}
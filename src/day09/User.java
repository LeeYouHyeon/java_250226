package day09;

public class User {
	private Card[] deck;
	private int count; // ±âº»°ª 0
	
	public User() {
		this(5);
	}
	public User(int n) {
		deck = new Card[n];
	}
	public User(Card[] cards) {
		deck = cards;
		count = cards.length;
	}
	
	public void print() {
		for(int i = 0; i < count; i++) {
			deck[i].print();
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public Card getCard(int i) {
		return (i < count && i >= 0) ? deck[i] : null; 
	}
	
	public Card removeOne() {
		count--;
		Card answer = deck[count];
		deck[count] = null;
		return answer;
	}
	
	public Card[] exhaust() {
		count = 0;
		return deck;
	}
}

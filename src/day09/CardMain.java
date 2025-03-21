package day09;

public class CardMain {
	public static void main(String[] args) {
		CardPack cp = new CardPack();
		
		System.out.println("---------------");
		System.out.println("카드를 섞습니다.");
		cp.shuffle();
		
		System.out.println("카드를 나눠줍니다.");
		Card p1 = cp.pickOne(),
			p2 = cp.pickOne(),
			p3 = cp.pickOne();
		
		System.out.println();
		System.out.println("Player 1 : " + p1);
		System.out.println("Player 2 : " + p2);
		System.out.println("Player 3 : " + p3);
	}
}

package onecard;

import java.util.ArrayList;
import java.util.List;

public class Shuffle {
	public static List<Card> shuffle(List<Card> cards) {
		if(cards == null) return null;
		
		List<Card> result = new ArrayList<>();
		while(!cards.isEmpty()) {
			result.add(cards.remove((int)(Math.random()*cards.size())));
		}
		return result;
	}
}

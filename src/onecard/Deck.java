package onecard;

import java.util.ArrayList;
import java.util.List;

public class Deck extends Cards {
	/* �������
	 * cards : Cards���� ���
	 * opened : ���µ� ī��� 
	 * */
	private List<Card> opened = new ArrayList<>();

	// ������
	// cards�� ���ĵ� 52���� ī�带 �����, option�� true�� ����
	// option�� �⺻���� true
	public Deck(boolean option) {
		for (char shape : new char[] { '��', '��', '��', '��' }) {
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

	// ������ ī����� �� �� �ϳ��� ���� ���� ������ �ǵ��� �� ������
	public void merge() {
		while (opened.size() > 1) {
			add(opened.remove(0));
		}
		shuffle();
	}
	
	// ������ ī�带 �ϳ� ����
	// cards�� opened ��� ������� ��� Exception
	public Card pick() throws Exception {
		if (cards.isEmpty()) {
			if(opened.isEmpty())
				throw new Exception("ī�尡 �����ϴ�.");
			else merge();
		}
		
		return cards.remove(0);
	}
	
	// �������� ���� ī���� ������ ���� ���� ī�� ���� ������
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

package onecard;

public class User extends Cards {
	// ī�带 �ϳ� ��� ���� �޼���
	// �Ű������� ������ �������� ����.
	public Card layCard() throws Exception {
		return layCard((int)(Math.random()*cards.size()));
	}
	public Card layCard(int i) throws Exception {
		return cards.remove(i);
	}
}
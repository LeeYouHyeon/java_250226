package day04;

public class StringEx02 {

	public static void main(String[] args) {
		// file ���ϸ�.Ȯ����
		// ���ϸ�� Ȯ���ڷ� �и��Ͽ� ���
		// Ȯ���ڰ� java�� "�ڹ� �����Դϴ�.", �ƴϸ� "��Ÿ �����Դϴ�." ���
		
		String file = "�ڹ�������.java";
		int point = file.lastIndexOf('.');
		String name = file.substring(0, point),
				ext = file.substring(point + 1);
		
		System.out.println("���ϸ� : " + name);
		System.out.println("Ȯ���� : " + ext);
		System.out.println(ext.equals("java") ? "�ڹ� �����Դϴ�." : "��Ÿ �����Դϴ�.");
	}

}

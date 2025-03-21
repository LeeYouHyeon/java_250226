package day17;

import java.io.BufferedReader;
import java.io.FileReader;

public class File03 {
	public static void main(String[] args) throws Exception {
		// ���� �б�
		/* ���� ��Ʈ�� ���. BufferedReader(FileReader)
		 * ���� ������ �б� ����
		 * �� �̻� ���� ������ ���ٸ�(null) �׸�
		 * ���� ��Ʈ���� ���� �а� ���� ����� ���� ������
		 * ��� ��Ʈ���� �Ű������� �����ؾ� ��
		 * */
		BufferedReader br = new BufferedReader(
				new FileReader("writer2.txt"));
		
		while (true) {
			String line = br.readLine(); // �� �������� �о���̱�
			if(line == null) {
				break;
			}
			System.out.println(line);
		}
		
		br.close();
	}
}

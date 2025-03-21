package day17;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File02 {
	public static void main(String[] args) {
		// FileWriter�� ���� ���� ����
		// ���� �̸����� �ٽ� �����ϸ� �����
		// ��� ���� ���ϸ� ������ �� ������ �ִ� ��ġ�� ����
		
		try {
			FileWriter fw = new FileWriter("D:\\web_0226_lyh\\memo\\File02.txt");
			
			for(int i = 1; i <= 10; i++) {
				String data = i + ". text !!\n";
				fw.write(data);
				fw.write("my I/O Test File\r\n");
			}
			
			fw.close();
		} catch (IOException e) {
			System.out.println("fw error");
		} // �����̸�(��� + ���ϸ� + Ȯ����)
		
		// �߰� ��� : ���� ���Ͽ� �����͸� ������ �� ��
		
		try {
			FileWriter fw2 = new FileWriter("D:\\web_0226_lyh\\memo\\File02.txt", true);
			
			for(int i = 11; i <= 20; i++) {
				fw2.write(i + ". test !!\r\n");
				fw2.write("my I/O TEST File\r\n");
			}
			fw2.close();
		} catch (IOException e) {
			System.out.println("fw2 error");
		}
		
		// PrintWriter
		try {
			PrintWriter pw = new PrintWriter("writer2.txt");
			for(int i = 1; i <= 10; i++) {
				pw.write(i + ". PrintWriter Test.\r\n");
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("pw error");
		}
		
		// PrintWriter ���� ���� �߰��ϱ�
		try {
			PrintWriter pw2 = new PrintWriter(new FileWriter("writer2.txt", true));
			for(int i = 11; i <= 20; i++) {
				pw2.write(i + ". append mode.\r\n");
			}
			pw2.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("pw2 error");
		}
		
		// ����Ʈ ��� ��Ʈ��
		try {
			FileOutputStream output = new FileOutputStream("out.txt");
			for(int i = 1; i <= 10; i++) {
				String data = i + ". ����Ʈ ��� ��Ʈ�� �׽�Ʈ\r\n";
				output.write(data.getBytes());
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("output " + e.getMessage());
		} catch (IOException e) {
			System.out.println("output " + e.getMessage());
		}
	}
}

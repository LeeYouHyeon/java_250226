package day17;

public class File01 {
	public static void main(String[] args) {
		// file: java.io.*���� �����ϴ� Ŭ����
		// ��κ� try~catch / throws�� ����� ��
		/* java�� �Է½�Ʈ��, ��½�Ʈ���� ���� �����͸� �������
		 * 
		 * - ��� ���� : inputStream / outputStream (IOStream)
		 *  �ܹ������� �����Ͱ� �귯���� ����
		 * 	�پ��� ��ġ�� ���������� �, �ϰ��� �ְ� ������� �����ϱ� ���� ���
		 * 
		 * - ������ ���� : ����Ʈ / ���� ��Ʈ��
		 * 	����Ʈ : �׸�, ����, ��������
		 * 		�Է�) FileInputStream, BufferedInputStream, ...			
		 * 		���) FileOutputStream, BufferedOutputStream, ...
		 * 	���� : Encoding ó���� ����
		 * 		�Է�) FileReader, BufferedReader, InputStreamReader, ...
		 * 		���) FileWriter, BufferedWriter, PrintWriter, ...
		 * 		
		 * - ��� ��Ʈ�� / ���� ��Ʈ��
		 * 	��� ��Ʈ�� : ���� �а� ���� ����� �ִ� ��Ʈ��
		 * 		FileInputStream, FileOutputStream, FileReader, FileWriter, ...
		 * 	���� ��Ʈ�� : �а� ���� ����� ����, �߰����� ����� �����ֱ� ���� ��Ʈ��
		 * 		Buffered~�� ���� ���� ��Ʈ��
		 * */
		
		// ǥ�� ���(����� = �ܼ�) ��Ʈ��
		System.out.println("print");
		
		// ǥ�� �Է�(Ű����) ��Ʈ��
		// ����Ʈ ���� ��Ʈ��
		try {
			int b = 0;
			while ((b = System.in.read()) != '\n') { // 'enter'�� �ƴ϶��
				System.out.println((char)b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ǥ�� ���� ��� ��Ʈ��
		System.err.println("error"); // ������
	}
}

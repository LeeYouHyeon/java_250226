package day13;

public class Exception01 {
	public static void main(String[] args) {
		// Exception : ���� ó��
		/*
		 * ������ ���� - ���� ���� : ������ ������ �ǵ��� �ٸ��� �����ϴ� �� - ������ ���� : ������ �� �߻��ϴ� ���� - ��Ÿ�� ���� :
		 * ���� �� �߸��� ����� ��ų�, �ܺ����� �������� ������ ���ᰡ �Ǵ� ���
		 * 
		 * ���� ��(runTime) �߻��� �� �ִ� ������ ����(error), ����(exception) �� ������ ���� - ����(error) :
		 * ���α׷� �ڵ忡 ���ؼ� ������ �� ���� �ɰ��� ���� - ����(exception) : �ڵ忡 ���� ������ �� �ִ� ���� �� �ɰ��� ���� -
		 * ���� ó�� : ������ �߻��� ���� ����Ͽ� �̿� ���� ���� �ڵ带 �̸� �ۼ��ϴ� �� - ���� ó���� ���� ������ ���Ḧ ���� �� ����
		 * 
		 * - ���ܰ� �߻��ϸ� ���ܹ߻� �������� �ڵ�� ���� => ���� ���� ��� - ���� ó�� => ���ܰ� �߻��ϴ� �ڵ常 ����, ��������
		 * ����ó���� ������Ű�� ���
		 * 
		 * - try ~ catch - try ~ catch ~ finally - try : ���ܰ� �߻��� ���ɼ��� �ִ� ������ �ۼ� - catch
		 * : try �������� �߻��� ���ܸ� ó�� - finally : try ���� �ܿ� �ݵ�� ����Ǿ�� �ϴ� ������ �ۼ�(���� ����)
		 */

		try {
			// ���� �߻� ���ɼ��� �ִ� �ڵ� �ۼ�
			System.out.println(1 + 1);
			System.out.println(1 - 1);
			System.out.println(1 * 1);
			System.out.println(1 / 0); // exception �߻� ����
			System.out.println(2 - 2);
		} catch (Exception e) {
			// e : Exception Ŭ������ ��ü (������ ��� Ŭ������ ����ִ� ����)
			e.printStackTrace();	// ���� ������ �ֿܼ� ���
			System.out.println("0���� ���������ϴ�.");
			System.out.println(e.getMessage());
		}
		
		// Exception�� �߻��ص� ó���Ǵ� ����
		System.out.println(3 + 3);
		System.out.println(4 - 4);
	}
}

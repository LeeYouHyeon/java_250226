package day13;

public class Exception04 {
	@SuppressWarnings({ "null", "unused" })
	public static void main(String[] args) {
		/* ��Ƽ ĳġ ����, ���� ĳġ ����
		 * try {
		 * ...
		 * } catch(����Ŭ������ ��ü) {
		 * ...
		 * } catch(����Ŭ������ ��ü) {
		 * ...
		 * } catch ...
		 * 
		 * ���ܸ� ��ü������ ����ȭ�ؼ� ��� ���� �� ���
		 * 
		 * Exception�� ��� ������ �ְ� ����
		 * 	: � ���ܰ� �͵� �� ĳġ
		 * 	: ��Ƽ ĳġ �������� ���� �������� ����ؾ� �� 
		 * */
		double res = 0;
		try {
			int arr[] = null;
			arr[0] = 3;
			
			int arr1[] = new int[3];
			arr1[4] = 3;
			
			res = 1/0;
		} catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} catch (NullPointerException e) {
			System.out.println("��ü�� null�Դϴ�.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ������ �Ѿ���ϴ�.");
		} catch (Exception e) { // �ְ�����. ���� ��������...
			e.printStackTrace();
		}
		
		System.out.println("����");
	}
}

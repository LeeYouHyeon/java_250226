package day17;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File02 {
	public static void main(String[] args) {
		// FileWriter를 통해 파일 쓰기
		// 같은 이름으로 다시 실행하면 덮어쓰기
		// 경로 없이 파일명만 적으면 내 파일이 있는 위치에 생김
		
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
		} // 파일이름(경로 + 파일명 + 확장자)
		
		// 추가 모드 : 기존 파일에 데이터를 쓰려고 할 때
		
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
		
		// PrintWriter 파일 내용 추가하기
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
		
		// 바이트 기반 스트림
		try {
			FileOutputStream output = new FileOutputStream("out.txt");
			for(int i = 1; i <= 10; i++) {
				String data = i + ". 바이트 기반 스트림 테스트\r\n";
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

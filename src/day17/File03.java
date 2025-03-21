package day17;

import java.io.BufferedReader;
import java.io.FileReader;

public class File03 {
	public static void main(String[] args) throws Exception {
		// 파일 읽기
		/* 보조 스트림 사용. BufferedReader(FileReader)
		 * 라인 단위로 읽기 가능
		 * 더 이상 읽을 라인이 없다면(null) 그만
		 * 보조 스트림은 직접 읽고 쓰는 기능이 없기 때문에
		 * 기반 스트림을 매개변수로 포함해야 함
		 * */
		BufferedReader br = new BufferedReader(
				new FileReader("writer2.txt"));
		
		while (true) {
			String line = br.readLine(); // 한 라인으로 읽어들이기
			if(line == null) {
				break;
			}
			System.out.println(line);
		}
		
		br.close();
	}
}

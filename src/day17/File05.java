package day17;

import java.io.File;

public class File05 {
	public static void main(String[] args) {
		// File 객체 : 경로 + 파일명 + 확장자
		// D:\web_0226_lyh\memo\test.txt
		// 파일 구분자 \ => 운영체제마다 다름 (윈도우, 맥, linux, unix)
		// 윈도우 \\, 맥 /, linux \
		// File.separator : 파일 구분자 생성
		// 한국 데이터 포털 : www.data.go.kr => csv, xml, json(가장 많이 사용)
		
		File f = new File("D:\\web_0226_lyh\\memo\\test.txt");
		System.out.println(File.separator);
		String name = f.getName();
		System.out.println("name : " + name); // 파일명.확장자
		System.out.println("getPath() : " + f.getPath()); // 경로 + 파일명 + 확장자
		System.out.println("getParent() : " + f.getParent()); // 경로만
		
		String f2 = f.toString();
		System.out.println("toString() : " + f2); // String 변환
		String filename = f2.substring(f2.lastIndexOf(File.separator) + 1);
		System.out.println("" + filename);
		
		String folder[] = f2.split("\\\\"); // 특수문자를 기준으로 나누려면 앞에 \\를 붙여줘야 한다.
		for(String fold : folder) {
			System.out.println(fold);
		}
	}
}

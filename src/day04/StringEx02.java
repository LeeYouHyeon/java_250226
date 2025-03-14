package day04;

public class StringEx02 {

	public static void main(String[] args) {
		// file 파일명.확장자
		// 파일명과 확장자로 분리하여 출력
		// 확장자가 java면 "자바 파일입니다.", 아니면 "기타 파일입니다." 출력
		
		String file = "자바의정석.java";
		int point = file.lastIndexOf('.');
		String name = file.substring(0, point),
				ext = file.substring(point + 1);
		
		System.out.println("파일명 : " + name);
		System.out.println("확장자 : " + ext);
		System.out.println(ext.equals("java") ? "자바 파일입니다." : "기타 파일입니다.");
	}

}

package day18;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Network01 {
	public static void main(String[] args) {
		/* 인터넷 주소의 정보를 확인하는 방법
		 * */
		InetAddress ip = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("HostAddress> " + ip.getHostAddress());
			System.out.println("HostNames> " + ip.getHostName());
			
			URL url = new URL("https://news.sbs.co.kr/news/endPage.do?news_id=N1008032607&plink=STAND&cooper=NAVER");
			System.out.println(url.getContent());
			System.out.println(url.getAuthority());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPath()); // / 경로
			System.out.println(url.getQuery()); // ? 뒤의 정보
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

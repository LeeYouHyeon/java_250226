package memos;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader labyrinth = new BufferedReader(new FileReader("labyrinth.txt"));
		while (true) {
			String line = labyrinth.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}
		
		labyrinth.close();
	}
}

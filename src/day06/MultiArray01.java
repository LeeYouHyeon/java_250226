package day06;

public class MultiArray01 {

	public static void main(String[] args) {
		/* 다차원 배열 - 2차원 배열
		 * 배열명[] - 1차원 배열 {1, 2, 3}
		 * 배열명[행][열] - 2차원 배열 {{1, 2, 3}, {1, 2, 3}}
		 * 배열명[][][] - 3차원 배열 {{{1, 2, 3}, {1, 2, 3}}, {{1, 2, 3}, {1, 2, 3}}}
		 * 
		 * 
		 * {{1, 2, 3}, {1, 2, 3}} 
		 * int arr[][] = new int[2][3];
		 * 1 2 3
		 * 1 2 3
		 * */

		int arr[][] = { 
				{ 1, 2, 3 }, 
				{ 1, 2, 3 } 
		};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

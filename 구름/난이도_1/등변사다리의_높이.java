package 구름.난이도_1;

import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String[] arr = input.split(" ");
		
		double edge = (double) Integer.parseInt(arr[0]);
		double upper = (double) Integer.parseInt(arr[1]);
		double lower = (double) Integer.parseInt(arr[2]);

		double gap = Math.abs(upper -  lower) / 2;

		if(gap == 0){
			System.out.println((int)(Math.pow(edge, 2) * 4));
		}else{
			double height_2 = Math.pow(edge, 2) - Math.pow(gap, 2);
			System.out.println((int)(height_2 * 4));
		} 
	}
}


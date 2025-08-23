package 백준.골드._3;

import java.io.BufferedReader;
import java.io.*;

public class 레이저_통신 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("백준/골드/_3/레이저_통신.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); 
        }
        br.close();
    }
}

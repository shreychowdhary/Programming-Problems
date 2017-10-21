import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		a = a.toLowerCase();
		b = b.toLowerCase();
		int val =a.compareToIgnoreCase(b);
		if(val > 0){
			System.out.println(1);
		}
		else if(val < 0){
			System.out.println(-1);
		}
		else{
			System.out.println(0);
		}
	}
}

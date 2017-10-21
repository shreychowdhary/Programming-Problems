import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		for(int i = 0; i < n; i++){
			String str = in.nextLine();
			if(str.length() <= 10){
				System.out.println(str);
			}
			else {
				System.out.println(str.charAt(0) + ""+(str.length()-2)+""+str.charAt(str.length()-1));
			}
		}
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char diag = '?';
		char ot = '?';
		for(int i = 0; i < n; i++){
			String s = in.nextLine();
			for(int j = 0; j < n; j++){
				char c = s.charAt(j);
				if(i == j || n-i-1 == j){
					if(diag == '?'){
						diag = c;
					}
					else if(diag != c){
						System.out.println("NO");
						return;
					}
				}
				else {
					if(ot == '?'){
						ot = c;
					}
					else if(ot != c){
						System.out.println("NO i");
						return;
					}
			
				}
			}

		}
		System.out.println("YES");
	}
}

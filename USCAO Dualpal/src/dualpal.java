import java.io.*;
import java.util.*;
/*
 ID:shrey.c1
 LANG:JAVA
 TASK:dualpal
 */
public class dualpal {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		ArrayList<String> pals = new ArrayList<String>();
		outloop:for(int i = s+1; i < 10000+s; i++){
			int count = 0;
			convertLoop : for(int j = 2; j <= 10; j++){
				String temp = convertBase(j,i);
				count = checkPal(count,temp,0,temp.length()-1);
				if(count >=2){
					pals.add(Integer.toString(i));					
					break convertLoop;
				}
				if(pals.size() >= n){
					break outloop;
				}
			}			
		}
		for(String pal : pals){
			out.println(pal);
		}
		out.close();		
	}
	
	static String convertBase(int b, int i){
		return Integer.toString(i, b);
	}
	static int checkPal(int count,String s,int left, int right){
		String temp = s;
				
		if(temp.charAt(left) == temp.charAt(right) && right-left <= 1){
			return (count+1);
		}
		else if(temp.charAt(left) != temp.charAt(right)){
			 return count;
		}
		else{
			return checkPal(count,s,left + 1, right - 1);
		}
	}
}

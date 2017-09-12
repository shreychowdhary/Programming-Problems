import java.io.*;
import java.util.*;
/*
 ID:shrey.c1
 LANG:JAVA
 TASK:runround
 */
public class runround {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("runround.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		long num = Long.parseLong(f.readLine());
		num++;
		while(!isRunaround(num+"")){
			num++;
		}
		out.println(num);
		out.close();
	}
	
	static boolean isRunaround(String num){
		HashSet<Integer> set = new HashSet<Integer>();
		int index = 0;
		while(set.size() < num.length()){
			int n = Integer.parseInt(num.charAt(index)+"");
			if(set.contains(n)){
				return false;
			}
			set.add(n);
			index = (n+index)%num.length();
		}
		return index == 0;
	}
}

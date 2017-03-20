import java.io.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:skidesign
 */

public class skidesign {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		int n = Integer.parseInt(f.readLine());
		int[] hills = new int[n];
		
		for(int i = 0; i < n; i++){
			hills[i] = Integer.parseInt(f.readLine());
		}
		Arrays.sort(hills);
		int[] cost = new int[hills[n-1]-17+1];
		for(int j = 0; j <= hills[n-1]-17;j++){
			for(int i = 0; i < n; i++){
				int change = 0;
				if(j > hills[i]){	
					change = j-hills[i];
					cost[j] += (change*change);
				}
				else if (j + 17 < hills[i]){
					change = hills[i] - (j+17);
					cost[j] += (change*change);
				}
			}
		}
		Arrays.sort(cost);
		out.println(cost[0]);
		out.close();
	}
}

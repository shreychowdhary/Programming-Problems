import java.io.*;
import java.util.*;

/*
ID: shrey.c1
LANG: JAVA
TASK: milk2
*/
public class milk2 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int n = Integer.parseInt(f.readLine());
		int times[][] = new int[n][2];
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());			
		}
		Arrays.sort(times,new Comparator<int[]>()
		{
		     public int compare(int[] x, int[] y)
		     {
		               return(Integer.valueOf(x[0]).compareTo(y[0]));
		     }
		});
		
		int cinterval = 0;
		int iinterval = 0;
		int cur[] = new int[2];
		cur = times[0];
		int t = 0;
		for(int i = 0; i < n; i++){
			if(times[i][0] > cur[1]){
				t = times[i][0] - cur[1];
				if(t > iinterval){
					iinterval = t;
				}
				System.out.println(t);
				
				t = cur[1] - cur[0];
				if(t > cinterval){
					cinterval = t;
				}
				cur = times[i];
				
			}
			else{
				if(times[i][1] > cur[1]){
					cur[1] = times[i][1];
				}
			}
		}
		
		t = cur[1] - cur[0];
		if(t>cinterval){
			cinterval = t;
		}
		out.println(cinterval + " " + iinterval);
		out.close();
	}
}

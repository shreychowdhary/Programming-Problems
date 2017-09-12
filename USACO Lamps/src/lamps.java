import java.io.*;
import java.util.*;
/*
 * ID:shrey.c1
 * LANG:JAVA
 * TASK:lamps
 */
public class lamps {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		int n = Integer.parseInt(f.readLine());
		int c = Integer.parseInt(f.readLine());
		int[] fstate = new int[n];
		Arrays.fill(fstate, -1);
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		while(st.hasMoreTokens()){
			int val = Integer.parseInt(st.nextToken());
			if(val != -1){
				fstate[val] = 1;
			}
		}
		st = new StringTokenizer(f.readLine());
		while(st.hasMoreTokens()){
			int val = Integer.parseInt(st.nextToken());
			if(val != -1){
				fstate[val] = 0;
			}
		}
		int[] state = new int[n];
		Arrays.fill(state, 1);
		
	}
	
	static boolean correct(int[] correct, int[] state){
		for(int i = 0; i < correct.length; i++){
			if(correct[i] == -1){
				continue;
			}
			else if(correct[i] != state[i]){
				return false;
			}
		}
		return true;
	}
	

}

import java.io.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:numtri
*/
public class numtri {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		int n = Integer.parseInt(f.readLine());
		int[][] tree = new int[n][n];
		
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int j = 0; j <= i; j++){
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		out.println(solution(tree));
		out.close();
	}
	
	public static int solution(int[][] tree){
		int[][] max = new int[tree.length][tree.length];
		max[0][0] = tree[0][0];
		int ans = max[0][0];
		for(int i = 1; i < tree.length; i++){
			for(int j = 0; j <= i; j++){
				if(j == 0){
					max[i][j] = max[i-1][j] + tree[i][j];
				}
				else if(j == i){
					max[i][j] = max[i-1][j-1] + tree[i][j];
				}
				else{
					max[i][j] = max(max[i-1][j], max[i-1][j-1]) + tree[i][j];
				}
				if(max[i][j] > ans){
					ans = max[i][j];
				}
			}
		}
		return ans;
	}
	
	public static int max(int a, int b){
		if(a > b){
			return a;
		}
		else{
			return b;
		}
	}

}

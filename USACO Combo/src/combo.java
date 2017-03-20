import java.io.*;
import java.util.*;
/*
ID: shrey.c1
LANG: JAVA
TASK: combo
 */
public class combo {
	/*find nearest range for each number and then go through and find all combinations*/
	public static int positiveMod(int value, int mod){
		return ((value % mod) + mod)% mod;
	}
	public static void generateNearest(ArrayList<String> combs, int[] code, int n){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				for(int k = 0; k < 5; k++){
					String comb = Integer.toString(positiveMod(code[0]-2+i,n)) + Integer.toString(positiveMod(code[1]-2+j,n)) + Integer.toString(positiveMod(code[2]-2+k,n));
					if(!combs.contains(comb)){
						combs.add(comb);
					}
				}
			}
		}
		return;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		int n = Integer.parseInt(f.readLine());
		int[] farmnums = new int[3];
		int[] masternums = new int[3];
		ArrayList<String> possibleComb = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 0; i < 3; i++){
			farmnums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(f.readLine());
		for(int i = 0; i < 3; i++){
			masternums[i] = Integer.parseInt(st.nextToken());
		}
		generateNearest(possibleComb,farmnums,n);
		generateNearest(possibleComb,masternums,n);
		out.println(possibleComb.size());
		out.close();
	}
}

import java.io.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:sprime
*/
public class sprime {
	static int[] oddDigits = {1,3,5,7,9};
	static int[] primeDigits = {2,3,5,7};
	static ArrayList<Integer> posComb = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		int n = Integer.parseInt(f.readLine());
		int[] num = new int[n];
		generate(0,n,num);
		for(int val : posComb){
			out.println(val);
		}
		out.close();
	}
	
	public static void generate(int pos, int n, int[] arg){
		int[]num = arg.clone();
		if(pos == n){
			if(!isPrime(num,pos-1)){
				return;
			}
			int total = 0;
			for(int i = 0; i < pos; i++){
		        total += num[i]*Math.pow(10,pos-i-1);   
		    }
			posComb.add(total);
		}
		else if(pos == 0){
			for(int i = 0; i < primeDigits.length; i++){
				num[0] = primeDigits[i];
				generate(pos+1,n,num);
			}
		}
		else if(pos <= n-1){
			for(int i = 0; i < oddDigits.length; i++){
				num[pos] = oddDigits[i];
				if(!isPrime(num,pos)){
					continue;
				}
				generate(pos+1,n,num);
			}
		}	
	}
	
	public static boolean isPrime(int[] num,int pos){
		int total = 0;
		for(int i = 0; i <= pos; i++){
	        total += num[i]*Math.pow(10,pos-i);   
	    }
		if(total%5==0 && total != 5){
			return false;
		}
		for(int i = 3; i <= Math.sqrt(total); i+=2){
			if(total%i==0){
				return false;
			}
		}
		return true;
	}
}

import java.io.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:pprime
*/
public class pprime {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		ArrayList<Integer> pals = new ArrayList<Integer>();
		generatePals(min,max,pals);
		for(int num : pals){
			if(isPrime(num) && num >= min && num <= max){
				out.println(num);
			}
		}
		out.close();
	}
	
	public static void generatePals(int min, int max, ArrayList<Integer> pals){
		one(pals);
		two(pals);
		three(pals);
		four(pals);
		five(pals);
		six(pals);
		seven(pals);
		eight(pals);
	}
	
	public static boolean isPal(int num){
		String temp = Integer.toString(num);
		for(int i = 0; i <= temp.length()/2;i++){
			if(temp.charAt(i) != temp.charAt(temp.length()-1-i)){				
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(int num){
		if(num%5==0 && num != 5){
			return false;
		}
		for(int i = 3; i <= Math.sqrt(num); i+=2){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void one(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			pals.add(d1);
		}
	}
	public static void two(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			pals.add(d1 * 10 + d1);
		}
	}
	public static void three(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			for(int d2 = 0; d2 <= 9; d2++){
				pals.add(d1*100+d2*10+d1);
			}
		}
	}
	public static void four(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			for(int d2 = 0; d2 <= 9; d2++){
				pals.add(d1*1000+d2*100+d2*10+d1);
			}
		}
	}
	public static void five(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			for(int d2 = 0; d2 <= 9; d2++){
				for(int d3 = 0; d3 <= 9; d3 ++){
					pals.add(d1*10000+d2*1000+d3*100+d2*10+d1);
				}
			}
		}
	}
	public static void six(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			for(int d2 = 0; d2 <= 9; d2++){
				for(int d3 = 0; d3 <= 9; d3 ++){
					pals.add(d1*100000+d2*10000+d3*1000+d3*100+d2*10+d1);
				}
			}
		}
	}
	public static void seven(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			for(int d2 = 0; d2 <= 9; d2++){
				for(int d3 = 0; d3 <= 9; d3++){
					for(int d4 = 0; d4 <= 9; d4++){
						pals.add(d1*1000000+d2*100000+d3*10000+d4*1000+d3*100+d2*10+d1);
					}
				}
			}
		}
	}
	public static void eight(ArrayList<Integer> pals){
		for(int d1 = 1; d1 <= 9; d1 += 2){
			for(int d2 = 0; d2 <= 9; d2++){
				for(int d3 = 0; d3 <= 9; d3 ++){
					for(int d4 = 0; d4 <= 9; d4 ++){
						pals.add(d1*10000000+d2*1000000+d3*100000+d4*10000+d4*1000+d3*100+d2*10+d1);
					}
				}
			}
		}
	}
}

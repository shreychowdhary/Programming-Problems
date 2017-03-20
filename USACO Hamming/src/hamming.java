import java.io.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:hamming
*/
public class hamming {

	public static void main(String[] args) throws IOException {
		double sTime = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		List<Integer> codes = new ArrayList<Integer>();
		codes.add(0);
		int max = (int)Math.pow(2, b);
		outloop : for(int i = 1; i < max;i++){
			if(codes.size() >= n){
				break;
			}
			for(int code : codes){
				if(hDistance(binary(code,b),binary(i,b)) < d){					
					continue outloop;
				}
			}
			codes.add(i);
		}
		for(int i = 0; i < codes.size(); i++){
			if(i%10 == 9 || i == codes.size()-1){
				out.println(codes.get(i));
			}
			else{
				out.print(codes.get(i) + " ");
			}
		}
		out.close();
		//System.out.println(System.currentTimeMillis()-sTime);
	}

	public static int hDistance(String num1, String num2){
		int diff = 0;
		for(int i = 0; i < num1.length(); i++){
			if(num1.charAt(i) != num2.charAt(i)){
				diff++;
			}
		}
		return diff;
	}
	
	public static String binary(int num,int length){
		String binNum = Integer.toBinaryString(num);
		return String.format("%0"+length+"d", Integer.parseInt(binNum));		
	}
}

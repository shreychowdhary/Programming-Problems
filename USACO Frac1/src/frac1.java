import java.io.*;
import java.text.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:frac1
*/
public class frac1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		int n = Integer.parseInt(f.readLine());
		Map<Double,Double> map = new TreeMap<Double,Double>();
		map.put(0d, 1d);
		map.put(1d,1d);
		
		for(double i = 1; i <= n; i++){
			for(double j = 0; j < i; j++){
				double dec = Math.round(j/i * 100000.0) / 100000.0;
				if(!map.containsKey(dec)){
					//System.out.println(dec);
					map.put(dec,i);
				}
			}
		}
		
		for(Map.Entry<Double, Double> dec : map.entrySet()){
			out.println(Math.round(dec.getKey() * dec.getValue()) + "/" + Math.round(dec.getValue()));
		}
		out.close();
	}

}

import java.io.*;
import java.util.*;
/*
 ID:shrey.c1
 LANG:JAVA
 TASK:barn1
 */

public class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Map <Integer,String> gaps = new TreeMap<Integer,String>(Collections.reverseOrder());
		List<Integer> bgaps = new ArrayList<Integer>();
		List<Integer> barns = new ArrayList<Integer>();
		int total = 0;
		//find largest gaps and 
		
		int boards;
		String ln;
		while((ln = f.readLine()) != null){			
			int temp = Integer.parseInt(ln);
			barns.add(temp);			
		}	
		
		
		int last = -1;
		Collections.sort(barns);
		for(int i = 0; i < barns.size(); i++){
			int temp = barns.get(i);
			if(last == -1){
				last = temp;
			}
			if(!gaps.containsKey(temp-last)){			
				gaps.put(temp-last, Integer.toString(temp));
			}
			else{
				gaps.put(temp-last, gaps.get(temp-last) + " " + Integer.toString(temp));
			}
			last = temp;
		}
		int count = 0;
		for(Map.Entry<Integer,String> gap : gaps.entrySet()){
			StringTokenizer temp = new StringTokenizer(gap.getValue());
			while(count < m-1 && temp.hasMoreTokens()){
				int token = Integer.parseInt(temp.nextToken());
				if(barns.get(0) != token){
					bgaps.add(token);
					count++;
				}
				
			}
		}
		
		Collections.sort(bgaps);
		
		int l = barns.get(0);
		for(int i = 0; i < barns.size(); i++){
			if(bgaps.contains(barns.get(i))){	
				total += barns.get(i-1) - l + 1;
				l = barns.get(i);
			}
			if(i == barns.size()-1){
				total += barns.get(i) - l + 1;
			}
		}
		out.println(total);
		out.close();		
	}
}

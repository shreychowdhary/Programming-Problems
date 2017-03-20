import java.util.*;
import java.io.*;
/*
 ID:shrey.c1
 LANG:JAVA
 TASK:palsquare
 */
public class palsquare {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int b = Integer.parseInt(f.readLine());
		Map<String,String> palsquare = new LinkedHashMap<String, String>();
		for(int i = 1; i <= 300; i++){
			String tempN = convertBase(b,i);
			String tempN2 = convertBase(b,i*i);
			checkPal(palsquare,tempN,tempN2,0,tempN2.length()-1);			
		}
		for(Map.Entry<String,String> map : palsquare.entrySet()){
			out.println(map.getKey() + " " + map.getValue());
		}
		out.close();
		
	}
	public static String convertBase(int b, int i){
		return Integer.toString(i,b).toUpperCase();
	}
	public static void checkPal(Map<String,String> map,String k, String s,int left, int right){
		String temp = s;
		boolean dist = false;
				
		if(temp.charAt(left) == temp.charAt(right) && right-left <= 1){
			map.put(k, s);
		}
		else if(temp.charAt(left) != temp.charAt(right)){
			 return;
		}
		else{
			checkPal(map,k,s,left + 1, right - 1);
		}
	}
}

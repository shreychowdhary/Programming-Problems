import java.io.*;
import java.util.*;
/*
 ID:shrey.c1
 LANG:JAVA
 TASK:namenum
 */

public class namenum {
	public static void main(String[] args) throws IOException {
		BufferedReader numf = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader namef = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		String num = numf.readLine();
		ArrayList<String> names = new ArrayList<String>();
		String ln;
		String alphabet = "ABCDEFGHIJKLMNOPRSTUVWXY";
		String letters[] = {"","","ABC","DEF","GHI","JKL","MNO","PRS","TUV","WXY"};
		while((ln = namef.readLine())!= null){
			names.add(ln);
		}
		
		HashMap<Integer,String> pNames = new HashMap<Integer,String>();
		ArrayList<String> fNames = new ArrayList<String>();
		for(String name : names){
			String temp = "";
			for(int i = 0; i < name.length(); i++){
				if(name.charAt(i) != 'Z'){
					temp += alphabet.indexOf(name.charAt(i))/3 + 2;
				}	
			}	
			pNames.put(names.indexOf(name),temp);
			
		}
		
		for(Map.Entry<Integer, String> entry : pNames.entrySet()){
			if(num.equals(entry.getValue())){
				fNames.add(names.get(entry.getKey()));
			}
		}
		if(fNames.size() <= 0){
			out.println("NONE");
		}
		else{
			for(String name: fNames){
				out.println(name);
			}
		}		
		out.close();
	}
	
	
}

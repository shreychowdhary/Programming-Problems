/*
ID: shrey.c1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		
		String comet = f.readLine();
		String group = f.readLine();
		int cometTotal = 1;
		int groupTotal = 1;
		for(int i = 0; i < comet.length(); i++){
			cometTotal *= ((int)comet.charAt(i)-64);
			
		}
		for(int i = 0; i < group.length(); i++){
			groupTotal *= ((int)group.charAt(i)-64);
		}
		if(cometTotal%47 == groupTotal%47){
			out.println("GO");
		}
		else{
			out.println("STAY");
		}
		out.close();
				
	}

}

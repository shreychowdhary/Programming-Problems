import java.io.*;
import java.util.*;
/*
ID: shrey.c1
LANG: JAVA
TASK: friday
*/
public class friday {
	public static void main (String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int days[] = new int[7];
		int years = 0;
		int nyears = Integer.parseInt(f.readLine());
		int monthcounter = 1;
		int daycounter = 0;
		for(int i = 1; i < nyears * 12 + 1; i++){
			int tempdays = 0;
			if(monthcounter%12 == 9 || monthcounter%12 == 4 || monthcounter%12 == 6 || monthcounter%12 == 11){
				tempdays = 30;
			}
			else if(monthcounter%12 != 2){
				tempdays = 31;
			}
			else{
				if(((years+300)%400 == 0) || (years%4 == 0 && years%100 != 0)){
					tempdays = 29;
				}
				else{
					tempdays = 28;
				}
			}
			daycounter += 13;
			//add to shift day over
			days[(daycounter +1)%7]++;
			daycounter += (tempdays-13);
			years = monthcounter%12 == 0 ? years + 1: years;
			monthcounter++;			
		}
		for(int i = 0; i < 7; i++){
			if(i != 6){
				out.print(days[i] + " ");
			}
			else{
				out.println(days[i]);
			}
		}
		out.close();
	}
}

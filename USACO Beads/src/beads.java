import java.io.*;
import java.util.*;
/*
ID: shrey.c1
LANG: JAVA
TASK: beads
*/
public class beads {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int n = Integer.parseInt(f.readLine());
		String necklace = f.readLine();
		int leftcount;
		int rightcount;
		int high = 0;
		//use mod for values to high
		for(int i = 0; i < n; i++){
			leftcount = checkLeft(i,necklace,1,n,' ');
			rightcount = checkRight(i+1,necklace,1,n,' ');
			//System.out.println();
			if((leftcount + rightcount) > high){
				high = (rightcount+leftcount) > n ? n :rightcount+leftcount;
			}
		}
		out.println(high);
		out.close();
		
	}
	
	static int checkLeft(int index, String necklace, int leftcount,int n, char color){
		if(color == ' ' && necklace.charAt(floorMod(index,n))!= 'w'){
			color = necklace.charAt(floorMod(index,n));
		}
		if((color == necklace.charAt(floorMod(index-1, n)) || necklace.charAt(floorMod(index-1, n)) == 'w'|| color == ' ')&& leftcount<n){
			leftcount++;
			return checkLeft(index-1,necklace,leftcount,n,color);
		}
		else{			
			return leftcount;
		}
	}
	static int checkRight(int index, String necklace, int rightcount,int n, char color){
		if(color == ' ' && necklace.charAt(floorMod(index,n))!= 'w'){
			color = necklace.charAt(floorMod(index,n));
		}
		if((color == necklace.charAt(floorMod(index+1, n)) || necklace.charAt(floorMod(index+1, n)) == 'w'|| color == ' ')&& rightcount<n){
			rightcount++;
			//System.out.print(necklace.charAt(floorMod(index,n)));
			return checkRight(index+1,necklace, rightcount,n,color);
		}
		else{
			//System.out.print(necklace.charAt(floorMod(index,n))+","+color);
			return rightcount;
		}
	}
	static int floorMod(int i, int n){
		return i<0 ? (i%n +n)%n : i%n;
	}
}

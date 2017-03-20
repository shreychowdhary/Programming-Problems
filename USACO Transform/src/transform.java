import java.io.*;
import java.util.*;
/*
ID: shrey.c1
LANG: JAVA
TASK: transform
 */
public class transform {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int n = Integer.parseInt(f.readLine());
		char[][] oldTile = new char[n][n];
		char[][] newTile = new char[n][n];
		char[][] combineTile = new char[n][n];
		boolean found = false;
		for(int i = 0; i < n; i++){
			String temp = f.readLine();
			for(int j = 0; j < n; j++){
				oldTile[i][j] = temp.charAt(j);
				combineTile[i][n-j-1] = temp.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++){
			String temp = f.readLine();
			for(int j = 0; j < n; j++){
				newTile[i][j] = temp.charAt(j);
			}
		}
			//check if the same
			boolean tempCheck = false;
			boolean combineCheck = false;
			sameloop : for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(newTile[i][j] == oldTile[i][j]&& tempCheck){
						tempCheck = true;
					}	
					else{
						tempCheck = false;						
						break sameloop;
					}
					if(combineTile[i][j] == oldTile[i][j] && combineCheck){
						combineCheck = true;
					}	
					else{
						combineCheck = false;						
						break sameloop;
					}					
				}
			}
			if(tempCheck && !found){
				found = true;
				out.println("6");
			}
			else if(combineCheck && !found){
				found = true;
				out.println("5");
			}
			tempCheck = true;
			combineCheck = true;
			//check for 90 degree rotation
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(oldTile[n-j-1][i] == newTile[i][j]&& tempCheck){
						tempCheck = true;
					}
					else{
						tempCheck = false;
					}
					if(combineTile[n-j-1][i] == newTile[i][j]&& combineCheck){
						combineCheck = true;
					}
					else{
						combineCheck = false;
					}
				}
			}
			if(tempCheck && !found){
				found = true;
				out.println("1");
			}
			else if(combineCheck && !found){
				found = true;
				out.println("5");
			}
			tempCheck = true;
			combineCheck = true;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(oldTile[n-i-1][n-j-1] == newTile[i][j]&& tempCheck){
						tempCheck = true;
					}
					else{
						tempCheck = false;
					}
					if(combineTile[n-i-1][n-j-1] == newTile[i][j]&& combineCheck){
						combineCheck = true;
					}
					else{
						combineCheck = false;
					}
				}
			}
			if(tempCheck && !found){
				found = true;
				out.println("2");
			}	
			else if(combineCheck && !found){
				found = true;
				out.println("5");
			}
			tempCheck = true;
			combineCheck = true;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(oldTile[j][n-i-1] == newTile[i][j]&& tempCheck){
						tempCheck = true;
					}
					else{
						tempCheck = false;
					}
					if(combineTile[j][n-i-1] == newTile[i][j]&& combineCheck){
						combineCheck = true;
					}
					else{
						combineCheck = false;
					}
				}
			}
			if(tempCheck && !found){
				found = true;
				out.println("3");
			}
			else if(combineCheck && !found){
				found = true;
				out.println("5");
			}
			tempCheck = true;
			combineCheck = true;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(oldTile[i][n-j-1] == newTile[i][j] && tempCheck){
						tempCheck = true;
					}
					else{
						tempCheck = false;
					}
					if(combineTile[i][n-j-1] == newTile[i][j]&& combineCheck){
						combineCheck = true;
					}
					else{
						combineCheck = false;
					}
				}
			}
			if(tempCheck && !found){
				found = true;
				out.println("4");
			}
			else if(combineCheck && !found){
				found = true;
				out.println("5");
			}
			if(!found){
				out.println("7");
			}
			out.close();
	}
}

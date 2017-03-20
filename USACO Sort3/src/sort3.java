import java.util.*;
import java.io.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:sort3
*/
public class sort3 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		int n = Integer.parseInt(f.readLine());
		int[] nums = new int[n];
		ArrayList<Integer> ones = new ArrayList<Integer>();
		ArrayList<Integer> twos = new ArrayList<Integer>();
		ArrayList<Integer> threes = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			int temp = Integer.parseInt(f.readLine());
			if(temp == 1){
				ones.add(i);
			}
			else if(temp == 2){
				twos.add(i);
			}
			else{
				threes.add(i);
			}
			nums[i] = temp;
		}
		int i12 = 0,i13 = 0,i21 = 0,i23 = 0,i31 = 0,i32 = 0; 
		for(int i = 0; i < ones.size(); i++){
			if(nums[i] == 2){
				i12++;
			}
			if(nums[i] == 3){
				i13++;
			}
		}
		for(int i = ones.size(); i < ones.size()+twos.size(); i++){
			if(nums[i] == 1){
				i21++;
			}
			if(nums[i] == 3){
				i23++;
			}
		}
		for(int i = ones.size()+twos.size(); i < nums.length; i++){
			if(nums[i] == 1){
				i31++;
			}
			if(nums[i] == 2){
				i32++;
			}
		}
		out.println(Math.min(i12, i21) + Math.min(i13, i31)+ Math.min(i32, i23) + 2*(Math.max(i12,i21)- Math.min(i12,i21))); 
		out.close();
		/*count how many are out of place for each section
		 * if there is a beneficial swap give it priority otherwise just swap*/
	}
	
}

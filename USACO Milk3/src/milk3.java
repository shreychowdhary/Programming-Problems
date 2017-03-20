import java.util.*;
import java.io.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:milk3
 */
public class milk3 {
	static ArrayList<String> poscomb = new ArrayList<String>();
	static ArrayList<Integer> fincomb = new ArrayList<Integer>();
	static int[] bucketSize;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		bucketSize = new int[3];
		int[] buckets = new int[3];
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		for(int i = 0; i < 3; i++){
			bucketSize[i] = Integer.parseInt(st.nextToken());
		}
		buckets[2] = bucketSize[2];
		generate(buckets);
		Integer[] sol = fincomb.toArray(new Integer[fincomb.size()]);
		Arrays.sort(sol);
		for(int i = 0; i < sol.length; i++){
			if(i != sol.length-1){
				out.print(sol[i] + " ");
			}
			else{
				out.println(sol[i]);
			}
		}
		out.close();
		
		/*all possible amounts of milk in bucket c when a is empty
		it can only be between c-b and c limit
		bfs if go to previous node terminate node		
		*/
			
		/* generate method
		 * you start with initial value
		 * then have branches for each potential pour
		 * terminate branch if pour has been done before
		 * arraylist for combination we have seen before and then another one for ones that work*/
		
	}
	
	public static void generate(int[] arg){
		int[] buckets = arg.clone();
		if(poscomb.contains(Arrays.toString(buckets))){
			//System.out.println(Arrays.toString(buckets));
			return;
		}
		else{
			//System.out.println(Arrays.toString(buckets));
			poscomb.add(Arrays.toString(buckets));
			//if a is empty then add the pos to fin comb
			if(buckets[0] == 0){
				fincomb.add(buckets[2]);
			}
			//need to pour to open spaces
			
			if(buckets[0] > 0 && (!poscomb.contains(Arrays.toString(pour(0,1,buckets))) || !poscomb.contains(Arrays.toString(pour(0,2,buckets))))){
				//System.out.println("a");
				//pour to b
				
				generate(pour(0,1,buckets));
				
				//pour to c
				generate(pour(0,2,buckets));
				
			}
			if(buckets[1] > 0 && (!poscomb.contains(Arrays.toString(pour(1,0,buckets))) || !poscomb.contains(Arrays.toString(pour(1,2,buckets))))){
				//System.out.println("b");
				//pour to a 
				generate(pour(1,0,buckets));
				
				//pour to c
				generate(pour(1,2,buckets));
				
			}
			if(buckets[2] > 0 && (!poscomb.contains(Arrays.toString(pour(2,0,buckets))) || !poscomb.contains(Arrays.toString(pour(2,1,buckets))))){
				//System.out.println("c");
				//pour to a 
				generate(pour(2,0,buckets));
				//pour to b
				generate(pour(2,1,buckets));
				
			}
			
		}
	}
	
	public static int[] pour(int origin, int end, int[] buckets){
		int[] tempBuckets = buckets.clone();
		if(tempBuckets[origin] + tempBuckets[end] > bucketSize[end]){
			tempBuckets[origin] -= bucketSize[end] - tempBuckets[end];
			tempBuckets[end] = bucketSize[end];
		}
		else{
			tempBuckets[end] += tempBuckets[origin];
			tempBuckets[origin] = 0;
		}
		return tempBuckets;
	}
}

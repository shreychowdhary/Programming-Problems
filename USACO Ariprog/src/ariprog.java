import java.io.*;
import java.util.*;
/*
 ID:shrey.c1
 LANG:JAVA
 TASK:ariprog
 */
public class ariprog {

	public static void main(String[] args) throws IOException{
		long startTime = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		int n = Integer.parseInt(f.readLine());
		int bound = Integer.parseInt(f.readLine());
		int[] seq = new int[n];
		ArrayList<String> seqs = new ArrayList<String>();
		boolean[] set = new boolean[bound*bound*2+1];
		for(int p = 0; p <= bound; p++){
			for(int q = 0; q <= bound; q++){
				set[p*p+q*q] = true;
			}
		}
		
		for(int i = 0; i < set.length-n; i++){
			if(set[i]){
				seq[0] = i;
				for(int j = i+1;(j-seq[0])*(n-1) + seq[0] <= 2*bound*bound ; j++){
					if(set[j]){
						seq[1] = j;
					}
					else{
						continue;
					}
					if(set[seq[1] + (seq[1] - seq[0])]){
						int delta = seq[1] - seq[0];
						int count;
						for(count = 2; count < n; count++){
							if(set[seq[count-1]+delta]){
								seq[count] = seq[count-1] + delta;
							}
							else{
								break;
							}
						}
						if(count == n){
							seqs.add(seq[0] + " " + delta);
						}
					}
				}
			}
		}
		
		if(seqs.isEmpty()){
			out.println("NONE");
		}
		else{			
			Collections.sort(seqs,new Comparator<String>(){

				@Override
				public int compare(String arg0, String arg1) {
					
					StringTokenizer st0 = new StringTokenizer(arg0);
					int start0 = Integer.parseInt(st0.nextToken());
					int delta0 = Integer.parseInt(st0.nextToken());
					StringTokenizer st1 = new StringTokenizer(arg1);
					int start1 = Integer.parseInt(st1.nextToken());
					int delta1 = Integer.parseInt(st1.nextToken());
					if(delta0 < delta1){
						return -1;
					}
					else if(delta0 == delta1){
						if(start0 < start1)
							return -1;
						else
							return 1;
					}
					else{
						return 1;
					}
				}
				
			});
			for(int i = 0; i < seqs.size(); i++){
				out.println(seqs.get(i));
			}
			
		}
		out.close();
		System.out.println((System.currentTimeMillis()-startTime)/1000.0);
	}
}

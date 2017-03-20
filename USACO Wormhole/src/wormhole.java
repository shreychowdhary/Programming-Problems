import java.io.*;
import java.util.*;
import java.awt.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:wormhole
 */
public class wormhole {
	/*find all the combinations of pairs then see if you can get into a circle*/
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		int n = Integer.parseInt(f.readLine());
		Point[] holes = new Point[n];
		int[] partner = new int[n];
		int[] rightOf = new int[n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(f.readLine());
			Point temp = new Point();
			temp.x = Integer.parseInt(st.nextToken());
			temp.y = Integer.parseInt(st.nextToken());
			holes[i] = temp;
		}		
		for(int i = 0; i < n; i++){
			partner[i] = -1;
			rightOf[i] = right(i,n,holes);
		}
		out.println(generate(n,holes,partner,rightOf));
		out.close();
	}
	
	public static int generate(int n, Point[] holes,int[] partner,int[] rightOf){
		int i,count=0;
		for(i = 0; i < n; i++){
			if(partner[i] == -1) break;			
		}
		//check if cycle
		if(i == n){
			return cycle(n, holes, partner,rightOf);
		}
		//generate recursively
		for(int j = i+1; j < n; j++){
			if(partner[j] == -1){
				partner[j] = i;
				partner[i] = j;
				count += generate(n,holes,partner,rightOf);
				partner[i] = -1;
				partner[j] = -1;
			}
		}
		return count;
	}
	
	public static int cycle(int n, Point[] holes, int[] partner,int[] rightOf){
		
		for(int i = 0; i < n; i++){
			int pos = i;
			for(int j =0; j < n; j++){
				pos = rightOf[partner[pos]];
				if(pos == -1){
					break;
				}
			}
			if(pos != -1){
				return 1;
			}
		}
		return 0;		
	}
	public static int right(int pos, int n, Point[] holes){
		int right = -1;
		for(int i = 0; i < n; i++){			
			if(holes[pos].y == holes[i].y && holes[pos].x < holes[i].x && (right == -1 ||holes[i].x - holes[pos].x < holes[right].x - holes[pos].x )){
				right = i;
			}
		}
		return right;
	}
}


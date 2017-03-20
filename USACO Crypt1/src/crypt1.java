import java.io.*;
import java.util.*;
/*
ID: shrey.c1
LANG: JAVA
TASK: crypt1
*/
public class crypt1 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		int digit = Integer.parseInt(f.readLine());
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int count = 0;
		ArrayList<Integer> aNums = new ArrayList<Integer>();
		ArrayList<Integer> bNums = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 0; i < digit; i++){
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < digit; i++){
			for(int j = 0; j < digit; j++){
				for(int k = 0; k < digit; k++){
					aNums.add(Integer.parseInt(Integer.toString(nums.get(i)) + Integer.toString(nums.get(j)) + Integer.toString(nums.get(k))));
				}
			}
		}
		
		for(int i = 0; i < digit; i++){
			for(int j = 0; j < digit; j++){
				bNums.add(Integer.parseInt(Integer.toString(nums.get(i)) + Integer.toString(nums.get(j))));
			}
		}
		//make sure partial product is 3 digits long
		for(int i = 0; i < aNums.size(); i++){
			for(int j = 0; j < bNums.size(); j++){
				boolean part1bool = false;
				boolean part2bool = false;
				String product = Integer.toString(aNums.get(i) * bNums.get(j));
				String part1 = Integer.toString(Character.getNumericValue(Integer.toString(bNums.get(j)).charAt(0)) * aNums.get(i));
				if(part1.length() != 3){
					part1bool = false;
				}
				else{
					loopone:for(int k = 0; k < 3; k++){
						if(!nums.contains(Character.getNumericValue(part1.charAt(k)))){
							break loopone;
						}
						else if( k == 2){
							part1bool = true;
						}
					}
				}
				String part2 = Integer.toString(Character.getNumericValue(Integer.toString(bNums.get(j)).charAt(1)) * aNums.get(i));
				if(part2.length() != 3){
					part2bool = false;
				}
				else{
					looptwo:for(int k = 0; k < 3; k++){
						if(!nums.contains(Character.getNumericValue(part2.charAt(k)))){
							break looptwo;
						}
						else if(k == 2){
							part2bool = true;
						}
					}
				} 
				if(product.length() == 4 && part1bool && part2bool){
					looptwo:for(int k = 0; k <4; k++){
						if(!nums.contains(Character.getNumericValue((product.charAt(k))))){
							break looptwo;
						}	
						else if(k == product.length()-1){
							count++;
						}					
					}
				}
			}
		}
		
		out.println(count);
		out.close();
	}
}

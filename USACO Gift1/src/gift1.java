import java.io.*;
import java.util.*;
/*
ID: shrey.c1
LANG: JAVA
TASK: gift1
*/
class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int np = Integer.parseInt(f.readLine());
		List<String> names = new ArrayList<String>();
		int moneyArray[] = new int[np];
		for(int i = 0; i < np; i++){
			names.add(f.readLine());
			//System.out.println(nameArray[i]);
		}
		//figure out which value
		//
		for(int i = 0; i < np; i++){
			int index = names.indexOf(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			int tempMoney = Integer.parseInt(st.nextToken());
			
			int tempFriends = Integer.parseInt(st.nextToken());
			int tempGive;
			if(tempFriends > 0){
				tempGive = ((tempMoney - tempMoney%tempFriends)/tempFriends);
				moneyArray[index] += (-tempMoney + (tempMoney%tempFriends));
			}
			else{
				tempGive = 0;
				moneyArray[index] += -tempMoney;
			}
			for(int j = 0; j < tempFriends; j++){
				String tempname = f.readLine();
				moneyArray[names.indexOf(tempname)] += tempGive;
			}
		}
		
		for(int i = 0; i < np; i++){
			out.println(names.get(i) + " " + moneyArray[i]);
		}
		out.close();
	}
	
}

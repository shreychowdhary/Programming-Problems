import java.io.*;
import java.util.*;

public class ListDifferences {

	public static void main(String[] args) throws IOException {
		BufferedReader inOne = new BufferedReader(new FileReader("one.in"));
		BufferedReader inTwo = new BufferedReader(new FileReader("two.in"));
		
		HashSet<String> one = new HashSet<String>();
		HashSet<String> two = new HashSet<String>();
		String str;
		while((str=inOne.readLine())!=null && str.length()!=0){
			one.add(str);
		}
		while((str=inTwo.readLine())!=null && str.length()!=0){
			two.add(str);
		}
		System.out.println(two.size());
		int count = 0;
		for(Iterator<String> it = one.iterator(); it.hasNext();){
			str = it.next();
			if(!two.contains(str)){
				System.out.println(str);
				count++;
			}
		}
		System.out.println(count);
	}

}

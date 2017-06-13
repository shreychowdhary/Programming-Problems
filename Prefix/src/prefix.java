import java.io.*;
import java.util.*;

public class prefix {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		List<String> operators = new ArrayList<String>(Arrays.asList("+","-","*","/"));
		
		for(int i = 0; i < n; i++){
			String exp = in.readLine();
			st = new StringTokenizer(exp);
			if(exp.length() == 1){
				out.println(exp);
				out.println(exp);
				out.println();
				continue;
			}
			Stack<String> operatorStack = new Stack<String>();
			Stack<Integer> parStack = new Stack<Integer>();
			
			StringBuilder sb = new StringBuilder();
			while(st.hasMoreTokens()){
				String cur = st.nextToken();
				if(isOperator(cur,operators)){
					parStack.add(operatorStack.size());
					operatorStack.add(cur);
					sb.append("(");
				}
				else{
					sb.append(cur);
					if(sb.length() > 3 && isOperator(""+sb.charAt(sb.length()-3),operators)){
						while(parStack.size() > 0 && parStack.peek() == operatorStack.size()){
							sb.append(")");
							parStack.pop();
						}
					}
					if(operatorStack.size() > 0){
						sb.append(" " + operatorStack.pop() + " ");
					}
				}
			}
			out.println(exp);
			out.println(sb.toString());
			out.println();
		}
		out.close();
	}
	
	public static boolean isOperator(String val, List<String> arr){
		return arr.contains(val);
	}

}

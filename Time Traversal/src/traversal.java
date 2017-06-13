import java.io.*;
import java.util.*;
// Pclassic Problem from 2016f

public class traversal {
	static class Node{
		int id;
		public Node left;
		public Node right;
		public Node(int _id){
			id = _id;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("traversal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traversal.out")));
		long startTime = System.currentTimeMillis();
		int n = Integer.parseInt(f.readLine());
		//skip first line
		HashMap<Integer,Node> tree = new HashMap<Integer,Node>();
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			int root = Integer.parseInt(st.nextToken());
			tree.put(root,new Node(root));
			int left = Integer.parseInt(st.nextToken());
			tree.put(left,new Node(left));
			int right = Integer.parseInt(st.nextToken());
			tree.put(right,new Node(right));
			tree.get(root).left = tree.get(left);
			tree.get(root).right = tree.get(right);
		}
		
		dfs(0,tree,new ArrayList<Integer>(),paths);
		int maxDistance = 0;
		for (List<Integer> pathOne : paths) {
			for(List<Integer> pathTwo : paths){
				for(int i = 0; i < Math.min(pathOne.size(),pathTwo.size()); i++){
					if(pathOne.get(i) != pathTwo.get(i)){
						int distance = pathOne.size() + pathTwo.size() - 2*i;
						if(distance > maxDistance){
							maxDistance = distance;
						}
					}
				}
			}
		}
		out.print(maxDistance);
		out.close();
		System.out.println(System.currentTimeMillis() - startTime);
	}
	
	public static void dfs(int curIndex,HashMap<Integer,Node> tree, List<Integer> curPath, List<List<Integer>> paths){
		Node curNode = tree.get(curIndex);
		curPath.add(curNode.id);
		if(curNode.left == null){
			paths.add(curPath);
		}
		else{
			dfs(curNode.left.id,tree,new ArrayList<Integer>(curPath),paths);
			dfs(curNode.right.id,tree,new ArrayList<Integer>(curPath),paths);
		}
	}

}

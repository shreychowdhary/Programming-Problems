import java.util.*;
import java.io.*;

class Node {
    public int index;
    public int distance;
    public int prev;

    public Node(int index) {
        this.index = index;
        this.distance = Integer.MAX_VALUE;
        this.prev = -1;
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        List<Map<Integer,Integer>> adjList = new ArrayList<>();
        Node[] graph = new Node[4];
        for(int i = 0; i < 4; i++) {
            graph[i] = new Node(i);
            adjList.add(new HashMap<Integer,Integer>());
        }
        adjList.get(0).put(1,10);
        adjList.get(0).put(2,4);
        adjList.get(2).put(1,4);
        adjList.get(1).put(3,5);
        System.out.println(dijkstra(0,3,adjList,graph).distance);
    }

    public static Node dijkstra(int startNode, int endNode, List<Map<Integer,Integer>> adjList, Node[] graph) {
        TreeSet<Integer> queue = new TreeSet<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer one, Integer two) {
                return Integer.compare(graph[one].distance,graph[two].distance);
            }
        });

        queue.add(startNode);
        graph[startNode].distance = 0;

        while(!queue.isEmpty()) {
            int curNode = queue.pollFirst();
            for(Map.Entry<Integer,Integer> neighbor : adjList.get(curNode).entrySet()) {
                int cost = neighbor.getValue();
                int index = neighbor.getKey();
                if(graph[index].distance >  cost + graph[curNode].distance) {
                    if(graph[index].distance != Integer.MAX_VALUE) {
                        queue.remove(index);
                    }
                    graph[index].distance = cost + graph[curNode].distance;
                    graph[index].prev = curNode;
                    queue.add(index);
                }
            }
        }
        return graph[endNode];
    }

}

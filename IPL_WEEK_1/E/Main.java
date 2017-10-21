import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();

        List<City> cities = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            cities.add(new City(i));
        }

        for(int i = 0; i < k; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            cities.get(a-1).roads.add(cities.get(b-1));
            cities.get(b-1).roads.add(cities.get(a-1));
        }

        for(int i = 0; i < l; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            cities.get(a-1).trains.add(cities.get(b-1));
            cities.get(b-1).trains.add(cities.get(a-1));
        }

        for(City city : cities){
            Set<Integer> r = city.rbfs();
            Set<Integer> t = city.tbfs();
            int count = 0;

            for(Integer i : r){
                if(t.contains(i)){
                    count++;
                }
            }
            System.out.print(count + " ");
        }

    }
}

class City {
    public int id;
    public List<City> roads;
    public List<City> trains;

    public City(int _id){
        id = _id;
        roads = new ArrayList<>();
        trains = new ArrayList<>();
    }

    public Set<Integer> rbfs(){
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(id);
        Queue<City> queue = new LinkedList<>();

        queue.addAll(roads);

        while(queue.size() > 0){
            City cur = queue.remove();
            if(!visited.contains(cur.id)){
                visited.add(cur.id);
                queue.addAll(cur.roads);
            }
        }
        return visited;
    }

    public Set<Integer> tbfs(){
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(id);
        Queue<City> queue = new LinkedList<>();

        queue.addAll(trains);

        while(queue.size() > 0){
            City cur = queue.remove();
            if(!visited.contains(cur.id)){
                visited.add(cur.id);
                queue.addAll(cur.trains);
            }
        }
        return visited;
    }
}

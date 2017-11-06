import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    Map<String, List<String>> crew = new LinkedHashMap<>();
    crew.put("rat",new ArrayList<String>());
    crew.put("wc", new ArrayList<String>());
    crew.put("man",new ArrayList<String>());
    crew.put("captain", new ArrayList<String>());

    for(int i = 0; i < n; i++) {
      String pers = in.nextLine();
      String[] temp = pers.split(" ");
      if(temp[1].trim().equals("woman") || temp[1].trim().equals("child")) {
        crew.get("wc").add(temp[0]);
      } else{
        crew.get(temp[1]).add(temp[0]);
      }
    }
    for(Map.Entry<String, List<String>> group : crew.entrySet()) {
      for(String person : group.getValue()) {
        System.out.println(person);
      }
    }
  }
}

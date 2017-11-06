import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Set<Character> vowels = new HashSet<Character>();
    Set<Character> constants = new HashSet<Character>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    vowels.add('y');
    for(int i = (int)'a'; i <= (int)'z'; i++) {
      if(!vowels.contains((char)i)) {
        constants.add((char)i);
      }
    }
    Scanner in = new Scanner(System.in);
    String str = in.nextLine().toLowerCase();
    for(int i = str.length()-1; i >= 0; i--) {
      if(vowels.contains(str.charAt(i))) {
        System.out.println("YES");
        return;
      }
      else if(constants.contains(str.charAt(i))) {
        System.out.println("NO");
        return;
      }
    }
  }
}

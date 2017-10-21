import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] names = new String[n];
    for(int i = 0; i < names.length; i++) {
      names[i] = in.next();
      //System.out.println(names[i]);
    }
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < names.length; i++) {
      int count = 0;
      for(int j = 0; j < names.length; j++) {
        if(i==j){
          continue;
        }
        String tmp = names[j];
        for(int k = 0; k < tmp.length(); k++){
          if(tmp.equals(names[i])){
            break;
          }
          char c = tmp.charAt(0);
          tmp = tmp.substring(1,tmp.length())+c;
          count++;
        }
        if(!tmp.equals(names[i])) {
          System.out.println(-1);
          return;
        }
      }
      if(count < min) {
        min = count;
      }
    }
    System.out.println(min);
  }
}

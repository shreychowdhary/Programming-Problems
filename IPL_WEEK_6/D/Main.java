import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int maxOne = Integer.MIN_VALUE;
    int maxTwo = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
      int one = in.nextInt();
      int two = in.nextInt();
      if(one > two) {
        if(one-two > maxOne) {
          maxOne = one-two;
        }
      }
      else if(two > one) {
        if(two-one > maxTwo) {
          maxTwo = two-one;
        }
      }
    }
    if(maxOne > maxTwo) {
      System.out.println("1 "+maxOne);
    }
    else {
      System.out.println("2 "+maxTwo);
    }
    return;
  }

}

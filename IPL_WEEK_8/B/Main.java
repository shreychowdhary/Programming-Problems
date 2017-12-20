import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] bulbs = new boolean[m];

        for(int i = 0; i < n; i++) {
            int numBulbs = in.nextInt();
            for(int j = 0; j < numBulbs; j++) {
                int tmp = in.nextInt()-1;
                System.out.println(tmp);
                bulbs[tmp] = true;
            }
        }

        for(int i = 0; i < bulbs.length; i++) {
            if(!bulbs[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        return;
    }
}

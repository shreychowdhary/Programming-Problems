import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Map<Integer, Long> vals = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            int a = in.nextInt();
            long b = in.nextLong();
            if(vals.containsKey(a)) {
                vals.put(a,vals.get(a)+b);
            } else {
                vals.put(a,b);
            }
        }
        int sum = 0;
        for(Map.Entry<Integer,Long> val : vals.entrySet()) {
            sum += val.getValue();
            if(sum >= k) {
                System.out.println(val.getKey());
                return;
            }
        }
    }
}

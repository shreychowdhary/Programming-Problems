import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            BigInteger num = new BigInteger("1",10);
            for(int j = 1; j <= tmp; j++) {
                num.multiply(new BigInteger(""+j,10));
                System.out.println(num.toString());
            }
            System.out.println(num.toString());
            String s = num.toString();
            int count = 0;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '0') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

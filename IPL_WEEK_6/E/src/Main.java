import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        TreeSet<Integer> one = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(prices[t1], prices[t2]);
            }
        });
        TreeSet<Integer> two = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(prices[t1], prices[t2]);
            }
        });
        TreeSet<Integer> three = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(prices[t1], prices[t2]);
            }
        });
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (val == 1) {
                one.add(i);
            } else if (val == 2) {
                two.add(i);
            } else {
                three.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (val == 1) {
                one.add(i);
            } else if (val == 2) {
                two.add(i);
            } else {
                three.add(i);
            }
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int val = in.nextInt();
            if (val == 1) {
                if(one.size() == 0) {
                    System.out.print("-1 ");
                    continue;
                }
                int ans = one.pollFirst();
                System.out.print(prices[ans] + " ");
                one.remove(ans);
                two.remove(ans);
                three.remove(ans);
            } else if (val == 2) {
                if(two.size() == 0) {
                    System.out.print("-1 ");
                    continue;
                }
                int ans = two.pollFirst();
                System.out.print(prices[ans] + " ");
                one.remove(ans);
                two.remove(ans);
                three.remove(ans);
            } else {
                if(three.size() == 0) {
                    System.out.print("-1 ");
                    continue;
                }
                int ans = three.pollFirst();
                System.out.print(prices[ans] + " ");
                one.remove(ans);
                two.remove(ans);
                three.remove(ans);
            }
        }
    }
}

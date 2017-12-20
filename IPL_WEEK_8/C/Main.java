import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] alc = {"ABSINTH", "BEER", "BRANDY", "CHAMPAGNE", "GIN", "RUM", "SAKE", "TEQUILA", "VODKA", "WHISKEY", "WINE"};
        int count = 0;
        for(int i = 0; i < n; i++ ){
            String s = in.nextLine();
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                int age = Integer.parseInt(s);
                if(age < 18) {
                    count++;
                }

            }
            else {
                for(int j = 0; j < 11; j++){
                    if(s.equals(alc[j])) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

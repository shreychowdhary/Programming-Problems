import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int g = in.nextInt();
        int b = in.nextInt();
        System.out.println(Integer.parseInt(r+""+g+""+b)%4==0?"YES":"NO");
    }
}

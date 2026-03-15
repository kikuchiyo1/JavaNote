import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if (s1.contains(s2)){
            System.out.println(s1.indexOf(s2));
        } else {
            System.out.println(-1);
        }
    }
}





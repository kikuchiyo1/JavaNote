import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] count = new int[10];

        for (int i = a; i <= b; i++) {
            int num = i;

            while (num > 0) {
                int digit = num % 10;
                count[digit]++;
                num /= 10;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(count[i]);
            if (i < 9) {
                System.out.print(" ");
            }
        }
        System.out.println();

        sc.close();
    }
}





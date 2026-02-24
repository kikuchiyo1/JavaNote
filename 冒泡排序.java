import com.example.utils.maopaoSort;

import java.util.*;

public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(input.nextInt());
        }
        maopaoSort.main(arr);
        arr.forEach(i -> System.out.print(i + " "));
    }
}




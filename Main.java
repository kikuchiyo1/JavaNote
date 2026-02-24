import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Main {

    public static void main(String[] args) {
       System.out.println(fb(3));
    }
    static int fb(int n){
        List<Integer> arr = new ArrayList<>();
        int count = 0;
        for(int i=0;i<n;i++){

            if(i == 0){
                arr.add(1);
                count=1;
            }
            else if(i == 1){
                arr.add(2);
                count=2;
            }
            else{
                count = arr.get(i-1) + arr.get(i-2);
                arr.add(count);
            }
        }
        return count;
    }
}






package Stream流;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream流的中间方法 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("1","2","3","4","5"));
        List<Integer> list2 = list.stream().map(Integer::parseInt).toList();
        for(Integer i: list2){
            if(i instanceof Integer){
                System.out.println(i);
            }
        }
    }
}



/*
中间方法会返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
修改Stream流中的数据，不会影响原来集合或者数组的数据
1.filter() 过滤元素
    list.stream().filter(x -> x > 5).forEach(System.out::println); // 大于5的元素留下

2.limit(long n)   截取前n个元素

3.skip(long n)    跳过前n个元素

4.distinct()      去重
    注意：去重时，必须保证元素是可哈希的，即必须实现hashCode()和equals()方法，此事在Map、Set中亦有记载

5.concat(Stream<? extends T> s)   合并两个Stream流
    注意concat是Stream接口的静态方法

6.map(Function<? super T, ? extends R> mapper) 映射元素
    map()方法用于将一个Stream的每个元素映射成另一个元素并转换成一个新的Stream，可以将一种元素类型转换成另一种元素类型。

7.sorted()         排序 要求元素实现Comparable接口或者提供自定义比较器Comparator 老生常谈
*/

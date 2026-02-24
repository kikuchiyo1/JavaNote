package Stream流;

import java.util.List;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class 获取Stream流 {
    //eg：使用Stream流生成斐波那契数列
    public static void main(String[] args) {
        LongStream stream = LongStream.generate(new fbSupplier());
        stream.limit(100)
                .forEach(System.out::println);

    }
}

class fbSupplier implements LongSupplier {
    long a = 0;
    long b = 1;
    @Override
    public long getAsLong() {
        long tmp = a+b;
        b = a;
        a = tmp;
        return tmp;
    }
}
/*
获取Stream流
1.单列集合：Collections中的默认方法stream()
   List<Integer> list = List.of(1,2,3,4,5);
   list.stream().forEach(System.out::println);

2.双列集合：Map中的default方法values()、keySet()、entrySet()
   Map<String, Integer> map = new HashMap<>();
   map.keySet().stream().forEach(System.out::println); // 输出所有 key
   map.entrySet().stream().forEach(System.out::println); // 输出所有键值对

3.数组：Arrays中的静态方法stream()
   int[] arr = {1,2,3,4,5};
   Arrays.stream(arr).forEach(System.out::println);

4.一堆零散数据：Stream.of()
   Stream.of(1,2,3,4,5).forEach(System.out::println);
   注意：Stream.of()方法的形参是可变参数，可以传递一堆零散数据，也可传递数组
        但是数组必须是引用类型，如果传递基本数据类型，会把整个数组当成一个元素传进Stream流

5.使用generate()生成Stream流
   Stream还可以通过Stream.generate()方法，它需要传入一个Supplier对象
   我们先说说Supplier:
   Supplier<T> 是 Java 8 引入的函数式接口（Functional Interface），在 java.util.function包中
    Supplier<T> 接口只有一个方法：T get()
    它的特点是不接收任何参数，直接返回一个结果。
    最常用的地方就是生成Stream无限流
    如何使用已经在上面写出来了
 */

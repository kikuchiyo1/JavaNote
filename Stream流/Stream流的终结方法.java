package Stream流;

import java.util.*;
import java.util.stream.Collectors;

public class Stream流的终结方法 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("小明-17岁","小花-18岁","小狗-114514岁"));
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(
                s -> s.split("-")[0],
                s -> Integer.parseInt(s.split("-")[1].split("岁")[0])
        ));
        System.out.println(map.entrySet());
    }
}
/*
1.forEach() 遍历

2.count() 计数

那么，如果我们想将Stream流中的元素输出为集合怎么搞？以下都是

5.collect() 收集
用法：以List<String> list = new ArrayList<>(List.of("小明","小明","小花","小狗"));为例
①输出为List
    List<String> list2 = list.stream().collect(Collectors.toList());
②输出为Set
    Set<String> list2 = list.stream().collect(Collectors.toSet());
③输出为Map
    Map<String, String> list2 = list.stream().collect(Collectors.toMap(value -> value, value -> value));
    具体见上面

4.toArray() 转数组
用法：
List<String> list = new ArrayList<>(List.of("小明","小花","小狗"));
String[] arr = list.stream().toArray(value -> new String[value]);//也可传入String[]::new
System.out.println(Arrays.toString(arr));


*/

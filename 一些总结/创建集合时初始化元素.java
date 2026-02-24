package 一些总结;

import java.util.*;

public class 创建集合时初始化元素 {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));

        Set<String> s = new HashSet<>(Set.of("a","b","c"));

        Map<String,Integer> m = new HashMap<>(Map.of(
                "a",1,
                "b",2,
                "c",3
        ));

        Queue<Integer> q = new LinkedList<>(List.of(1,2,3,4,5));
        //PriorityQueue， Deque同理

    }
}

/*
创建集合时初始化元素有以下方法：
//虽然用List演示，但是其余集合大都也能用
1.      List<Integer> list = List.of(1, 2, 3, 4, 5);
        语法虽然简洁，但是创建的是不可变集合，元素不可发生任何修改，也不能为null

2.      List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));
等价于   List<Integer> tmp  = List.of(1, 2, 3, 4, 5);
        List<Integer> list = new ArrayList<>(tmp);
这种写法很不错，相当于先创建了一个临时的不可变集合，再将其拷贝给一个可变的集合

3.      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
十分老资历的写法，优点是简单直观，可以用set，缺点是长度固定，一般别用

4.      List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
还可以的写法，也算能用

5.      List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
古法初始化，直接跳过

6.      List<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};
本质是匿名内部类，非常酷炫，但是没有屌用，可能有内存泄露，而且这么写很神经


*/

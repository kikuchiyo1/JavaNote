package 集合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Set相关 {
    //作业展示
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Integer> s = new HashSet<>();
        List<Message> results = new ArrayList<>();
        for(Message message : received) {
            if(s.add(message.sequence)){
                results.add(message);
            }
        }
        return results;
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}


/*
Java中的Set接口用于存储不重复的元素，相当于数学中的集合概念，继承自Collection接口
1.特点
①不允许重复元素
②允许null元素（但只能有一个null）
③无序，不保证插入顺序，不可用下标访问

2.常用实现类
①HashSet：底层使用哈希表实现，查询、添加、删除都很快
②LinkedHashSet：底层使用哈希表和链表实现，查询、添加、删除较快，且能保证插入顺序
③TreeSet：底层使用红黑树实现，查询、添加、删除较慢，但能保证元素有序

3.常用方法
add(E e)        // 添加 由于add方法在失败时会返回false，因此可以用来判断元素是否已经存在，非常有用
remove(Object) // 删除
contains(Object) // 是否存在
size()         // 元素个数
isEmpty()      // 是否为空
clear()        // 清空


4.注意事项
①Set实际上相当于只存储key的Map，事实上，最常用的HashSet就是一个HashMap的简单封装，因此，
  存入Set的元素必须正确覆写equals()方法和hashCode()方法，关于equals()和hashCode()方法的编写，详见同一个包里面的Map相关.java
②Set接口不保证元素顺序，但是SortedSet接口保证元素有序，TreeSet就是SortedSet的一个实现类，继承关系如下图：
               ┌───┐
               │Set│
               └───┘
                 ▲
            ┌────┴─────┐
            │          │
        ┌───────┐ ┌─────────┐
        │HashSet│ │SortedSet│
        └───────┘ └─────────┘
                       ▲
                       │
                  ┌─────────┐
                  │ TreeSet │
                  └─────────┘
使用TreeSet时,参照TreeMap类，元素必须实现Comparable<T>接口，或者在构造TreeSet时提供一个Comparator来指定排序规则，详见泛型包里的Main.java
 */
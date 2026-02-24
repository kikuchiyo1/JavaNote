package 集合;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//作业展示
public class Queue相关 {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A10"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V2"));
        q.offer(new User("B", "V10"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            int num1 = Integer.parseInt(u1.number.substring(1));
            int num2 = Integer.parseInt(u2.number.substring(1));
            return Integer.compare(num1, num2);
            //原来：return u1.number.compareTo(u2.number); 这样会导致A10排在A2前面
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}

/*
喜闻乐见的队列来了
队列的特点不必多bb，直接进入正题 注意避免把null元素加入队列
1.常用方法
①add(E e)：将元素添加到队尾，如果失败会抛出IllegalStateException异常
②offer(E e)：将元素添加到队尾，失败会返回false，不会抛出异常
③remove()：移除并返回队头元素，如果队列为空会抛出NoSuchElementException异常
④poll()：移除并返回队头元素，如果队列为空会返回null，不会抛出异常
⑤element()：返回队头元素但不移除，如果队列为空会抛出NoSuchElementException异常
⑥peek()：返回队头元素但不移除，如果队列为空会返回null，不会抛出异常
⑦size()：返回队列中元素的数量
⑧isEmpty()：判断队列是否为空
⑨contains(Object o)：判断队列中是否包含指定元素
观察①——⑥，可以发现这六个方法分为两组一一对应，实际使用时根据需要选择使用哪一组，通常使用offer()、poll()、peek()这组方法，因为它们在失败时不会抛出异常，更加安全。

2.常用实现类
①LinkedList：底层使用双向链表实现，查询较慢，但添加和删除很快
②PriorityQueue：就是优先队列，默认是小根堆，和一切需要排序的实现类如TreeMap，TreeSet一样，元素必须实现Comparable<T>接口，
  或者在构造时提供Comparator来指定排序规则。
  创建大根堆的简便写法：Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
③ArrayDeque：底层使用数组实现，查询较快，添加和删除也很快，但不允许null元素，用的比较少

 */
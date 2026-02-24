package 集合;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class List相关 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(List.of(
                new Person("Alice", 20),
                new Person("Bob", 30)
        ));
        System.out.println(list.contains(new Person("Alice", 20)));
    }
}
/*
List是Java中非常常用的集合接口，继承自Collection接口
1.特点
①有从0开始的下标
②允许重复元素，也允许null元素
③保证插入顺序

2.常用方法
add(e)          // 添加
add(i, e)       // 指定位置插入
get(i)          // 获取
set(i, e)       // 修改
remove(i)       // 删除
size()          // 元素个数
contains(e)     // 是否包含
indexOf(e)      // 查下标
clear()         // 清空

3.常用实现类
①ArrayList：底层用数组实现，查询快，增删慢
②LinkedList：底层用双向链表实现，查询慢，增删快

4.遍历List
虽然可以用for循环和get(i)方法来遍历List，但效率低下，特别是LinkedList,让我们坚持用迭代器(Iterator)来遍历List👍：
Iterator本身也是一个对象，它是由List的iterator()方法返回的。
Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素
使用如下：
List<String> list = List.of("apple", "pear", "banana");
for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
    String s = it.next();
    System.out.println(s);
事实上，因为Iterator非常常用，Java提供了更简洁的for-each循环来遍历List：
 List<String> list = List.of("apple", "pear", "banana");
        for (String s : list) {
            System.out.println(s);
        }
实际用的时候统一用for-each循环就完事了

5.List和数组的转换
List转数组：
Integer[] array = list.toArray(new Integer[list.size()]);
反过来把数组转List就简单多了，直接用of方法：
Integer[] array = { 1, 2, 3 };
List<Integer> list = List.of(array);

6.覆写equals方法
如果需要进行用List储存自定义对象并且调用contains、indexOf等方法，就必须覆写对象的equals方法
假设有Person类 包含String name和int age两个字段，覆写equals方法如下：
public boolean equals(Object o) {
    if (o instanceof Person p) { //instanceof用于类型检查
        return Objects.equals(this.name, p.name) && this.age == p.age; // 注意String类型的比较不可用==运算符
    }
    return false;
}
为什么name字段的比较要用Objects.equals方法而非直接this.name.equals(p.name)？用后者的话，如果this.name是null，就会报错
所以直接记住对引用类型全都用Objects.equals()比较
如果不调用List的contains()、indexOf()这些方法，那么放入的元素就不需要实现equals()方法。
*/
class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object o) {
        if (o instanceof Person p) {
            return Objects.equals(this.name, p.name) && this.age == p.age;
        }
        return false;
    }
}
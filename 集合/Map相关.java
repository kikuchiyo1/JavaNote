package 集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Map相关 {
    public static void main(String[] args) {
        Map<PersonMap, Integer> map = new HashMap<>();
        map.put(new PersonMap("Alice", 20), 100);
        System.out.println(map.get(new PersonMap("Alice", 20))); // 100
    }
}
/*
在cpp，它叫map、在python，它叫dict，在Java，它叫Map 它就是键值对Map<K, V>>
Map<String, Integer> map = new HashMap<>();
1.特点
①每个key只能对应一个value，但是一个value可以对应多个key
②key唯一，value不唯一

2.常用方法
put(K, V)        // 添加或修改
get(K)          // 根据key取value
remove(K)       // 删除
containsKey(K)  // 是否包含key
containsValue(V) // 是否包含value
size()         // 元素个数
isEmpty()      // 是否为空
keySet()       // 获取所有key的集合
values()       // 获取所有value的集合
entrySet()     // 获取所有key-value对的集合

3.常用实现类
一般就是hashmap （哈希表这一块，大二上数据结构期末考试有考到）
如果需要使用枚举类(enum)作为key，可以使用EnumMap
还有TreeMap，底层使用红黑树实现，能保证key有序，但查询、添加、删除较慢

4.使用自定义类作为key
①作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
②作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
  如果两个对象相等，则两个对象的hashCode()必须相等；
  如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
如何正确编写equals()方法？详见同一个包里面的List相关.java
如何编写hashCode()方法？我自己写一个当示范：
*/
class PersonMap extends Person{ // Person类已经定义了equals方法
    public PersonMap(String name, int age) {
        super(name, age);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
/*
5.SortedMap接口
有一种Map，它会对存储的key进行排序，就是SortedMap，它是一个接口，常用的实现类是TreeMap，继承关系如下图：
               ┌───┐
               │Map│
               └───┘
                 ▲
            ┌────┴─────┐
            │          │
        ┌───────┐ ┌─────────┐
        │HashMap│ │SortedMap│
        └───────┘ └─────────┘
                       ▲
                       │
                  ┌─────────┐
                  │ TreeMap │
                  └─────────┘
SortedMap的key必须实现Comparable接口，最常用作key的String类有实现好的Comparable接口
若要用自定义类作为SortedMap的key，就必须自己手动实现Comparable接口，重写compareTo方法
关于compareTo方法的重写，详见泛型这一节的笔记 注意使用TreeMap时，对Key的比较需要正确实现相等、大于和小于逻辑！
TreeMap的key会按照compareTo方法定义的顺序进行排序，默认是从小到大排序
TreeMap的key不必覆写hashcode方法和equal方法

6.注意
①不能存放相同的key，否则这个key原本对应的value会被直接覆盖掉
②在使用keySet或者entrySet方法遍历Map时，不能保证遍历有顺序，只会保证每个元素都被遍历一次
 */
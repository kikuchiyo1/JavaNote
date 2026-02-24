package 集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 集合工具类Collections {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        Collections.sort(list);
        for(Integer n : list){
            System.out.println(n); // 1 2 3
        }
    }

}

/*
Java中提供了一个集合工具类Collections，里面有很多静态方法来操作集合，例如：
1.排序与查找
①sort(List<T> list)：对List进行排序，元素必须实现Comparable<T>接口
②sort(List<T> list, Comparator<? super T> c)：对List进行排序，使用Comparator来指定排序规则
③binarySearch(List<? extends Comparable<? super T>> list, T key)：二分查找，元素必须有序
④binarySearch(List<? extends T> list, T key, Comparator<? super T> c)：二分查找，使用Comparator来指定排序规则

2.集合操作
①reverse(List<?> list)：反转List
②shuffle(List<?> list)：随机打乱List
③swap(List<?> list, int i, int j)：交换List中两个元素的位置
④fill(List<? super T> list, T obj)：用指定元素填充List
⑤rotate(List<?> list, int distance)：将List中的元素向右循环移动distance个位置，distance可以是负数，表示向左循环移动

3.查找与统计
方法	用法	说明
①max(Collection<? extends T> coll)：返回集合中的最大元素
②max(Collection<? extends T> coll, Comparator<? super T> c)：返回集合中的最大元素，使用Comparator来指定排序规则
③min(Collection<? extends T> coll)：返回集合中的最小元素
④min(Collection<? extends T> coll, Comparator<? super T> c)：返回集合中的最小元素，使用Comparator来指定排序规则
⑤frequency(Collection<?> c, Object o)：返回集合中指定元素的出现次数
⑥disjoint(Collection<?> c1, Collection<?> c2)：判断两个集合是否没有共同的元素
 */
package 一些总结;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class 关于Iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5,2,2,2);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer x = it.next();
            if (x == 2) {
                it.remove();
            }
        }
        for(Integer x : list){
            System.out.println(x);
        }

    }
}
/*
Java中的Iterator接口用于遍历集合元素。
说白了，也不需要搞的很懂，经常用的for each循环，内部就是用迭代器遍历的集合
什么内部实现方法啥的，全部都不会！
只有一种情况需要会用一下，就是在遍历集合时删除元素：
如果这么写就g了
for (Integer x : list) {
    if (x == 2) {
        list.remove(x); // 出事
    }
}
正确写法：
/*
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    Integer x = it.next();
    if (x == 2) {
        it.remove();
    }
*/

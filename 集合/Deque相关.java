package 集合;

import java.util.ArrayList;
import java.util.List;

public class Deque相关 {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
    }
}
/*
Deque是Java实现双端队列的接口 使用时同样注意避免将null元素加入队列
1.常用方法(因为太多 列个表格意思意思得了)
①添加元素到队尾：	        addLast(E e) / offerLast(E e)
②取队首元素并删除：	  removeFirst() /  pollFirst()
③取队首元素但不删除：       getFirst() /  peekFirst()
④添加元素到队首：	      addFirst(E e) / offerFirst(E e)
⑤取队尾元素并删除：	  removeLast() /  pollLast()
⑥取队尾元素但不删除：	     getLast() /  peekLast()
⑦size()：返回队列中元素数量
⑧isEmpty()：判断队列是否为空
⑧contains(Object o)：判断队列中是否包含某个元素
①-⑥ 只需要知道左边的方法失败时会抛出异常，右边的方法失败时会返回null
实际使用时一般多用右边

2.常用实现类
①ArrayDeque：底层使用数组实现，查询较慢，添加和删除也很快，但不允许null元素，用的比较少
②LinkedList：底层使用双向链表实现，查询较慢，但添加和删除很快
LinkedList堪称劳模，可以当作Deque，可以当作Queue，可以当作Stack，可以当作List

3.Stack这一块
因为Java的屎山这一块，我们现在通常用Deque模拟Stack
①添加元素到栈顶：	  push(E e) / offerFirst(E e)
②取栈顶元素并删除：	  pop() /  pollFirst()
③取栈顶元素但不删除：   peek() /  peekFirst()
注意用Deque模拟Stack时，尽量用pop()这一组的方法，这样能使代码更清晰
不要使用遗留类Stack
*/

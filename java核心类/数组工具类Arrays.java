package java核心类;

public class 数组工具类Arrays {
}

/*
1.排序相关
①sort(int[] a)：对int数组进行排序，其他基本类型的数组也有类似的方法
②sort(T[] a)：对对象数组进行排序，元素必须实现Comparable<T>接口
③sort(T[] a, Comparator<? super T> c)：自定义规则排序对象数组，使用Comparator来指定排序规则

2.查找相关
①binarySearch(int[] a, int key)：对int数组进行二分查找，必须有序
②binarySearch(T[] a, T key)：对对象数组进行二分查找，元素必须有序
③binarySearch(T[] a, T key, Comparator<? super T> c)：自定义

3.填充与复制
①fill(int[] a, int val)：将int数组的所有元素填充为指定值
②fill(int[] a, int fromIndex, int toIndex, int val)：将int数组的[fromIndex, toIndex)范围内的元素填充为指定值
③copyOf(int[] original, int newLength)：复制int数组，newLength是新数组的长度，超出补0，未满截断

4.比较与搜索
①equals(int[] a, int[] b)：比较两个int数组是否相等
②deepEquals(Object[] a1, Object[] a2)：比较两个对象数组是否相等，递归比较元素，适用于多维数组
③hashCode(int[] a)：返回int数组的哈希码
④deepHashCode(Object[] a)：返回对象数组的哈希码，适用于多维数组

*/

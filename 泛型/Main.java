package 泛型;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        System.out.println(add(p)); // 报错 因为add方法的参数只能接收Pair<Number>
    }
    static int add(Pair<? extends Number> p){
        int n1 = p.getValue1().intValue();
        int n2 = p.getValue2().intValue();
        return n1 + n2;
    }
}

/*
泛型的基本使用：
*/
class Pair<T> {
    private T value1;
    private T value2;
    public Pair(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue2() {
        return value2;
    }

    public T getValue1() {
        return value1;
    }
}
/*
1.继承关系：
注意泛型的继承关系：可以把ArrayList<Integer>向上转型为List<Integer>（T不能变），
但不能把ArrayList<Integer>向上转型为ArrayList<Number>（T不能变成父类）。
2.泛型接口：
还可以在接口中使用泛型。例如，Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口：
eg：
public interface Comparable<T> {

     * 返回负数: this排在前
     * 返回0: 相对位置不变
     * 返回正数: this排在后
int compareTo(T n);
}
要想让一个类可以被Arrays.sort()排序，就必须实现Comparable<T>接口。
这样就可以实现类的自定义排序规则
*/
class Student implements Comparable<Student> {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public int compareTo(Student n) {
        if (this.score != n.score) return n.score - this.score;//从大到小
        else if (this.name.length() != n.name.length()) return this.name.length() - n.name.length();
        else return this.name.charAt(0) - n.name.charAt(0);
    }
    public String getData() {
        return String.format("%s: %d", name, score);
    }
}

/*
3.extends通配符：
因为Java设计堆出来的屎山，假设有一个方法需要一个List<Number>类型的参数，实际传入时只能传List<Number>,不能传List<Integer>
这是因为List<Integer>和List<Number>之间没有继承关系，只能用extends通配符来解决这个问题：

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        System.out.println(add(p)); // 报错 因为add方法的参数只能接收Pair<Number>
    }
    static int add(Pair<Number> p){
        int n1 = p.getValue1().intValue();
        int n2 = p.getValue2().intValue();
        return n1 + n2;
    }

改为：
static int add(Pair<? extends Number> p){
        ...//内部不变
}
修改后，add方法的参数可以接收接收所有泛型类型为Number或Number子类的Pair类型
注意：使用extends通配符后，add方法内部无法调用传入Number引用的方法，换言之就是只读不写
另一种用法——使用extends限定T类型：
在定义泛型类时，可以使用extends限定T类型
class Pair<T extends Number> {
    ...
}
这样在创建Pair的实例时，T只能是Number或Number的子类，限定了T的范围

4.super通配符：
super通配符和extends通配符相反，extends通配符用于接收Number或Number的子类，而super通配符用于接收Number或Number的父类
换言之，extends通配符以Number作为上界，而super通配符以Number作为下界（实际使用时当然不一定是Number）
与extends通配符相对，方法内部只能调用传入Number引用的方法，换言之就是只写不读

PECS原则：
即：如果需要返回T，它是生产者（Producer），要使用extends通配符；如果需要写入T，它是消费者（Consumer），要使用super通配符。

注意点
①用到泛型类时，不能使用基本类型作为类型参数，必须使用对应的包装类。例如，不能使用ArrayList<int>，而应该使用ArrayList<Integer>。
②编写泛型类时，特别注意，泛型类型<T>不能用于静态方法，除非用一个新的符号作为静态方法的泛型参数
eg：
public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { ... }
    public T getLast() { ... }

    // 对静态方法使用<T>，会导致编译错误：
    public static Pair<T> create(T first, T last) {
        return new Pair<T>(first, last);
    }
}
但是可以改写一下静态方法，使其可以使用泛型参数：
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
这样就清楚地将静态方法的泛型类型和实例类型的泛型类型区分开
③泛型可以定义多种类型参数，例如Map<K, V>
④子类可以获取父类的泛型参数，例如class Student extends function<String>，这样Student就继承了function<String>中的value1和value2字段，并且它们的类型都是String



*/


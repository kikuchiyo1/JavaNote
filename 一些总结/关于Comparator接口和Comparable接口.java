package 一些总结;

import java.util.*;
public class 关于Comparator接口和Comparable接口 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Alice", 90));
        list.add(new Student("Bob", 80));
        list.add(new Student("Charlie", 85));
        Collections.sort(list); // 使用Student类的compareTo方法排序
        for (Student s : list) {
            System.out.println(s.getData());
        }

        Collections.sort(list, new newComparator());// 使用newComparator类的compare方法排序
        for (Student s : list) {
            System.out.println(s.getData());
        }
    }
}

class newComparator implements Comparator<Student> {
    public int compare(Student n1, Student n2) {
        if(n1.getScore()!=n2.getScore()){
            return n1.getScore()-n2.getScore();
        }
        else {
            return n1.getName().compareTo(n2.getName());
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public int compareTo(Student n) {
        if (this.score != n.score) return n.score - this.score;//从高到低排序
        else return this.name.compareTo(n.name);
    }
    public String getData() {
        return String.format("%s: %d", name, score);
    }
    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }
}
/*
Java中有两个接口用于比较对象的大小：Comparator和Comparable。
Comparable接口用于类的自然排序，如果希望类的对象按照某种自然顺序进行排序，或者这个类只需要一种排序方式
可以让类实现Comparable接口，并重写compareTo方法。

Comparator接口用于外部比较器，如果希望按照不同的排序规则对类的对象进行排序，可以创建一个Comparator接口的实现类，并重写compare方法。
如果不能修改类的代码来实现Comparable接口，或者需要多个不同的排序规则，可以使用Comparator接口来实现外部比较器。

通性：
返回-1：表示第一个参数应该排在前面 在Comparable中就是this排在前面，在Comparator中就是第一个参数排在前面
返回0：表示两个参数相等，位置不变
返回1：表示第一个参数应该排在后面

注意：
如果希望自定义类能加入TreeMap或者TreeSet、PriorityQueue等需要排序的集合中，必须让这个类实现Comparable接口，
或者在构造TreeMap或者TreeSet时提供一个Comparator来指定排序规则
 */

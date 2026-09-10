package java类;

public class 记录类 {
    public static void main(String[] args) {
        Point p = new Point(123, 456);
        System.out.println(p.x());
        System.out.println(p.y());
        System.out.println(p);
    }
}

/*
1.前言：
像String Integer等类都是不变类，不变类具有两个特点：
①使用final修饰类，保证类不可被继承
②使用final修饰字段，保证字段不可被修改
记录类也是不变类，用于表示“只读数据载体”
2.记录类的定义：
*/
record Point(int x, int y) {}
/*
改写为class，相当于如下代码：

final class Point extends Record {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public String toString() {
        return String.format("Point[x=%s, y=%s]", x, y);
    }

    public boolean equals(Object o) {
        ...
    }
    public int hashCode() {
        ...
    }
}
3.构造方法：
当需要对构造类的参数进行检验时，需要改写其默认的构造方法，假设x，y不能是负数，如下所示：
public record Point(int x, int y) {
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
}
4.小技巧：
作为record的Point仍然可以添加静态方法，一种常用的是of()方法，用来创建record对象
eg:
public record Point(int x, int y) {
    public static Point of() {
        return new Point(0, 0);
    }
    public static Point of(int x, int y) {
        return new Point(x, y);
    }
}
这样可以使代码更加简洁：
Point p1 = Point.of(); // 等价于 new Point(0, 0)
Point p2 = Point.of(123, 456); // 等价于 new Point(123, 456)
 */

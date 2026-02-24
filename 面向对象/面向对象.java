package 面向对象;

import java.util.*;

public class 面向对象 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Outer outer = new Outer(){
            @Override
            public void outerMethod() {
                System.out.println("匿名内部类重写了outerMethod方法,现在不会输出棍木了");
            }
        };
        outer.method();
        outer.outerMethod();
    }
}
//关于静态字段和静态方法
class StaticDemo {
    private static int count = 0; //静态字段属于类而不是对象 所有对象共享同一个静态字段
    public StaticDemo() {
        count++;
    }
    //静态方法只能访问静态字段 不能访问实例字段 因为实例字段属于对象 而静态方法属于类
    //静态方法可以通过类名直接调用 不需要创建对象 有点像cpp中的函数
    public static int getCount() {
        return count;
    }
}
//sealde class演示 sealed class是一种特殊的类 只能被特定的子类继承 通过permits关键字指定允许继承的子类 这样可以更好地控制类的继承关系 提高代码的安全性和可维护性
sealed class sealedClass permits SubClass1, SubClass2 {
    public void display() {
        System.out.println("This is a sealed class.");
    }
}
//final关键字用法很多 可以修饰类表示这个类不能被继承 修饰方法表示这个方法不能被重写 修饰变量表示这个变量是常量 只能赋值一次
final class SubClass1 extends sealedClass {
    @Override
    public void display() {
        System.out.println("This is SubClass1.");
    }
}

final class SubClass2 extends sealedClass {
    @Override
    public void display() {
        System.out.println("This is SubClass2.");
    }
}
/*接口演示 接口中的方法默认是public abstract的 但是可以使用default关键字提供默认实现 这样实现类就不必实现这个方法了
实现类中可以不实现default的方法 也可以改写或者使用它 */
interface Animal {
    String getName();
    String getColor();
    default  void sleep(){
        System.out.println("Animal is sleeping");
    }
    int getAge();
}
// Cat类继承了Animal接口 但是没有实现sleep方法 因为它有默认实现 类可以继承多个接口 但是只能继承一个类
class Cat implements Animal {
    private final String name;
    private final int age;
    private final String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    // Cat类可以直接调用Animal接口中的sleep方法 因为它有默认实现
    /*
    public void catSleep() {
        this.sleep();
    }
    */
    //也可以改写sleep方法
    @Override
    public void sleep() {
        System.out.println(name + " the cat is sleeping.");
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public int getAge() {
        return age;
    }
}

/*
关于内部类和匿名内部类还有静态内部类：
内部类隐含地持有Outer.this的实例 实例化内部类需要先实例化外部类 如
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();

匿名内部类可以继承自接口和普通类 一般使用java的标准接口Runnable 这个接口只有一个抽象方法run()
匿名内部类和内部类都可以访问外部类的成员变量和方法 包括private的字段 但是匿名内部类没有名字 只能使用一次 适合用来实现一些简单的接口或者重写一些方法
匿名内部类可以方便地重写类中的方法 如：
Outer outer = new Outer(){
                @Override
                public void outerMethod() {
                    System.out.println("匿名内部类重写了outerMethod方法,现在不会输出棍木了");
                }
        };
        outer.method();
        outer.outerMethod();

静态内部类不持有外部类的实例 可视作一个独立的类 但是持有外部类的private访问权限 只能访问外部类的静态成员 不能访问外部类的实例成员
*/
class Outer {
    private String name = "OuterClass";
    public void outerMethod() {
        System.out.println("输出棍母");
    }

    class Inner {
        public void innerMethod() {
            System.out.println("我是一般内部类");
        }
    }

    public void method() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是匿名内部类" + name);
            }
        };
        r.run();
    }

    static class StaticInner {
        public void staticInnerMethod() {
            System.out.println("我是静态内部类");
        }
    }
}


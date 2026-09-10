package java类;

public class 枚举类 {
}

/*
枚举类是Java中一种特殊的类，用于表示一组固定的常量值。每个枚举常量都是枚举类的一个实例，具有自己的属性和方法。
eg：
enum Day {
    MON, TUE, WED, THU, FRI, SAT, SUN
}
枚举类的比较：
枚举类是一种引用类型，我们知道引用类型之间的比较要用equals方法而不是==运算符，因为==比较的是对象的地址而不是内容。
但是枚举类可以用"=="进行比较，这是因为enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较
eg:
enum Color {
    RED, GREEN, BLUE
}
Color c1 = Color.RED;
Color c2 = Color.RED;
System.out.println(c1 == c2); // true
System.out.println(c1.equals(c2)); // true but more code...
枚举类的特点:
①定义的enum类型总是继承自java.lang.Enum，且无法被继承
②只能定义出enum的实例，而无法通过new操作符创建enum的实例
③定义的每个实例都是引用类型的唯一实例
④可以将enum类型用于switch语句
枚举类的方法：
①name() 返回常量名 如：String s = Weekday.SUN.name(); // "SUN"
②ordinal()（不建议业务用） 返回常量的序号 从0开始 如：int n = Weekday.SUN.ordinal(); // 6
③valueOf(String name) 返回与指定字符串名称相对应的枚举常量 如：Weekday day = Weekday.valueOf("SUN"); // Weekday.SUN
④values() 返回包含枚举类中所有常量的数组 如：Weekday[] days = Weekday.values(); // [Weekday.MON, Weekday.TUE, ..., Weekday.SUN]

枚举类适合用在switch语句中
 */

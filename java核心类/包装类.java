package java核心类;

public class 包装类 {
    public static void main(String[] args) {
        byte x = -1;
        byte y = 127;
        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127
    }
}


/*
包装类就是把 基本类型 包装成 对象类型 的类
可以自动装箱 / 自动拆箱
Integer a = 10;
int b = a;  // 注意a不能是null 否则报错

包装类的常用方法
Integer.parseInt("123");   // 字符串 → int
Integer.valueOf("123");   // 字符串 → Integer
Integer.toString(123);    // int → 字符串

Java的包装类型还定义了一些有用的静态变量：
boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
Boolean t = Boolean.TRUE;
Boolean f = Boolean.FALSE;

int可表示的最大/最小值:
int max = Integer.MAX_VALUE; // 2147483647
int min = Integer.MIN_VALUE; // -2147483648

long类型占用的bit和byte数量:
int sizeOfLong = Long.SIZE; // 64 (bits)
int bytesOfLong = Long.BYTES; // 8 (bytes)

注意点
①包装类是不可变对象
②包装类之间比较一定要用equals方法 不能用==运算符
③Java中没有无符号整型的基本类型 无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成。
例如，byte是有符号整型，范围是-128~+127，但如果把byte看作无符号整型，它的范围就是0~255。我们把一个负的byte按无符号整型转换为int：
public class Main {
    public static void main(String[] args) {
        byte x = -1;
        byte y = 127;
        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127
    }
}

 */
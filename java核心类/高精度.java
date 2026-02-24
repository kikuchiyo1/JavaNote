package java核心类;

import javax.imageio.ImageTranscoder;

public class 高精度 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Math.addExact(n,5)); // 10000000000
    }
}

/*
高精度也是各种编程语言的老生常谈了，Java中整数类型最高是long，超出long范围的整数需要用高精度类型来表示
Java中提供了java.math.BigInteger和java.math.BigDecimal两个类来处理高精度整数和高精度小数。

1.BigInteger类：
BigInteger用于表示任意精度的整数，BigInteger内部用一个int[]数组来模拟一个非常大的整数：
eg：
BigInteger bi = new BigInteger("1234567890");
System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000
对BigInteger做运算时只能使用实例方法，不能用运算符：
实例运算方法如下：
加法：add(BigInteger val)
减法：subtract(BigInteger val)
乘法：multiply(BigInteger val)
除法：divide(BigInteger val)
取模：mod(BigInteger val)
取幂：pow(int exponent)

BigInteger和Integer、Long一样，也是不可变类，并且也继承自Number类。因为Number定义了转换为基本类型的几个方法：
转换为byte：byteValue()
转换为short：shortValue()
转换为int：intValue()
转换为long：longValue()
转换为float：floatValue()
转换为double：doubleValue()
通过上述方法，可以把BigInteger转换成基本类型。如果BigInteger表示的范围超过了基本类型的范围，
转换时将丢失高位信息，即结果不一定是准确的。如果需要准确地转换成基本类型，可以使用intValueExact()、
longValueExact()等方法，在转换时如果超出范围，将直接抛出ArithmeticException异常。
eg:
BigInteger i = new BigInteger("123456789000");
System.out.println(i.longValue()); // 123456789000
System.out.println(i.multiply(i).longValueExact()); // java.lang.ArithmeticException: BigInteger out of long range
小知识：如果BigInteger的值甚至超过了float的最大范围（3.4x1038），那么返回的float是什么呢？ 答：Infinity

2.BigDecimal类：
BigDecimal可以表示一个任意大小且精度完全准确的浮点数
eg：
BigDecimal bd = new BigDecimal("123.4567");
System.out.println(bd.multiply(bd)); // 15241.55677489
方法：
①scale()方法：返回小数位数
eg:
BigDecimal bd = new BigDecimal("123.4567");
System.out.println(bd.scale()); // 4
注意：如果一个BigDecimal对象的scale方法返回了0，说明它是整数。如果返回负数，例如-2，说明它是一个末尾两位为0的整数
②precision()方法：返回有效数字的位数
eg:
BigDecimal bd = new BigDecimal("123.4567");
System.out.println(bd.precision()); // 7
③stripTrailingZeros()方法：去除小数末尾的0
eg:
BigDecimal bd = new BigDecimal("123.4567000");
System.out.println(bd.stripTrailingZeros()); // 123.4567
④setScale()方法：设置小数位数，如果精度低于原始值，可以设置进行四舍五入或是直接截断
eg:
 BigDecimal d1 = new BigDecimal("123.456789");
        BigDecimal d2 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
        BigDecimal d3 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
注意：对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时存在无法除尽的情况，这时必须指定精度以及如何进行截断：
eg：
BigDecimal d1 = new BigDecimal("123.456");
BigDecimal d2 = new BigDecimal("23.456789");
BigDecimal d3 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
BigDecimal d4 = d1.divide(d2); // 报错：ArithmeticException，因为除不尽
⑤divideAndRemainder()方法：同时返回商和余数
eg:
BigDecimal n = new BigDecimal("12.345");
BigDecimal m = new BigDecimal("0.12");
BigDecimal[] dr = n.divideAndRemainder(m);
System.out.println(dr[0]); // 102
System.out.println(dr[1]); // 0.105
小知识：可以利用此方法判断两数是否为倍数关系
eg：
BigDecimal n = new BigDecimal("12.75");
BigDecimal m = new BigDecimal("0.15");
BigDecimal[] dr = n.divideAndRemainder(m);
if (dr[1].signum() == 0) {
    // n是m的整数倍
}
⑥compareTo()方法：比较两个BigDecimal的大小，不可用equals方法比较，因为equals方法还会比较小数位数
eg:
BigDecimal d1 = new BigDecimal("123.456");
BigDecimal d2 = new BigDecimal("123.45600");
System.out.println(d1.equals(d2)); // false,因为scale不同
System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为3
System.out.println(d1.compareTo(d2)); // 0 = 相等, -1 = d1 < d2, 1 = d1 > d2

 */

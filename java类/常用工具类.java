package java类;

import java.security.SecureRandom;

public class 常用工具类 {
    public static void main(String[] args) {
        SecureRandom rand = new SecureRandom();
        System.out.println(rand.nextInt()); // 0~99之间的随机整数
    }
}

/*
1.Math类
①取绝对值
Math.abs(-123); // 123
②取最大/最小值
Math.max(1, 2); // 2
Math.min(1, 2); // 1
③取幂
Math.pow(2, 3); // 8.0
④取平方根
Math.sqrt(4); // 2.0
⑤求e的x次幂
Math.exp(1); // 2.718281828459045
⑥求以e为底的对数
Math.log(2); // 0.6931471805599453
⑦求以10为底的对数
Math.log10(100); // 2.0
⑧三角函数
sin() cos() tan() asin() acos() atan()
⑨随机数
Math.random(); // 0.0~1.0之间的随机数

2.HexFormat类
在处理byte[]和十六进制字符串之间的转换时，Java提供了HexFormat类来简化：
eg:
byte[] data = "Hello".getBytes();
HexFormat hf = HexFormat.of();
String hexData = hf.formatHex(data); // 48656c6c6f
从十六进制字符串到byte[]数组转换，使用parseHex()方法
byte[] bs = HexFormat.of().parseHex("48656c6c6f");

3.Random类
Random类可以生成伪随机数，伪随机数就是只要种子一样，生成的随机数就完全一样，默认使用系统当前时间戳作为种子
方法：nextInt()、nextLong()、nextFloat()、nextDouble()：

4.SecureRandom类
SecureRandom类用于生成不可预测的安全的随机数，其用法与Random基本一致
其安全性通过操作系统提供的安全的随机种子来保证，这个种子可能来自于硬盘温度、cpu热噪声等各种真随机现象产生
注意！注意！！注意！！！
需要使用安全随机数的时候，必须使用SecureRandom，绝对不能使用Random！


 */

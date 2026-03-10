package java核心类;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class 字符串相关 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String[] s = {"1145141919810","a","b"}; // 最后调用toString方法得到最终的字符串
        String news = String.join("*", s);
        System.out.println(news);
        Integer n = 114514;

    }
}

/*
1.字符串是不可变的对象 每次修改都会创建一个新的字符串对象:
String str = "Hello";
str = str + " World"; // 这会创建一个新的字符串对象 "Hello World" 而不是修改原来的字符串 "Hello"
str = str.toUpperCase(); // 这会创建一个新的字符串对象 "HELLO WORLD" 而不是修改原来的字符串 "Hello World"

2.字符串常量池是一个特殊的内存区域 用于存储字符串

3.字符串的比较应该使用equals方法 而不是==运算符,忽略大小写比较用equalsIgnoreCase()

4.String提供了多种方法搜索，提取子串 如：
①是否包含子串
"Hello".contains("ll"); // true
②是否以某个字符串开头
"Hello".startsWith("He"); // true
③是否以某个字符串结尾
"Hello".endsWith("lo"); // true
④某个字符的位置
"Hello".indexOf("l"); // 2
⑤某个字符最后一次出现的位置
"Hello".lastIndexOf("l"); //
⑥提取子串
"Hello".substring(2, 4); // "ll" 左闭右开
"Hello".substring(3); // "lo"

5.空白相关
①去除字符串两端的空白
"  \tHello\r\n ".trim(); // "Hello"
②strip方法与trim方法类似 但是strip方法使用Unicode标准定义的空白字符 而trim方法只去除ASCII空白字符
"\u3000Hello\u3000".strip(); // "Hello"
" Hello   ".stripLeading(); // "Hello   "
"   Hello ".stripTrailing(); // "   Hello"
③判断字符串是否为空和空白字符串
"".isEmpty(); // true，因为字符串长度为0
"  ".isEmpty(); // false，因为字符串长度不为0
"  \n".isBlank(); // true，因为只包含空白字符
" Hello ".isBlank(); // false，因为包含非空白字符

6.对字符串进行的操作
①替换字符串
String s = "hello";
s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
也可以用正则表达式替换
String s = "A,,B;C ,D";
s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
②分割字符串（传入的也是正则表达式）
String s = "A,B,C,D";
String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
③拼接字符串
String[] arr = {"A", "B", "C"};
String s = String.join("$", arr); // "A$B$C"
④格式化字符串
%s：显示字符串；
%d：显示整数；
%x：显示十六进制整数；
%f：显示浮点数。可以设定保留多少位小数，如%.2f表示保留两位小数；
String s = "Hi %s, your score is %d!";
System.out.println(s.formatted("Alice", 80));
System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));

7.字符串的类型转换
①将任意基本类型或引用类型转换为字符串 用valueOf方法
String.valueOf(123); // "123"
String.valueOf(45.67); // "45.67"
String.valueOf(true); // "true"
String.valueOf(new Object()); // 类似java.lang.Object@636be97c
②将字符串转换为基本类型 用parseXXX方法
Integer.parseInt("123"); // 123
Double.parseDouble("45.67"); // 45.67
Boolean.parseBoolean("true"); // true
特别注意，Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
Integer.getInteger("java.version"); // 版本号，如11

8.字符串的编码
牢记——Java的String和char在内存中总是以Unicode编码表示。
转换编码就是将String和byte[]转换，需要指定编码；
将字符串转换为byte[]，如下：
byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
byte[] b2 = "Hello".getBytes("GBK"); // 按GBK编码转换
byte[] b3 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
把已知编码的byte[]转换为String,如下：
byte[] b = ...
String s1 = new String(b, "GBK"); // 按GBK转换
String s2 = new String(b, StandardCharsets.UTF_8); // 按UTF-8转换

9.字符串的拼接
Java的编译器对String做了特殊处理，可以用"+"来拼接字符串，如下:
String s = "";
for (int i = 0; i < 1000; i++) {
    s = s + "," + i;
}
但是这种方式效率很低 因为每次拼接都会创建一个新的字符串对象 造成大量的内存浪费
正确的做法是使用StringBuilder类 来构建字符串 这样不会创建新的临时对象 如下:
StringBuilder sb = new StringBuilder(int n); // n是初始容量 如果不指定默认是16 当字符串长度超过容量时会自动扩容
for (int i = 0; i < 1000; i++) {
    sb.append(",")
      .append(114514)
      .append(i); // append方法可以链式调用
}
String s = sb.toString(); // 调用toString方法得到最终的字符串

为了满足用分隔符拼接数组的需求 Java标准库提供了StringJoiner
StringJoiner sj = new StringJoiner(","); // 指定分隔符
String[] arr = {"A", "B", "C"};
for (String str : arr) {
    sj.add("str");
}
sj.toString(); // "A,B,C"
也可以指定开头和结尾
StringJoiner sj = new StringJoiner(",", "114514", "1919810"); // 指定分隔符、开头和结尾
虽然但是 在不需要指定开头结尾时，一般直接用String.join方法
*/






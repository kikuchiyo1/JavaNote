package IO;

import java.io.FileReader;
import java.io.IOException;

public class 字符流_Reader_and_Writer {
    public static void main(String[] args) throws IOException {
        try (FileReader fis = new FileReader("src\\IO\\output.txt")) {
            char[] chars = new char[1024];
            int len;
            while ((len = fis.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
            }
        }
    }
}

 /*
Java的IO流分为字节流和字符流两类，InputStream和OutputStream是字节流，Reader和Writer就是是字符流（这四个类都是抽象类）
字符流的主要应用场景就是处理各种文本数据
字符流的底层是字节流，很多东西都一样，只记录一下不一样的地方

1.Reader的read()方法
①read()方法一次读取一个字节，如果遇到中文就会一次读取多个
②空参的read()方法会把读取到的字符转成int返回，输出时还需要强转成char
③有参(一般是char[]数组)的read()方法会自动完成读取、解码、强转的步骤，直接返回字符
eg：
public static void main(String[] args) throws IOException {
        try (FileReader fis = new FileReader("src\\IO\\output.txt")) {
            char[] chars = new char[1024];
            int len;
            while((len = fis.read(chars)) != -1){
                System.out.print(new String(chars,0,len));
            }
        }
    }
④同样，read()方法有参使用时，可以传入两个int参数，第一个参数是起始索引，第二个参数是读取的字节数

2.Writer的write()方法
①write()方法接受的参数如下
    write(int c)：写入一个字符，参数是一个int值，实际写入的是ASCII码表对应的字符
    write(char[] c)：写入一个字符数组
    write(String s)：写入一个字符串 最常用
    write(char[] c, int start, int len)：写入一个字符数组的某一部分
    write(String s, int start, int len)：写入一个字符串的某部分
  */

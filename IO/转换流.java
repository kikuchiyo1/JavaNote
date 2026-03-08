package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class 转换流 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\IO\\output.txt"), "UTF-8"))) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\IO\\转换流演示.txt"), "GBK"))){
                char[]  chars = new char[1024];
                int len;
                while ((len = br.read(chars)) != -1) {
                    bw.write(chars, 0, len);
                }
            }
        }
    }
}

/*
转换流的作用是将字节流转换成字符流，让字节流可以使用字符流的方法
转换流只有两个类：InputStreamReader 和 OutputStreamWriter
用法：
1.按照指定编码格式读取文件(了解)
InputStreamReader isr = new InputStreamReader(new FileInputStream("file.txt"), "GBK");
读取的时候按照字符流的方式即可
但是JDK11后，不推荐用这种方式了，推荐用下面的方式：
FileReader fr = new FileReader("file.txt", Charset.forName("GBK")); //这么写能达到和使用转换流一样的效果

2.按照指定编码格式写入文件(了解)
OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("file.txt"), "GBK");
写入的时候也可以按照字符流写入，如osw.write("字符串");
同上，JDK11后推荐用下面的方式：
FileWriter fw = new FileWriter("file.txt", Charset.forName("GBK"));

3.转换文件编码格式
见上

4.用转换流包装字节流，再用缓冲流包装转换流 套娃这一块
BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\IO\\output.txt"), "UTF-8"));
这样做的主要目的是让字节流可以使用字符缓冲流方法
*/

package IO;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("src\\IO\\output.txt")) {
            int n;
            while ((n = fis.read()) != -1) {
                System.out.println(n);
            }
        }
    }
}

/*
创建对象时：
1.创建FileInputStream对象时，如果文件不存在，会直接报错

2.可以传进文件路径，或者File对象

3.在创建FileInputStream对象时，最好用try(resource)语句，这样可以自动关闭流，避免资源泄露
eg：
public void read() throws IOException {
        try (FileInputStream fis = new FileInputStream("file.txt")) {
            int n;
            while ((n = fis.read()) != -1) {
                System.out.println(n);
            }
        }
    }



读取数据时：
1.read方法一次读取一个字节，返回数据在ASCII码表对应的int值，如果返回-1则表示文件末尾

2.read方法每一次调用都会将指针往后移动一位
所以循环读取时要借助第三方变量
eg：
int b;
while((b = fis.read()) != -1){
    System.out.println((char)b);
}

3.read方法可以一次读取多个字节，需要传入一个byte数组，返回实际读取的字节数，如果返回-1则表示文件末尾
eg：
byte[] bytes = new byte[1024];
fis.read(bytes);
*/
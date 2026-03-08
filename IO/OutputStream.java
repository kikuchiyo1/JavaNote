package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {
    public static void main(String[] args) throws IOException {
        try(FileOutputStream fos = new FileOutputStream("src\\IO\\output.txt")){
            String s = "hello world";
            byte[] bytes = s.getBytes();
            fos.write(bytes,1,2);
        }
    }
}
/*
FileOutputStream:
创建对象时：
1.创建FileOutputStream对象时，如果文件不存在，会自动创建，但是要保证父级目录存在

2.如果文件存在，会清空文件内容

3.创建对象时可以手动指定追加模式：
FileOutputStream fos = new FileOutputStream("src\\IO\\output.txt", true); 比如这样就是指定了追加模式，不会覆盖

4.如果创建FileOutputStream对象时，没有指定文件，则创建一个文件

5.如果创建FileOutputStream对象时，指定了文件，但文件不存在，则创建一个文件

6.创建FileOutputStream对象时，可以传入文件路径，也可以传入File对象

7.在创建FileOutputStream对象时，最好用try(resource)语句，这样可以自动关闭流，避免资源泄露
eg：
public void writeFile() throws IOException {
    try (OutputStream output = new FileOutputStream("out/readme.txt")) {
        output.write("Hello".getBytes("UTF-8")); // Hello
    } // 编译器在此自动为我们写入finally并调用close()
}


写入数据：
1.write方法的参数是整数，但是实际写入的是按照ASCII码对应的字符

2.write方法也可以写入多个字节，传入byte[]数组
eg：
    String s = "hello world";
    byte[] bytes = s.getBytes();
    fos.write(bytes);
    fos.write(bytes,1,3); // 还可以传入两个int参数，表示从bytes数组的1索引开始写入3个字节
在以byte数组写入文件时，要维护好读取的字节数，否则可能会导致数据丢失或者文件损坏
eg:
    byte[] bytes = new byte[1024];
    int len;
    while((len = bis.read(bytes)) != -1){
        bis.write(bytes,0,len);
    }

3.写入完成后要记得关闭流，否则可能会导致数据丢失或者文件损坏

4.如果要换行，写入一个换行符就可以了
tips：不同操作系统的换行符
windows：\r\n
Linux：\n
mac：\r
虽然只写\n或者\r都可以实现换行，但是这是Java底层补全的，建议还是自己写全
*/

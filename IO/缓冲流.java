package IO;

import java.io.*;

public class 缓冲流 {
    public static void main(String[] args) throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\IO\\output.txt"))){
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\IO\\output_copy.txt"))){
                byte[] bytes = new byte[1024];
                int len;
                while((len = bis.read(bytes)) != -1){
                    bos.write(bytes,0,len);
                }
            }
        }
    }
}
/*
缓冲流分为四类，都是老熟人：
字节缓冲流：BufferedInputStream、BufferedOutputStream
字符缓冲流：BufferedReader、BufferedWriter
缓冲流原理：
缓冲流内部维护了一个缓冲区，缓冲区大小默认是8192字节，缓冲区满时才会将数据写入目的地
因为缓冲区里的操作在内存里进行，学过计组的小伙伴都知道，内存的读写速度把硬盘爆了，所以缓冲流能提高读写效率

使用演示：
1.字节缓冲流拷贝文件： 见上
  注意：只需要关闭缓冲流就行，内部会自动关闭字节流，不需要手动关

2.字符缓冲流，缓冲流的提高效率对字符流不太明显，主要是为了两个特有的功能：
字符缓冲流有两个特有的方法：
①字符缓冲输入流 BufferedReader：readLine()：一次读取一行文本，返回字符串，遇到回车表示一行结束，但是不会把回车读进来，文件末尾返回null
eg：
try(BufferedReader br = new BufferedReader(new FileReader("src\\IO\\output.txt"))){
    String line;
    while((line = br.readLine()) != null){
        System.out.println(line);
    }
}

②字符缓冲输出流 BufferedWriter：newLine()：写入一个换行符，底层会根据操作系统自动补全换行符
*/

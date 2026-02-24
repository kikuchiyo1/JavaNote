package IO;

import java.io.File;
import java.io.IOException;

public class File对象 {
    public static void main(String[] args) throws IOException {
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
    }
}
/*
File对象可以操控文件和目录
1.创建File对象：
创建File对象时需要提供文件路径
绝对路径：不多说
相对路径：
// 假设当前目录是C:\Docs
File f1 = new File("sub\\javac"); // 绝对路径是C:\Docs\sub\javac
File f3 = new File(".\\sub\\javac"); // 绝对路径是C:\Docs\sub\javac
File f3 = new File("..\\sub\\javac"); // 绝对路径是C:\sub\javac
'.'表示当前目录，".."表示上级目录
注意：Java中表示\需要用\\

返回路径有三个方法：
① getPath()           返回构造方法传入的路径
② getAbsolutePath()   返回绝对路径
③ getCanonicalPath()  返回规范路径
什么是规范路径？
比如当前Main中的代码，运行后结果如下：
..
C:\Users\EODC\Desktop\java练习\practice\..
C:\Users\EODC\Desktop\java练习
可以发现绝对路径会保留 ..和. 而规范路径会将其转换为标准绝对路径

2.文件和目录：
File对象既可以表示文件也可以表示目录
构造File对象时，哪怕传入的文件或目录不存在，也不会报错，因为构建File对象不会导致任何磁盘操作，调用这个对象的方法时才会
相关方法：
①isFile() 判断是否是文件
②isDirectory() 判断是否是目录
③exists() 判断文件或目录是否存在
④length() 获取文件大小
⑤lastModified() 获取最后一次修改时间
⑥getName() 获取文件名
⑦getParent() 获取父目录
⑧canRead() 判断文件是否可读
⑨canWrite() 判断文件是否可写
⑩canExecute() 判断文件是否可执行
⑪isHidden() 判断文件是否隐藏

当File表示文件时，可以通过createNewFile()创建一个新文件，用delete()删除该文件：
需要读写临时文件时，可以用createTempFile()创建一个临时文件，用deleteOnExit()在程序退出时删除该文件
 File f = File.createTempFile("tmp-", ".txt"); // 创建临时文件，可以指定其前缀与后缀

File表示目录时，可以通过list()列出目录下的所有文件和目录，用listFiles()列出目录下的所有文件
listFiles()提供了一系列重载方法，可以过滤不想要的文件和目录
File对象如果表示一个目录，可以通过以下方法创建和删除目录：
boolean mkdir()：创建当前File对象表示的目录；
boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。
*/

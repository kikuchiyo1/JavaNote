package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class 文件拷贝 {

    static String now_path = "src\\IO\\";
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream(now_path+"Roxy.jpg")){
            try(FileOutputStream fos = new FileOutputStream(now_path+"Roxy_copy.jpg")){
                byte[] bytes = new byte[1024];
                int len;
                while((len = fis.read(bytes)) != -1){
                    fos.write(bytes,0,len);
                }
            }
        }
        System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
    }
}

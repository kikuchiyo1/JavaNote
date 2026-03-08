package IO;

import java.io.*;

public class 文件拷贝 {

    static String now_path = "src\\IO\\";

    public static void main(String[] args) throws IOException {
        zijieliu_common();
        zijieliu_bytes();
        huanchongliu_common();
        huanchongliu_bytes();
    }

    static long rebackTime() {
        return System.currentTimeMillis();
    }

    static void zijieliu_common() throws IOException {
        long now_time = rebackTime();
        try (FileInputStream fis = new FileInputStream(now_path + "output.txt")) {
            try (FileOutputStream fos = new FileOutputStream(now_path + "output_copy.txt")) {
                int n;
                while((n = fis.read()) != -1){
                    fos.write(n);
                }
            }
        }
        System.out.println("字节流单个字节拷贝 耗时：" + (rebackTime() - now_time) + "ms");
    }

    static void zijieliu_bytes() throws IOException {
        long now_time = rebackTime();
        try (FileInputStream fis = new FileInputStream(now_path + "output.txt")) {
            try (FileOutputStream fos = new FileOutputStream(now_path + "output_copy.txt")) {
                byte[] bytes = new byte[1024];
                int len;
                while((len = fis.read(bytes)) != -1){
                    fos.write(bytes, 0, len);
                }
            }
        }
        System.out.println("字节流byte数组拷贝 耗时：" + (rebackTime() - now_time) + "ms");
    }

    static void huanchongliu_common() throws IOException {
        long now_time = rebackTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(now_path + "output.txt"))) {
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(now_path + "output_copy.txt"))) {
                int n;
                while((n = bis.read()) != -1){
                    bos.write(n);
                }
            }
        }
        System.out.println("缓冲字节流单个字节拷贝 耗时：" + (rebackTime() - now_time) + "ms");
    }

    static void huanchongliu_bytes() throws IOException {
        long now_time = rebackTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(now_path + "output.txt"))) {
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(now_path + "output_copy.txt"))) {
                int n;
                byte[] bytes = new byte[1024];
                int len;
                while((len = bis.read(bytes)) != -1){
                    bos.write(bytes, 0, len);
                }
            }
        }
        System.out.println("缓冲字节流byte数组拷贝 耗时：" + (rebackTime() - now_time) + "ms");
    }
}

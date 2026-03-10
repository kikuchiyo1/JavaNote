package 网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//实现了客户端上传文件，服务端接收文件并保存文件至服务端本地，使用线程池控制并发
public class TCPPractice03_Server {
    static String now_path = "src\\网络编程\\";
    static ThreadPoolExecutor poor = new ThreadPoolExecutor(
            3,
            6,
            1,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy()
    );
    static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(11451);
        while (true) {
            Socket socket = ss.accept();
            poor.submit(new UploadFileRunnable(socket));
        }
    }

    //获取文件名
    static String getName(String fileName) {
        File dir = new File(now_path);
        File[] files = dir.listFiles();
        //处理没有原文件的情况
        boolean hasFile = false;
        for (File file : files) {
            if (file.getName().startsWith(fileName) && file.getName().split("\\.")[0].length() == fileName.length()) {
                hasFile = true;
                break;
            }
        }
        if (!hasFile) return fileName;
        //用Stream流收集所有上传后的文件
        String finalFileName = fileName;
        File[] newfiles = Arrays.stream(files).filter(file -> file.getName().contains(finalFileName) && file.getName().split("\\.")[0].length() != finalFileName.length())
                .toArray(File[]::new);
        boolean[] flag = new boolean[100];
        //获取目录中所有文件，标记已经出现过的复制文件名
        for (File file : newfiles) {
            flag[Integer.parseInt(file.getName().split("\\.")[0].substring(fileName.length()))] = true;
        }
        //获取顺序中的下一个文件名
        int i = 1;
        while (true) {
            if (!flag[i]) {
                if (i < 10) {
                    fileName += "0" + i;
                    break;
                } else {
                    fileName += i;
                    break;
                }
            }
            i++;
        }
        return fileName;
    }
}
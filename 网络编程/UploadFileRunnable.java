package 网络编程;

import java.io.*;
import java.net.Socket;

import static 网络编程.TCPPractice03_Server.getName;
import static 网络编程.TCPPractice03_Server.now_path;

public class UploadFileRunnable implements Runnable {

    Socket socket;
    public UploadFileRunnable(Socket s) {
        socket = s;
    }

    @Override
    public void run() {
        try (
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK"))
        ) {
            //接收文件名长度，根据长度创建定长byte数组接收文件名
            int allnameLength = bis.read();
            byte[] fileNameBytes = new byte[allnameLength];
            bis.read(fileNameBytes);
            String fileName = new String(fileNameBytes).split("\\.")[0];
            String filepath = now_path + getName(fileName) + ".jpg";
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath))) {
                byte[] bytes = new byte[1024];
                int len;
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bw.write("上传成功，已上传至 "+filepath);
                bw.newLine();
                bw.flush();

                System.out.println("拷贝完成");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

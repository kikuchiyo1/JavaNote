package 网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//实现了客户端上传文件，服务端接收文件并保存文件至服务端本地
public class TCPPractice03_Server {
    static String now_path = "src\\网络编程\\";

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(11451);
        Socket socket = ss.accept();

        try (
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK"))
        ) {
            //接收文件名长度，根据长度创建定长byte数组接收文件名
            int nameLength = bis.read();
            byte[] fileNameBytes = new byte[nameLength];
            bis.read(fileNameBytes);
            String fileName = new String(fileNameBytes).split("\\.")[0];

            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(now_path + fileName + "_copy.jpg"))) {
                byte[] bytes = new byte[1024];
                int len;
                while ((len = bis.read(bytes)) != -1){
                    bos.write(bytes,0,len);
                }
                bw.write("拷贝成功");
                bw.newLine();
                bw.flush();

                socket.close();
                System.out.println("拷贝完成");
            }
        }
    }
}
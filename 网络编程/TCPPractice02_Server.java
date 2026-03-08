package 网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//接受和反馈
public class TCPPractice02_Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(11451);
        Socket socket = ss.accept();

        try (BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"))) {
            try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK"))) {
                while (true) {
                    String line = bis.readLine();
                    if (line.equals("/close")) {
                        bos.write("收到断开指令，断开连接");
                        bos.newLine();
                        bos.flush();
                        System.out.println("收到断开指令，已断开连接");
                        break;
                    } else {
                        System.out.println("接受到数据：" + line + " 来自：" + socket.getInetAddress().toString().split("/")[1] + "：" + socket.getPort());
                        bos.write("收到嗷");
                        bos.newLine();
                        bos.flush();
                    }
                }
            }
            socket.close();
            ss.close();
        }
    }
}

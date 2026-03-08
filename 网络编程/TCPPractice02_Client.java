package 网络编程;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//接受和反馈
public class TCPPractice02_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 11451);
        Scanner input = new Scanner(System.in);

        try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK"))) {
            try (BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"))) {
                while (true) {
                    System.out.print("请输入文本：");
                    String message = input.nextLine();
                    bos.write(message);
                    bos.newLine();
                    bos.flush();

                    String line = bis.readLine();
                    if (line.equals("收到断开指令，断开连接")) {
                        System.out.println("已断开连接");
                        break;
                    } else {
                        System.out.println("接受到数据：" + line + " 来自：" + socket.getInetAddress().toString().split("/")[1] + "：" + socket.getPort());
                    }
                }
            }
        }
    }
}


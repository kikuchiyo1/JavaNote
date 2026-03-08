package 网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(11451);
        Socket socket = ss.accept();
        try(BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"))){
            String line;
            while((line = bis.readLine()) != null){
                System.out.println("接受到数据："+line+" 来自："+ socket.getInetAddress().toString().split("/")[1] +"："+socket.getPort());
            }
        }
        socket.close();
        ss.close();
    }
}

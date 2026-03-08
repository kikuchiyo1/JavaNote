package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class UDPSendMessageDemo {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();
        while(true){
            System.out.print("请输入文本：");
            String message = input.nextLine();
            if(message.equals("886")) break;
            byte[] data = message.getBytes();
            DatagramPacket dp = new DatagramPacket(data, data.length,
                    java.net.InetAddress.getLocalHost(), 11451);
            socket.send(dp);
        }
        socket.close();
    }
}

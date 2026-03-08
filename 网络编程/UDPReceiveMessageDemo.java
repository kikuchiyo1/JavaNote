package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(11451);
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
        while(true){
            socket.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();
            int port = dp.getPort();
            InetAddress address = dp.getAddress();
            String message = new String(data, 0, length);
            System.out.println("接受到数据："+message+" 来自："+ address.toString().split("/")[1] +"："+port);
        }
    }
}

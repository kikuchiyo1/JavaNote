package 网络编程;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 11451);

        try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK"))) {
            Scanner input = new Scanner(System.in);
            bos.write(input.nextLine());
            bos.newLine();
            bos.flush();
        }
        socket.close();
    }
}

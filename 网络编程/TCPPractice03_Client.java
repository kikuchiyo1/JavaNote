package 网络编程;

import java.io.*;
import java.net.Socket;

//实现了客户端上传文件，服务端接收文件并保存文件至服务端本地
public class TCPPractice03_Client {
    static String now_path = "src\\网络编程\\";
    static File file = new File(now_path + "Roxy.jpg");
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 11451);

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"))
        ) {
            //发送文件名与文件名长度
            byte[] fileNameBytes = file.getName().getBytes();
            bos.write(fileNameBytes.length);
            bos.write(fileNameBytes);
            bos.flush();
            //发送文件本体
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();
            socket.shutdownOutput();
            //处理响应
            String message = br.readLine();
            System.out.println(message);

            socket.close();
            System.out.println("上传完成");
        }
    }
}

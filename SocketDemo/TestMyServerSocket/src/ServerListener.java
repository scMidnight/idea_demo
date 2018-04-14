import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            //port的值范围：1-65535
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                //block会阻塞进程
                Socket socket = serverSocket.accept();
                //建立连接
                JOptionPane.showMessageDialog(null, "有客户端连接到了本机的12345端口");
                //将socket传递给新的线程
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().add(cs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package qqservice.qqservice;

import qqservice.common.Message;
import qqservice.common.MessageType;
import qqservice.common.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 监听客户端
 */
public class QQServer {
    private ServerSocket serverSocket = null;

    public QQServer() {
        System.out.println("服务端在9999端口监听。。。。。");
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                //当和某个客户端连接后会继续监听
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                User user = (User) ois.readObject();
                Message message = new Message();
                if (user.getUserId().equals("admin") && user.getPasswd().equals("admin")) {
                    //登陆成功
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCESS);
                    //创建一个线程
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(user.getUserId(), socket);
                    serverConnectClientThread.start();
                    ManagerClientThreads.addClientThread(user.getUserId(), serverConnectClientThread);
                } else {
                    //登陆失败
                    message.setMessageType(MessageType.MESSGEE_LOGIN_FAIL);
                    socket.close();
                }
                oos.writeObject(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

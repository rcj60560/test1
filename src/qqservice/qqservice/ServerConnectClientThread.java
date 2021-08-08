package qqservice.qqservice;

import qqservice.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectClientThread extends Thread {

    private String userId;
    private Socket socket = null;

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("服务端 和 客户端保持通讯 读取数据。。。");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

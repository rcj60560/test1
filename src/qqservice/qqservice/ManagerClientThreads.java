package qqservice.qqservice;

import java.util.HashMap;

/**
 * 管理跟客户端通讯的线程
 */
public class ManagerClientThreads {
    private static HashMap<String, ServerConnectClientThread> map = new HashMap<>();

    public static void addClientThread(String userId, ServerConnectClientThread thread) {
        map.put(userId, thread);
    }

    public static  ServerConnectClientThread getServerConnectClientThread(String userId){
        return map.get(userId);
    }
}

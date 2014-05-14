package com.pbattles.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

import java.util.List;

/**
 * Created by Nazar_Sheremeta on 5/13/14.
 */
public class SignalSocketIOServer {

    private SocketIOServer server;

    public void init() throws InterruptedException {
        Configuration config = createConfiguration();
        server = new SocketIOServer(config);
        addEventListeners();
        server.start();
    }

    public void close(){
        server.stop();
    }

    private void addEventListeners() {
        addJoinRoomEventListener(server);
        addMessageEventListener(server);
    }


    private Configuration createConfiguration() {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);
        return config;
    }


    private void addJoinRoomEventListener(SocketIOServer server) {
        server.addEventListener("join",String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient client, String data, AckRequest ackSender) {
                client.joinRoom(data);
            }
        });
    }

    private void addMessageEventListener(final SocketIOServer server) {
        server.addEventListener("message", String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient client, String data, AckRequest ackRequest) {
                String room = getCurrentRoom(client);
                server.getRoomOperations(room).sendEvent("message", data);
            }
        });
    }

    private String getCurrentRoom(SocketIOClient client) {
        List<String> rooms = client.getAllRooms();
        if (rooms == null) return null;
        return getLastElement(rooms);
    }

    private String getLastElement(List<String> rooms) {
        return rooms.get(rooms.size() - 1);
    }
}

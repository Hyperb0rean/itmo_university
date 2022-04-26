package com.greg.server.util.io;

import com.greg.server.util.ServerCommandManager;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class ResponseOutput implements Writable{


    private DatagramSocket socket;
    private byte[] buf = new byte[4096];
    private SocketAddress currentClient;
    private ServerCommandManager manager;

    public ResponseOutput(ServerCommandManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean write(String output) {
        try {

            this.currentClient = manager.getInput().getCurrentClient();
            this.socket = new DatagramSocket(currentClient);
        } catch (SocketException  e) {
            e.printStackTrace();
        }
        buf = output.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, currentClient);
        return true;
    }

    @Override
    public boolean error(String errMessage) {
        buf = errMessage.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, currentClient);
        return true;
    }
}

package com.greg.server.util.io;

import com.greg.server.util.ServerCommandManager;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class ResponseOutput implements Writable{


    private DatagramSocket socket;
    private byte[] buf = new byte[4096];
    private ServerCommandManager manager;

    public ResponseOutput(ServerCommandManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean write(String output) {
        ByteBuffer buffer = ByteBuffer.wrap(output.getBytes(StandardCharsets.UTF_8));
        try {
            DatagramChannel server = DatagramChannel.open().bind(null);
            server.send(buffer,manager.getInput().getCurrentClient());

        } catch (IOException e) {
            System.out.println("Не удалось отослать сообщение на клиент. Подробнее: \n" + e.getMessage());
        }
        return true;
    }

    @Override
    public boolean error(String errMessage) {
        ByteBuffer buffer = ByteBuffer.wrap(errMessage.getBytes(StandardCharsets.UTF_8));
        try {
            DatagramChannel server = DatagramChannel.open().bind(null);
            server.send(buffer,manager.getInput().getCurrentClient());

        } catch (IOException e) {
            System.out.println("Не удалось отослать сообщение на клиент. Подробнее: \n" + e.getMessage());
        }
        return true;
    }
}

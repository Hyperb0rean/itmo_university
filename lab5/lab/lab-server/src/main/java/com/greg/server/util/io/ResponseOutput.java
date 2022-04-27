package com.greg.server.util.io;

import com.greg.server.util.ServerCommandManager;


import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;


public class ResponseOutput implements Writable{


    private DatagramSocket socket;
    private byte[] buf = new byte[4096];
    private ServerCommandManager manager;

    public ResponseOutput(ServerCommandManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean write(String output) {
        Response response = new Response(output,MessageType.COMMON);
        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
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
        Response response = new Response(errMessage,MessageType.ERROR);
        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
        try {
            DatagramChannel server = DatagramChannel.open().bind(null);
            server.send(buffer,manager.getInput().getCurrentClient());

        } catch (IOException e) {
            System.out.println("Не удалось отослать сообщение на клиент. Подробнее: \n" + e.getMessage());
        }
        return true;
    }

}

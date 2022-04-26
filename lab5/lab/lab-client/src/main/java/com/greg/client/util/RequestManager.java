package com.greg.client.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class RequestManager {

    private Request makeRequest(String command,String argument){
        Request request = new Request();
        request.setCommand(command);
        request.setArgument(argument);
        return request;
    }
    public boolean sendRequest(String command, String argument)  {
        Request request = makeRequest(command,argument);
        String message = request.getCommand() + " " + request.getArgument();
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
        InetSocketAddress serverAdress = new InetSocketAddress("localhost",1337);
        try {
            DatagramChannel client = DatagramChannel.open().bind(null);
            client.send(buffer,serverAdress);
        } catch (IOException e) {
            System.out.println("Не удалось отослать сообщение на сервер. Подробнее: \n" + e.getMessage());
        }

        return true;
    }
}

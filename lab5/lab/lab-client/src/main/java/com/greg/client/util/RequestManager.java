package com.greg.client.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class RequestManager {

    private boolean serviceFlag = false;

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
        SocketAddress serverAdress = new InetSocketAddress("localhost",1337);
        try {
            DatagramChannel client = DatagramChannel.open().bind(null);
            client.send(buffer,serverAdress);

            buffer = ByteBuffer.allocate(4096);
            buffer.clear();
            serverAdress = client.receive(buffer);
            buffer.flip();
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            String msg = new String(bytes);
            if(msg.toCharArray()[0] == '0'){
                System.out.println(msg.substring(1));
            }else if (msg.toCharArray()[0] == '1'){
                System.err.println(msg.substring(1));
            }
            else if (msg.toCharArray()[0] == '2'){
                serviceFlag = !serviceFlag;
            }


        } catch (IOException e) {
            System.out.println("Не удалось отослать сообщение на сервер. Подробнее: \n" + e.getMessage());
        }


        return true;
    }

    public boolean isServiceFlag() {
        return serviceFlag;
    }
}

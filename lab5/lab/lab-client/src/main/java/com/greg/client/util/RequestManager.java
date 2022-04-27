package com.greg.client.util;

import com.greg.client.data.Organization;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class RequestManager {



    public Request makeRequest(String command,String argument){
        Request request = new Request();
        request.setCommand(command);
        request.setArgument(argument);
        request.setData(null);
        return request;
    }

    public Request makeRequest(String command, Organization organization){
        Request request = new Request();
        request.setCommand(command);
        request.setArgument("");
        request.setData(organization);
        return request;
    }


    public boolean sendRequest(Request request)  {

        ByteBuffer buffer = ByteBuffer.wrap(request.getBytes());
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



        } catch (IOException e) {
            System.out.println("Не удалось отослать сообщение на сервер. Подробнее: \n" + e.getMessage());
        }


        return true;
    }

}

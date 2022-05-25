package com.greg.client.util;

import com.greg.common.util.data.Organization;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class RequestManager {

    private boolean responseCode = false;

    public Request makeRequest(String command,String argument){
        Request request = new Request();
        request.setCommand(command);
        request.setArgument(argument);
        request.setData(null);
        return request;
    }

    public Request makeRequest(String command, Object data){
        Request request = new Request();
        request.setCommand(command);
        request.setArgument("");
        request.setData(data);
        return request;
    }
    public Request makeRequest(String command,String argument, Object data){
        Request request = new Request();
        request.setArgument(argument);
        request.setCommand(command);
        request.setData(data);
        return request;
    }



    public boolean sendRequest(Request request)  {

        ByteBuffer buffer = ByteBuffer.wrap(request.getBytes());
        SocketAddress serverAddress = new InetSocketAddress("localhost",1337);
        try {
            DatagramChannel client = DatagramChannel.open().bind(null);
            client.send(buffer,serverAddress);

            buffer = ByteBuffer.allocate(4096);
            buffer.clear();
            serverAddress = client.receive(buffer);
            buffer.flip();
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            int len = Integer.parseInt(new String(bytes));
            buffer.clear();
            StringBuilder msg = new StringBuilder("");
            for(int offset=0; offset<len; offset+=128) {
                serverAddress = client.receive(buffer);
                buffer.flip();
                byte[] temp = new byte[buffer.remaining()];
                buffer.get(temp);
                msg.append(new String(temp));
                buffer.clear();
            }

            if(msg.toString().toCharArray()[0] == '0'){
                System.out.println(msg.substring(1));
                responseCode = true;
            }else if (msg.toString().toCharArray()[0] == '1'){
                System.err.println(msg.substring(1));
                responseCode=false;
            }

        } catch (IOException e) {
            System.out.println("Не удалось отослать сообщение на сервер. Подробнее: \n" + e.getMessage());
        }


        return true;
    }

    public boolean isResponseCode() {
        return responseCode;
    }

}

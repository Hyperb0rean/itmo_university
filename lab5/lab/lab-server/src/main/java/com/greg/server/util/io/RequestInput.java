package com.greg.server.util.io;

import com.greg.server.data.Organization;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class RequestInput implements Readable{

    private final int port;
    private DatagramChannel server;
    private SocketAddress currentClient;

    public RequestInput(int port) {
        this.port = port;
        InetSocketAddress address = new InetSocketAddress("localhost", port);
        System.out.println("Сервер запущен по адресу #" + address);

    }


    @Override
    public Organization readOrganisation() {
        return null;
    }

    @Override
    public String read() {

        InetSocketAddress address = new InetSocketAddress("localhost", port);
        try {
            DatagramChannel server = DatagramChannel.open().bind(address);
            this.server = server;
            System.out.println("Чтение данных...");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при попытке чтения данных. Подробнее\n" + e.getMessage());
        }

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        try {
            this.currentClient = server.receive(buffer);
        } catch (IOException e) {
            System.err.println("Произошла ошибка при попытке чтения данных. Подробнее\n" + e.getMessage());
        }
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        String msg = new String(bytes);

        return msg;
    }

    @Override
    public Scanner getScanner() {
        return null;
    }

    @Override
    public SocketAddress getCurrentClient() {
        return currentClient;
    }
}

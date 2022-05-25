package com.greg.client;


import com.greg.client.util.ClientCommandManager;
import com.greg.common.util.data.User;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public final class Client {
    private static DatagramSocket socket;
    private static InetAddress address;

    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClientCommandManager manager = new ClientCommandManager();

        while (manager.isProgrammState()) {
            manager.vallidateCommand(scanner.nextLine());
        }
    }

}

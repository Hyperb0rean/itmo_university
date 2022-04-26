package com.greg.server.util.io;

import com.greg.server.data.Organization;

import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Scanner;

public interface Readable {
    Organization readOrganisation();
    String read();
    Scanner getScanner();
    SocketAddress getCurrentClient();
}

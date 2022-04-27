package com.greg.server.util.io;

import com.greg.server.data.*;
import com.greg.server.util.ServerCommandManager;

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
    private ServerCommandManager manager;

    public RequestInput(int port, ServerCommandManager manager) {
        this.port = port;
        this.manager = manager;
        InetSocketAddress address = new InetSocketAddress("localhost", port);
        System.out.println("Сервер запущен по адресу #" + address);

    }


    @Override
    public Organization readOrganisation() {
        manager.getOutput().service("readOrganisation");

        Organization organization = new Organization();

        organization.generateId();
        organization.setCreationDate();
        organization.setName(askName());
        organization.setCoordinates(askCoordinates());
        organization.setAnnualTurnover(askAnnualTurnover());
        organization.setEmployeesCount(askEmployeeCount());
        organization.setType(askOrgType());
        organization.setPostalAddress(askPostalAdress());


        manager.getOutput().service("readOrganisation");
        return organization;
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

    public  String askName(){
        manager.getOutput().write("Введите название организации:");
        return read();
    }

    public Coordinates askCoordinates(){
        Coordinates coordinates = new Coordinates();
        manager.getOutput().write("Введите координату x организации:");
        coordinates.setX(Integer.parseInt(read()));
        manager.getOutput().write("Введите координату у организации:");
        coordinates.setY(Double.parseDouble(read()));
        return coordinates;
    }

    public  Float askAnnualTurnover(){
        manager.getOutput().write("Введите оборот организации:");
        return Float.parseFloat(read());
    }

    public OrganizationType askOrgType(){
        manager.getOutput().write("Выбереете тип организации из предложенных(числом):\n    1.GOVERNMENT\n" +
                "    2.TRUST\n" +
                "    3.PRIVATE_LIMITED_COMPANY\n" +
                "    4.OPEN_JOINT_STOCK_COMPANY");
        OrganizationType result = OrganizationType.values()[Integer.parseInt(read())-1];
        return result;
    }
    public  int askEmployeeCount(){
        manager.getOutput().write("Введите количество работников организации:");
        return Integer.parseInt(read());
    }

    public Address askPostalAdress(){
        manager.getOutput().write("Введите почтовый адрес организации:");
        Address address = new Address();
        manager.getOutput().write("Введите название улицы организации:");
        address.setStreet(read());
        Location location = new Location();
        manager.getOutput().write("Введите координату x адреса:");
        location.setX(Long.parseLong(read()));
        manager.getOutput().write("Введите координату y адреса:");
        location.setY(Integer.parseInt(read()));
        manager.getOutput().write("Введите координату z адреса:");
        location.setZ(Float.parseFloat(read()));
        address.setTown(location);
        return address;
    }
}

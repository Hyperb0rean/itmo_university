package com.greg.client.commands;

import com.greg.client.data.*;

import java.util.Scanner;

public abstract class Command implements Executable {

    private final String name;
    private final String description;

    protected Command(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getDescription() {
        return this.description;
    }


    public String getName() {
        return this.name;
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getDescription() + ")";
    }

    public Organization readOrganisation(){
        Scanner scanner =new Scanner(System.in);
        Organization result = new Organization();
        result.setCreationDate();

        System.out.println("Введите название организации:");
        result.setName(scanner.nextLine());
        System.out.println("Введите координату x организации:");
        Integer x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите координату у организации:");
        double y = scanner.nextDouble();
        scanner.nextLine();
        Coordinates c = new Coordinates();
        c.setX(x);
        c.setY(y);
        result.setCoordinates(c);
        System.out.println("Введите оборот организации:");
        result.setAnnualTurnover(scanner.nextFloat());
        scanner.nextLine();
        System.out.println("Введите количество работников организации:");
        result.setEmployeesCount(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Выбереете тип организации из предложенных(числом):\n    1.GOVERNMENT\n" +
                "    2.TRUST\n" +
                "    3.PRIVATE_LIMITED_COMPANY\n" +
                "    4.OPEN_JOINT_STOCK_COMPANY");
        result.setType(OrganizationType.values()[scanner.nextInt()-1]);
        scanner.nextLine();
        System.out.println("Введите почтовый адрес организации:");
        System.out.println("Введите название улицы организации:");
        String street = scanner.nextLine();
        System.out.println("Введите координату x адреса:");
        Long xa = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Введите координату y адреса:");
        Integer ya = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите координату z адреса:");
        Float za = scanner.nextFloat();
        scanner.nextLine();
        Address a = new Address();
        a.setStreet(street);
        Location l = new Location();
        l.setX(xa);
        l.setY(ya);
        l.setZ(za);
        a.setTown(l);
        result.setPostalAddress(a);
        return result;
    }
}

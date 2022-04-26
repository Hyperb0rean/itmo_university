package com.greg.server.util.io;

import com.greg.server.data.*;
import java.io.FileReader;
import java.net.SocketAddress;
import java.util.Scanner;

public class FileInput implements Readable{

    private final Scanner scanner;

    public FileInput(FileReader fr) {
        scanner = new Scanner(fr);
    }

    public  String getName(){
        return scanner.nextLine();
    }

    public Coordinates getCoordinates(){
        Coordinates coordinates = new Coordinates();
        coordinates.setX(scanner.nextInt());
        scanner.nextLine();
        coordinates.setY(scanner.nextDouble());
        scanner.nextLine();
        return coordinates;
    }

    public  Float getAnnualTurnover(){
        Float result = scanner.nextFloat();
        return result;
    }

    public OrganizationType getOrgType(){
        OrganizationType result = OrganizationType.values()[scanner.nextInt()-1];
        scanner.nextLine();
        return result;
    }
    public  int getEmployeeCount(){

        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public Address getPostalAdress(){
        Address address = new Address();
        address.setStreet(scanner.nextLine());
        Location location = new Location();
        location.setX(scanner.nextLong());
        scanner.nextLine();
        location.setY(scanner.nextInt());
        scanner.nextLine();
        location.setZ(scanner.nextFloat());
        scanner.nextLine();
        address.setTown(location);
        return address;
    }

    @Override
    public  Organization readOrganisation(){
        Organization organization = new Organization();

        organization.generateId();
        organization.setCreationDate();
        organization.setName(getName());
        organization.setCoordinates(getCoordinates());
        organization.setAnnualTurnover(getAnnualTurnover());
        organization.setEmployeesCount(getEmployeeCount());
        organization.setType(getOrgType());
        organization.setPostalAddress(getPostalAdress());

        return organization;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public SocketAddress getCurrentClient() {
        return null;
    }
}

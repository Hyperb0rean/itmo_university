package com.greg.common.util.data;

import com.greg.common.commands.exceptions.LimitExceededException;
import com.greg.common.commands.exceptions.NullStringException;

import java.util.Date;

public class Organization implements Comparable<Organization>{

    private static int idGen;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private int employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null

    public Organization() {

    }

    public int getId() {
        return id;
    }

    static {
        idGen=1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void generateId() {
        id = idGen;
        idGen++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if(name.isEmpty()){
                this.name = "undefined";
                throw new NullStringException("Строка не может быть пустой");
            }
            else {
                this.name = name;
            }

        }catch (NullStringException ex){
            System.err.println(ex.getMessage());
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(){
        this.creationDate = new Date();
    }

    public Float getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Float annualTurnover) {
        try {
            if(annualTurnover <=0){
                this.annualTurnover = 0.01f;
                throw new LimitExceededException("Значение поля должно быть больше 0");
            }
            else {
                this.annualTurnover = annualTurnover;
            }

        }catch (LimitExceededException ex){
            System.err.println(ex.getMessage());
        }
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        try {
            if(employeesCount <=0){
                this.employeesCount = 1;
                throw new LimitExceededException("Значение поля должно быть больше 0");
            }
            else {
                this.employeesCount = employeesCount;
            }

        }catch (LimitExceededException ex){
            System.err.println(ex.getMessage());
        }
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Organization(String name, Coordinates coordinates, Date creationDate, Float annualTurnover, int employeesCount) {
        this.name = name;
        this.coordinates = coordinates;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
    }

    public Organization(String name, Coordinates coordinates, Float annualTurnover, int employeesCount, OrganizationType type) {
        this.name = name;
        this.coordinates = coordinates;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.type = type;
    }

    public Organization(String name, Coordinates coordinates, Float annualTurnover, int employeesCount, OrganizationType type, Address postalAddress) {
        this.name = name;
        this.coordinates = coordinates;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.type = type;
        this.postalAddress = postalAddress;
    }


    @Override
    public int compareTo(Organization o) {
        return this.getId() - o.getId();
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", annualTurnover=" + annualTurnover +
                ", employeesCount=" + employeesCount +
                ", type=" + type +
                ", postalAddress=" + postalAddress +
                '}';
    }

    public boolean vallidateInput() throws NullPointerException{
        if(postalAddress!=null){
            return (!name.isEmpty())&(coordinates!=null)&coordinates.vallidateInput()&(annualTurnover>0)&(employeesCount>0)& postalAddress.vallidateInput();
        }
        else {
            return (!name.isEmpty())&(coordinates!=null)&coordinates.vallidateInput()&(annualTurnover>0)&(employeesCount>0);
        }
    }
}

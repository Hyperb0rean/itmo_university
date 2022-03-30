package com.greg.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.greg.client.data.Organization;

import java.io.*;
import java.util.*;
import com.google.*;
import com.greg.client.exceptions.IllegalInputFromFileException;


public class OrganisationStorage {

    private final LinkedList<Organization> organizations;
    private final Date initDate;
    private Date modDate;

    public LinkedList<Organization> getOrganizations() {
        return organizations;
    }

    public Date getModDate() {
        return modDate;
    }
    public Date getInitDate() {
        return initDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public OrganisationStorage() {

        String text = "";
        try {
            File file = new File(System.getenv("LAB5"));
            //File file = new File("C:\\Users\\jewel\\Documents\\Java\\itmo_university\\lab5\\lab\\lab-client\\src\\main\\java\\com\\greg\\client\\util\\test.json");
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNextLine()){
                text+=scanner.nextLine();
            }
            fr.close();
        } catch (IOException e) {
            System.err.println("Файл не был найден " + e.getMessage());
        }
        GsonBuilder builder = new GsonBuilder();
//        builder.setDateFormat("MMM dd, yyyy HH:mm:ss");
        this.organizations = new LinkedList<>(
                (ArrayList<Organization>) builder.create().fromJson(
                        text, new TypeToken<List<Organization>>(){}.getType()
                )
        );
        for (Organization o: this.organizations) {
            o.generateId();
            o.setCreationDate();
           try {
              if(!o.vallidateInput()) throw new IllegalInputFromFileException("Некоторые поля не соответствуют условию");

           }catch (NullPointerException | IllegalInputFromFileException e){
               System.err.println("Не корректные данные в файле\n" + e.getMessage());
           }
        }
        this.initDate = new Date();
        this.modDate = initDate;
    }
}

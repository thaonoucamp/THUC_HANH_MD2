package service;

import controller.FileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Contact {
   private List<Person> contactList;

    public List<Person> getContactList() {
        return contactList;
    }

    public Contact() {
        try{
            contactList = FileIO.readerFromFile(FileIO.FILE_PATH);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            contactList = new ArrayList<>();
        }
    }
}

package controller;

import service.Contact;
import service.Person;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Controller {
    transient Scanner sc = new Scanner(System.in);
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public Controller() {
       contact = new Contact();
    }

    Person input() {
        Person newPerson = Person.getInstance();

        System.out.println("Enter the name");
        newPerson.setName(sc.nextLine());

        while (true) {
            System.out.println("Enter the phone number with form[0988.999.999]");
            String telephone = sc.nextLine();
            if (Valid.validate(Valid.REGEX_PHONE, telephone)) {
                newPerson.setTelephone(telephone);
                break;
            }
            System.out.println("Enter is not form");
        }

        System.out.println("Enter the gender");
        newPerson.setGender(sc.nextLine());

        System.out.println("Enter the address");
        newPerson.setAddress(sc.nextLine());

        while (true) {
            System.out.println("Enter the email with form[a@gmail.com]");
            String email = sc.nextLine();
            if (Valid.validate(Valid.REGEX_EMAIL, email)) {
                newPerson.setEmail(email);
                break;
            }
            System.out.println("Enter is not right with form");
        }
        return newPerson;
    }

    public void add(List<Person> list) throws IOException {
        this.getContact().getContactList().add(this.input());

        FileIO.writerToFile(FileIO.FILE_PATH, this.getContact().getContactList());
        show(list);
    }

    public void edit(List<Person> list) throws IOException {
        FileIO.writerToFile(FileIO.FILE_PATH, this.getContact().getContactList());

        int index = getIndexPerson(list);
        list.set(index, input());
        FileIO.readerFromFile(FileIO.FILE_PATH);

        show(list);
    }

    public void delete(List<Person> list) throws IOException {
        FileIO.writerToFile(FileIO.FILE_PATH, this.getContact().getContactList());

        int index = getIndexPerson(list);
        list.remove(index);
        FileIO.readerFromFile(FileIO.FILE_PATH);

        show(list);
    }

    public void find(List<Person> list) {
        int index = getIndexPerson(list);
        System.out.println(list.get(index));
    }

    public void show(List<Person> list) {
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public int getIndexPerson(List<Person> list) {
        System.out.println("Enter the number phone ");
        String telephone;
        telephone = sc.nextLine();
        for (int i = 0; i <= list.size(); i++) {
            if (telephone.equalsIgnoreCase(list.get(i).getTelephone())) {
                return i;
            }
        }
        System.out.println("Find is not the telephone of contact");
        return -1;
    }
}

package controller;

import service.Contact;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    transient Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();

    public void menu() throws IOException {
        int choice;
        do {
            System.out.println("-----MENU-----" +
                    "\n1 -> Add" +
                    "\n2 -> Edit" +
                    "\n3 -> Delete" +
                    "\n4 -> Find" +
                    "\n5 -> Write to file" +
                    "\n6 -> Read from file" +
                    "\n7 -> Exit"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> controller.add(controller.getContact().getContactList());
                case 2 -> controller.edit(controller.getContact().getContactList());
                case 3 -> controller.delete(controller.getContact().getContactList());
                case 4 -> controller.find(controller.getContact().getContactList());
                case 5 -> FileIO.writerToFile(FileIO.FILE_PATH, controller.getContact().getContactList());
                case 6 -> FileIO.readerFromFile(FileIO.FILE_PATH);
                case 7 -> System.exit(7);
            }
        } while (choice != 0);
    }
}

package view;

import controller.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu controller = new Menu();
        try{
            controller.menu();
        }catch (Exception e){
            System.out.println(e);
            controller.menu();
        }
    }
}

package controller;

import service.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static final String FILE_PATH = "/Users/thaodangxuan/IdeaProjects/THUC_HANH_MD2/src/controller/contact.csv";

    public static void writerToFile(String filePath, List<Person> list) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(filePath);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static List<Person> readerFromFile(String content) throws IOException {
        List<Person> personList = new ArrayList<>();

        FileReader fileReader = new FileReader(content);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Person person = Person.getInstance();
            String[] item = line.split(",");
            person.setName(item[0]);
            person.setGender(item[1]);
            person.setAddress(item[2]);
            person.setTelephone(item[3]);
            person.setEmail(item[4]);

            personList.add(person);
        }
        bufferedReader.close();
        fileReader.close();
        return personList;
    }
}

package com.kgisl.SampleQuickstart.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kgisl.SampleQuickstart.model.User;

public class CSVReader {
     private static final String CSV_FILE_PATH = "D:\\Swathi\\SampleQuickstart\\src\\main\\users.csv"; // Replace with your CSV file path

    public static List<User> readUsersFromCSV() {
    List<User> userList = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
        String line;
        boolean skipHeader = true; // Flag to skip the first line
        while ((line = br.readLine()) != null) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }

            String[] data = line.split(",");
            int id = Integer.parseInt(data[0].trim());
            String name = data[1].trim();
            String email = data[2].trim();
            User user = new User(id, name, email);
            userList.add(user);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    for (User iterable_element : userList) {
        System.out.println(iterable_element);
    }
    return userList;
}

}

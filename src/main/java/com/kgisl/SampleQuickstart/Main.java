package com.kgisl.SampleQuickstart;



import java.util.List;

import com.kgisl.SampleQuickstart.dao.UserDao;
import com.kgisl.SampleQuickstart.dao.UserDaoImpl;
import com.kgisl.SampleQuickstart.model.User;
import com.kgisl.SampleQuickstart.util.CSVReader;



public class Main {
     public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        // Read users from CSV
        List<User> userList = CSVReader.readUsersFromCSV();

        // Insert users into the database
        userDao.insertUsers(userList);

        System.out.println("Users inserted successfully!");
    }
}

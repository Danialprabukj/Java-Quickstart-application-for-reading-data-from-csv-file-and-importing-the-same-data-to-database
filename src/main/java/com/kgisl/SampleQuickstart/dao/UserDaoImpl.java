package com.kgisl.SampleQuickstart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.kgisl.SampleQuickstart.model.User;

public class UserDaoImpl implements UserDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/userdblist";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    @Override
    public void insertUsers(List<User> userList) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String userIds = userList.stream()
                        .map(User::getId)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));
                Gson gson = new Gson();
                String userListJson = gson.toJson(userList);
                System.out.println(userListJson);

                String sql = "CALL InsertUsersFromJson(?)";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, userListJson);
                    statement.executeUpdate();
                    System.out.println("Users inserted successfully!");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

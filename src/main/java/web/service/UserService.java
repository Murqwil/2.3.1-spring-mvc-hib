package web.service;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    void updateUserById(int id, String name, String lastName, double height, double weight);
}

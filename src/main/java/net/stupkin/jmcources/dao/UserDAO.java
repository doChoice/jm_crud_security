package net.stupkin.jmcources.dao;

import net.stupkin.jmcources.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(int id);
    void deleteUser(int id);
}

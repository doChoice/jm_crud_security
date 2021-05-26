package net.stupkin.jmcources.service;

import net.stupkin.jmcources.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(int id);
    void deleteUser(int id);
}

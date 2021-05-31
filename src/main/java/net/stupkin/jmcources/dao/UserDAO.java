package net.stupkin.jmcources.dao;

import net.stupkin.jmcources.model.Role;
import net.stupkin.jmcources.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
    User getUserByEmail(String email);
    Role getRoleById(Long id);
    List<Role> getAllRoles();
}

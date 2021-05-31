package net.stupkin.jmcources.service;

import net.stupkin.jmcources.model.Role;
import net.stupkin.jmcources.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
    User getUserByUsername(String userName);
    Role getRoleById(Long id);
    List<Role> getAllRoles();
}

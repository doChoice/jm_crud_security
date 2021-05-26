package net.stupkin.jmcources.service;

import net.stupkin.jmcources.dao.UserDAO;
import net.stupkin.jmcources.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}

package net.stupkin.jmcources.service;

import net.stupkin.jmcources.dao.JpaUserDAOImpl;
import net.stupkin.jmcources.dao.UserDAO;
import net.stupkin.jmcources.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}

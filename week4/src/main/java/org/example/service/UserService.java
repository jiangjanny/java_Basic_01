package org.example.service;

import org.example.dao.UserDAO;
import org.example.dao.UserDAOImpl;
import org.example.model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO = new UserDAOImpl();

    public void createUser(User user) {
        userDAO.save(user);
    }

    public User getUser(Long id) {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void deleteUser(Long id) {
        userDAO.delete(id);
    }
}
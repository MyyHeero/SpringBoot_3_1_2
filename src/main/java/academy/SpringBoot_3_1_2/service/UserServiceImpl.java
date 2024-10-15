package academy.SpringBoot_3_1_2.service;


import academy.SpringBoot_3_1_2.dao.UserDAO;
import academy.SpringBoot_3_1_2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public void addUser(User user) {
        userDAO.addUser(user);

    }

    @Override
    public void updateUser(int id, User user) {
        userDAO.updateUser(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);

    }

    @Override
    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}

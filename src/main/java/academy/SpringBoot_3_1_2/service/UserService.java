package academy.SpringBoot_3_1_2.service;



import academy.SpringBoot_3_1_2.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    public User getUserByID(int id);

    public List<User> getAllUsers();
}


package academy.SpringBoot_3_1_2.dao;
import academy.SpringBoot_3_1_2.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);


    }

    @Transactional
    @Override
    public void updateUser(int id, User updatedUser) {
        User user = entityManager.find(User.class, id);
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        entityManager.merge(user);

    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();

    }
}

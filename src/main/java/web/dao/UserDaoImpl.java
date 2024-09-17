package web.dao;

import jakarta.persistence.EntityManager;
import web.config.AppInit;
import web.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao  {

    private static final EntityManager entityManager = AppInit.getEntityManager();

    @Override
    public void saveUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeUserById(int id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM user_Param", User.class).getResultList();
    }


    @Override
    public void updateUserById(int id, String name, String lastName, double height, double weight) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setHeight(height);
            user.setWeight(weight);
            entityManager.merge(user);
        }
        entityManager.getTransaction().commit();
            }
    }

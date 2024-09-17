package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final UserDao userDao = new UserDaoImpl();

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void removeUserById(int id)  {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUserById(int id, String name, String lastName, double height, double weight) {
        userDao.updateUserById(id,name,lastName,height,weight);
    }
}

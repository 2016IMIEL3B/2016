package fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joe on 24/03/2016.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userDao.findAll();
    }


    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}

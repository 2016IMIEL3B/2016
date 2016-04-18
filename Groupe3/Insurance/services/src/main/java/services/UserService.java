package services;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import services.IUserService;

/**
 * Created by Enzo on 24/03/2016.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer id) {
        return userRepository.findOne(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

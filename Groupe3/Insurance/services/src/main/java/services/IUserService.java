package services;

import model.User;

/**
 * Created by Enzo on 24/03/2016.
 */
public interface IUserService {
    User getUser(Integer id);
    User findByUsername(String username);
}

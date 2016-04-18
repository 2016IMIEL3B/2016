package fr;

/**
 * Created by Nico on 11/02/2016.
 */
public interface IUserService {

    User save (User user);

    Iterable<User> findAll();



    User findByLogin(String login);
}

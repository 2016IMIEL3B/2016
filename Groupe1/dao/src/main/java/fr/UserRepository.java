package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nico on 11/02/2016.
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User save(User user);
    User findByLogin(String login);

    Iterable<User> findAll();
}

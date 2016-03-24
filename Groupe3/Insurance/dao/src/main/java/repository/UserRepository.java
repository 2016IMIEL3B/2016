package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sylvain on 11/02/2016.
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByLogin(String login);
    //void removeUser(int id);
}

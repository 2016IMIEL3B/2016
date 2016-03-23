package com.groupe4.dao;

import com.groupe4.entity.User;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by Mathilde on 23/03/2016.
 */
public interface IUserRepository {

    //Integer createUser(String name, String surname, String login, String password);
    //Integer updateUser(Integer id, String name, String surname, String login, String password);
    //Integer deleteUser(Integer id);
    void findById(Integer id, Handler<AsyncResult<User>> handler);
    //User findByLogin(String login);

}

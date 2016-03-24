package com.groupe4.dao;

import com.groupe4.entity.User;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by Mathilde on 23/03/2016.
 */
public interface IUserRepository {

    public void createUser(User user, Handler<AsyncResult<Integer>> handler);
    public void updateUser(User user, Handler<AsyncResult<Integer>> handler);
    public void deleteUser(Integer id, Handler<AsyncResult<Integer>> handler);
    public void findById(Integer id, Handler<AsyncResult<User>> handler);
    public void findByLogin(String login, Handler<AsyncResult<User>> handler);

}

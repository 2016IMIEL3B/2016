package com.groupe4.service;

import com.groupe4.dao.IUserRepository;
import com.groupe4.dao.UserRepository;
import com.groupe4.entity.User;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by Mathilde on 24/03/2016.
 */
public class UserService {

    private IUserRepository userDao;

    public UserService() {
        this.userDao = new UserRepository();
    }

    public void findById(Integer id, Handler<AsyncResult<User>> handler){
        this.userDao.findById(id, handler);
    }
    public void findByLogin(String login, Handler<AsyncResult<User>> handler){
        this.userDao.findByLogin(login, handler);
    }

    public void deleteUser(Integer id, Handler<AsyncResult<Integer>> handler){
        this.userDao.deleteUser(id, handler);
    }

    public void updateUser(User user, Handler<AsyncResult<Integer>> handler){
        this.userDao.updateUser(user, handler);
    }

    public void createUser(User user, Handler<AsyncResult<Integer>> handler){
        this.userDao.createUser(user, handler);
    }
}

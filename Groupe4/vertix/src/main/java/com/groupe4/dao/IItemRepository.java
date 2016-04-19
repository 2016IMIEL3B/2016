package com.groupe4.dao;

import com.groupe4.entity.Item;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;

/**
 * Item DAO interface.
 */
public interface IItemRepository {
    /**
     * Return a list of items by key.
     *
     * @param key
     * @return
     */
    public void findItemListByKey(String key, Handler<AsyncResult<List<Item>>> handler);

    /**
     * Return a List of items by id.
     *
     * @param id
     * @param handler
     */
    public void findItemListByParentId(Integer id, Handler<AsyncResult<List<Item>>> handler);
}

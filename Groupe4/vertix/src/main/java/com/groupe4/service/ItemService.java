package com.groupe4.service;

import com.groupe4.dao.ItemRepository;
import com.groupe4.entity.Item;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;

/**
 * Item service.
 */
public class ItemService {
    /**
     * Item Dao.
     */
    private ItemRepository itemDao;

    /**
     * Constructor.
     */
    public ItemService() {
        this.itemDao = new ItemRepository();
    }

    /**
     * Return a list of item by key.
     *
     * @param key Items key. Eg : Car.
     * @return Item list.
     */
    public void findItemListByKey(String key, Handler<AsyncResult<List<Item>>> handler) {
        this.itemDao.findItemListByKey(key, handler);
    }

    /**
     * Return a list of item by parent id.
     *
     * @param id
     * @return Item list.
     */
    public void findItemListByParentId(Integer id, Handler<AsyncResult<List<Item>>> handler) {
        this.itemDao.findItemListByParentId(id, handler);
    }
}

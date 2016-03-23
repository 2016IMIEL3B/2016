package com.groupe4.dao;

import com.groupe4.entity.Item;

import java.util.List;

public interface IItemRepository {
    /**
     * Return a list of items by key.
     *
     * @param key
     * @return
     */
    public List<Item> findItemListByKey(String key);
}

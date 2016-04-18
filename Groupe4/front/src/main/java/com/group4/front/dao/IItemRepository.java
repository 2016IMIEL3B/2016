package com.group4.front.dao;

import com.group4.front.entities.Item;

import java.util.List;

/**
 * Item DAO interface.
 */
public interface IItemRepository {
    /**
     * Return items by type.
     *
     * @param type
     * @return
     */
    public List<Item> findItemsByType(String type);

    /**
     * Return items by parent id.
     *
     * @param parentId
     * @return
     */
    public List<Item> findItemsByParentId(Integer parentId);
}

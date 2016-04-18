package com.group4.front.services;

import com.group4.front.dao.IItemRepository;
import com.group4.front.dao.ItemRepository;
import com.group4.front.entities.Item;

import java.util.List;

/**
 * Item service.
 */
public class ItemService {
    private IItemRepository itemRepository;

    public ItemService() {
        this.itemRepository = new ItemRepository();
    }

    public List<Item> findItemsByType(String type) {
        return this.itemRepository.findItemsByType(type);
    }

    public List<Item> findItemsByParentId(Integer parentId) {
        return this.itemRepository.findItemsByParentId(parentId);
    }
}

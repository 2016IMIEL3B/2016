package com.group4.front.services;

import com.group4.front.dao.IItemRepository;
import com.group4.front.dao.ItemRepository;
import com.group4.front.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Item service.
 */
@Service
public class ItemService {
    @Autowired
    private IItemRepository itemRepository;

    public List<Item> findItemsByType(String type) {
        return this.itemRepository.findItemsByType(type);
    }

    public List<Item> findItemsByParentId(Integer parentId) {
        return this.itemRepository.findItemsByParentId(parentId);
    }
}

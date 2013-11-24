package jdniemin.spring_base.service.impl;

import jdniemin.spring_base.domain.Item;
import jdniemin.spring_base.service.ItemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * A dummy service for testing.
 * 
 * @author jdniemin
 */
@Service
@Qualifier("inMemoryItemService")
public class InMemoryItemService implements ItemService{
    
    private final Map<Integer, Item> items = new HashMap<Integer, Item>();

    @PostConstruct
    private void init() {
        items.put(items.size(),  new Item(0L, "First item"));
        items.put(items.size(), new Item(1L , "Second item"));
    }

    @Override
    public List<Item> list() {
        return new ArrayList(items.values());
    }

    @Override
    public Item read(Long id) {
        return items.get(id.intValue());
    }

    @Override
    public Item create(Item item) {
        Integer nextVal = items.size();
        item.setId(nextVal.longValue());
        return items.put(nextVal, item);
    }

    @Override
    public Item update(Long id, Item item) {
        item.setId(id);
        return items.put(id.intValue(), item);
    }

    @Override
    public Item delete(Long id) {
        return items.remove(id.intValue());
    }
    
}

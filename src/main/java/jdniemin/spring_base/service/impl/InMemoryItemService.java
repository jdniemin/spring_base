package jdniemin.spring_base.service.impl;

import jdniemin.spring_base.domain.Item;
import jdniemin.spring_base.service.ItemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 * A dummy service for testing.
 *
 * @author jdniemin
 */
@Service(value="inMemoryItemService")
public class InMemoryItemService implements ItemService {

    private final Map<Long, Item> items = new HashMap<Long, Item>();
    private long counter;

    @PostConstruct
    private void init() {
        items.put(0L, new Item(0L, "First item"));
        items.put(1L, new Item(1L, "Second item"));
        counter = new Long(2);
    }

    @Override
    public List<Item> list() {
        return new ArrayList(items.values());
    }

    @Override
    public Item read(Long id) {
        return items.get(id);
    }

    @Override
    public Item create(Item item) {
        item.setId(counter);
        counter ++;
        return items.put(item.getId(), item);
    }

    @Override
    public Item update(Long id, Item item) {
        item.setId(id);
        return items.put(item.getId(), item);
    }

    @Override
    public Item delete(Long id) {
        return items.remove(id);
    }

}

package jdniemin.spring_base.controller;

import jdniemin.spring_base.domain.Item;
import jdniemin.spring_base.service.ItemService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Request mappings for public REST API
 * 
 * @author jdniemin
 */
@Controller
@RequestMapping("/rest/items")
public class PublicItemController extends CRUDRestController<Item, ItemService> {

    @Autowired
    @Qualifier("inMemoryItemService")
    private ItemService itemService;

    @PostConstruct
    public void init() {
        this.service = itemService;
    }

}

package jdniemin.spring_base.controller;

import jdniemin.spring_base.domain.Item;
import jdniemin.spring_base.service.ItemService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Request mappings for the web-application
 * 
 * @author jdniemin
 */
@Controller
@RequestMapping("/items")
public class ItemController extends CRUDRestController<Item, ItemService> {

    @Autowired
    @Qualifier("restTemplateItemService")
    private ItemService itemService;

    @PostConstruct
    public void init() {
        this.service = itemService;
    }

//    FOR TESTING:
//    
//    curl -i -H "Accept: application/json" http://localhost:8084/spring_base/items
//    curl -i -H "Accept: application/json" http://localhost:8084/spring_base/items/0
//    
//    curl -i -H "Content-Type:application/json" -H "Accept: application/json" -X POST -d '{"id": 2, "name": "Third item"}' http://localhost:8084/spring_base/items
//
//    curl -i -H "Content-Type:application/json" -H "Accept: application/json" -X PUT -d '{"id": 2, "name": "Modified third item"}' http://localhost:8084/spring_base/items/2
//
//    curl -i -H "Accept: application/json" -X DELETE http://localhost:8084/spring_base/items/1
    
    
}

package jdniemin.spring_base.service.impl;

import jdniemin.spring_base.domain.Item;
import jdniemin.spring_base.service.ItemService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * A service to call other REST APIs
 * 
 * @author jdniemin
 */
@Service
@Qualifier("restTemplateItemService")    
public class RestTemplateItemService implements ItemService {

    private RestTemplate restTemplate;
    private static String HOST = "http://localhost:8084";
    private static String PATH = "/spring_base/rest/items";
    private static String URI = HOST + PATH;

    @PostConstruct
    private void init() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public List<Item> list() {
        return restTemplate.getForObject(URI, List.class);
    }

    @Override
    public Item read(Long id) {
        return restTemplate.getForObject(URI + "/{id}", Item.class, id);
    }

    @Override
    public Item create(Item item) {
        return restTemplate.postForObject(URI, item, Item.class);
    }

    @Override
    public Item update(Long id, Item item) {
        restTemplate.put(URI + "/{id}", item, id);
        return read(id);
    }

    @Override
    public Item delete(Long id) {
        Item item = read(id);
        restTemplate.delete(URI + "/{id}", id);
        return item;
    }

}

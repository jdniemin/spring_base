package jdniemin.spring_base.controller;

import jdniemin.spring_base.service.CRUDService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class CRUDRestController<T, S extends CRUDService<T>> {
  
    protected S service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<T> list() {
        return service.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public T read(@PathVariable Long id) {
        return service.read(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public T create(@RequestBody T object) {
        return service.create(object);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public T update(@PathVariable Long id, @RequestBody T object) {
        return service.update(id, object);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public T delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

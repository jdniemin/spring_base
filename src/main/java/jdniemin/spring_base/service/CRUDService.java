package jdniemin.spring_base.service;

import java.util.List;

public interface CRUDService<T> {

    public List<T> list();

    public T read(Long id);

    public T create(T object);

    public T update(Long id, T object);

    public T delete(Long id);
}

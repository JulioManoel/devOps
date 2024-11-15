package com.ac2.project_ac2.interfaces;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T, ID> {
	List<T> all();
    Optional<T> findById(ID id);
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}

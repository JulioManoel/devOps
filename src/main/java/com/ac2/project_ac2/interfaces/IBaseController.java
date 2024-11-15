package com.ac2.project_ac2.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IBaseController<T, ID> {
	ResponseEntity<List<T>> getAll();
	ResponseEntity<T> getById(ID id);
	ResponseEntity<T> create(T entity);
	ResponseEntity<T> update(ID id, T entity);
	ResponseEntity<Void> delete(ID id);
}

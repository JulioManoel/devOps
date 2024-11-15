package com.ac2.project_ac2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ac2.project_ac2.interfaces.IBaseController;
import com.ac2.project_ac2.interfaces.IBaseService;

import jakarta.persistence.EntityNotFoundException;

public class BaseController<T, ID> implements IBaseController<T, ID> {
	protected final IBaseService<T, ID> service;

    public BaseController(IBaseService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
    	return ResponseEntity.ok(service.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> entity = service.findById(id);
        return entity.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T savedEntity = service.create(entity);
        return ResponseEntity.ok(savedEntity);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
    	try {
    		T updatedEntity = service.update(id, entity);
            return ResponseEntity.ok(updatedEntity);
    	} catch (EntityNotFoundException error) {
    		return ResponseEntity.notFound().build();
		} 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
    	try {
    		service.delete(id);
            return ResponseEntity.noContent().build();
    	} catch (EntityNotFoundException error) {
    		return ResponseEntity.notFound().build();
		}
    }
}

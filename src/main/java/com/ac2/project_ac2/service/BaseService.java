package com.ac2.project_ac2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ac2.project_ac2.interfaces.IBaseService;

import jakarta.persistence.EntityNotFoundException;

public class BaseService<T, ID> implements IBaseService<T, ID> {
	@Autowired
    protected JpaRepository<T, ID> repository;
	
    public List<T> all() {
        return repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(ID id, T entity) {
        if (!repository.existsById(id)) {
        	throw new EntityNotFoundException("Entidade não encontrada para o ID: " + id);
        }
        
        return repository.save(entity);
    }

    public void delete(ID id) {
        if (!repository.existsById(id)) {
        	throw new EntityNotFoundException("Entidade não encontrada para o ID: " + id);  
        } 
        
        repository.deleteById(id);
    }
}

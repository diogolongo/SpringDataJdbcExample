package br.com.llongo.persistence.repository;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	  T findOne(ID id);
	  T save(T entity);
}
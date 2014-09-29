package br.com.llongo.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.llongo.persistence.entities.Task;
@Repository
public class TaskRepository implements MyBaseRepository<Task, Integer>{

	private EntityManager entityManager;
	@Autowired
	public TaskRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public Task findOne(Integer id) {
		Query createQuery = entityManager.createQuery("SELECT x FROM Task x where  x.id = ?1");
		createQuery.setParameter(1, id);
		return (Task) createQuery.getSingleResult();
	}


	@Override
	public Task save(Task task) {
		entityManager.persist(task);
		return task;
	}

	
}

package br.com.llongo.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Task implements Serializable {
	public Task() {
	}
	public Task(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7185813866142443643L;
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

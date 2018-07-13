package com.sprhib.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Team")
public class Team {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Integer rating;

	 private List<Person> personas;

	@ManyToOne
	private Sponsor sponsor;

	public List<Person> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Person> personas) {
		this.personas = personas;
	}

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

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}

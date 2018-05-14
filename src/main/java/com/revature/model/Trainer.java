package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Trainer")
@NamedQueries({ @NamedQuery(name = "getAllTrainers", query = "from Trainer") })
public class Trainer {
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	private String skills;
	private boolean active;


}

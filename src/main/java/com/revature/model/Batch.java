package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Batch")
@NamedQueries({ @NamedQuery(name = "RetrieveAllBatches", query = "from Batch") })
public class Batch {
	// @GeneratedValue(strategy=GenerationType.AUTO)
	// @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqname")
	// @SequenceGenerator(initialValue=1, sequenceName="seq_name", allocationSize=1,
	// name="seqname")
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	private String curriculum;
	private String trainer;
	private String location;
	private String building;
	private String room;
	private Date startDate;
	private Date endDate;

	public Batch(String name, String curriculum, String trainer, String location, String building, String room,
			Date startDate, Date endDate) {
		this.name = name;
		this.curriculum = curriculum;
		this.trainer = trainer;
		this.location = location;
		this.building = building;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Batch() {
		super();
	}
	@Override
	public String toString() {
		return "Batch [name=" + name + ", curriculum=" + curriculum + ", trainer=" + trainer + ", location=" + location
				+ ", building=" + building + ", room=" + room + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}

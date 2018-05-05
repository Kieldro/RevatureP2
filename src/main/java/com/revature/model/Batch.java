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
@NamedQueries({ 
	@NamedQuery(name = "RetrieveAllBatches", query = "from Batch") })
public class Batch {
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqname")
//	@SequenceGenerator(initialValue=1, sequenceName="seq_name", allocationSize=1, name="seqname")
	@Id
	@Column(name="", nullable=false)
	private String name;
	private String curriculum;
	private String trainer;
	private String location;
	private String building;
	private String room;
	private Date startDate;
	private Date endDate;
}

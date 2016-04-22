package es.uniovi.electoral.model;

import java.sql.Timestamp;


public class Configuration {

	private String name;
	private Timestamp startDate;
	private Timestamp endDate;
	private String type;
	private String comment;
	
	public Configuration(String name, Timestamp startDate, Timestamp endDate,
			String type, String comment) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public String getType() {
		return type;
	}

	public String getComment() {
		return comment;
	}
	
}

package es.uniovi.electoral.model;

public class Option {

	private long id;
	private String name;
	private String comment;
	public Option(long id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getComment() {
		return comment;
	}
		
}

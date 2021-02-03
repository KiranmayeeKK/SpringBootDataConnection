package io.katkol.SpringBootDataConnection.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //Annotation to tell JPA that this class is to be mapped to a table. It tells JPA to create a table with 3 columns id, name and description.
public class Topic {

	@Id // tells JPA that this is the primary key column of the table
	private String id;
	private String name;
	private String description;
	
	public Topic() {
		super();
	}

	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

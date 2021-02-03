package io.katkol.SpringBootDataConnection.course;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.katkol.SpringBootDataConnection.topic.Topic;

@Entity //Annotation to tell JPA that this class is to be mapped to a table. It tells JPA to create a table with 3 columns id, name and description.
public class Course {

	@Id // tells JPA that this is the primary key column of the table
	private String id;
	private String name;
	private String description;
	@ManyToOne //Lazy initialization can also be used here to avoid the topic information being loaded from database when corresponding course info is retrieved
	private Topic topic; // Many courses are mapped to one topic
	
	public Course() {
		super();
	}

	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
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
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	
}

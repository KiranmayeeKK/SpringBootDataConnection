package io.katkol.SpringBootDataConnection.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//CrudRepository is a template class that takes two arguments class name and id type
public interface CourseRepository extends CrudRepository<Course, String> {

	//If the method name is in the particular naming format, findBy[Property] Spring Data JPA will implement the method and no need of implementation
	public List<Course> findByName(String name); 
	
	//If the property we are looking is not a string but a class then the fieldname on which the find should work has to be provided
	public List<Course> findByTopicId(String topicId); 
	
}

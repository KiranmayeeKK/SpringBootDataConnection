package io.katkol.SpringBootDataConnection.course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.katkol.SpringBootDataConnection.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//GET request
	//as get is default method, any request on localhost:8081/topics without method specification
	//executes this method 
	//This method retrieves the courses belonging to a topic rather than all the courses in the database. 
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	//PathVariable annotation is used to pass the value of the id_number to variable id
	//Using Optional<Course> will handle null if there are no objects with the requested id 
	//where as Course as return type will generate an internal error if there is no matching object
	//Only courseId is passed as input to the getCourse function because courseId is the primary key 
	//of course table and hence topicId is not needed to retrieve course info
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable("courseId") String courseId) {
		return courseService.getCourse(courseId);
	}
	
	//POST request
	//Any POST request on the URL localhost:8081/topics executes this method
	//@RequestBody annotation is used to tell Spring MVC to convert the payload of the request to
	//Course object and pass it to this function
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId ) {
		course.setTopic(new Topic(topicId, "", "")); // new Topic only maps to the existing topic with topicId, it neither creates a topic (if not present) nor updates the name and desc of exisiting topic
		courseService.addCourse(course);
	}
	
	//PUT request
	//Any PUT request on the URL localhost:8081/topics/{id} updates the topic information corresponding to id
	//@RequestBody annotation is used to tell Spring MVC to convert the payload of the request to
	//Course object and pass it to this function
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId,  @PathVariable("courseId") String courseId ) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	//DELETE request
	//Any DELETE request on the URL localhost:8081/topics/{id} deletes the topic information corresponding to id
	//@RequestBody annotation is used to tell Spring MVC to convert the payload of the request to
	//Course object and pass it to this function
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") String courseId) {
		courseService.deleteCourse(courseId);
	}
	
}

package io.katkol.SpringBootDataConnection.course;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//In this demo application the embedded Apache derby database is used and hence 
//no external database is made to access data 

@Service
public class CourseService {
	
	@Autowired
	public CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String courseId) {
		return courseRepository.findById(courseId);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	public void deleteCourse(String courseId) {
		courseRepository.deleteById(courseId);
	}
}

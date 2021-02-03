package io.katkol.SpringBootDataConnection.topic;

import org.springframework.data.repository.CrudRepository;

//CrudRepository is a template class that takes two arguments class name and id type
public interface TopicRepository extends CrudRepository<Topic, String> {

}

package jose.rodriguez.everis.peru.app.models.dao;

import jose.rodriguez.everis.peru.app.models.document.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CourseDao extends ReactiveMongoRepository<Course, String>{

}

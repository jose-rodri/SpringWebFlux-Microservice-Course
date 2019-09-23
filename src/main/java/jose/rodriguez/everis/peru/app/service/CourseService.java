package jose.rodriguez.everis.peru.app.service;

import jose.rodriguez.everis.peru.app.models.document.Course;
import jose.rodriguez.everis.peru.app.models.document.Modality;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

  public Flux<Course> findAll();
  public Mono<Course> findById(String id);
  public Mono<Course> save(Course course);
  public Mono<Void> delete(Course course);
  public Flux<Modality> findAllmodality();
  public Mono<Modality> findmodalityById(String id);
  public Mono<Modality> savemodality(Modality modality);
  public Mono<Void> deletemodality(Modality modality);
  
}

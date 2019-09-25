package jose.rodriguez.everis.peru.app.service.implement;

import jose.rodriguez.everis.peru.app.models.dao.ModalityDao;
import jose.rodriguez.everis.peru.app.models.dao.CourseDao;
import jose.rodriguez.everis.peru.app.models.document.Course;
import jose.rodriguez.everis.peru.app.models.document.Modality;
import jose.rodriguez.everis.peru.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImplement implements CourseService {


  @Autowired
  private CourseDao courseDao;


  @Autowired
  private ModalityDao modalityDao;


  @Override
  public Flux<Course> findAll() {
   
    return courseDao.findAll();
  }

  @Override
  public Mono<Course> findById(String id) {   
    return courseDao.findById(id);
  }

  @Override
  public Mono<Course> save(Course course) {
    // TODO Auto-generated method stub
    return courseDao.save(course);
  }

  @Override
  public Mono<Void> delete(Course course) {
    // TODO Auto-generated method stub
    return courseDao.delete(course);
  }

  @Override
  public Flux<Modality> findAllmodality() {
    // TODO Auto-generated method stub
    return modalityDao.findAll();
  }

  @Override
  public Mono<Modality> findmodalityById(String id) {
    // TODO Auto-generated method stub
    return modalityDao.findById(id);
  }

  @Override
  public Mono<Modality> savemodality(Modality modality) {
    // TODO Auto-generated method stub
    return modalityDao.save(modality);
  }

  @Override
  public Mono<Void> deletemodality(Modality modality) {
    // TODO Auto-generated method stub
    return modalityDao.delete(modality);
  }



}

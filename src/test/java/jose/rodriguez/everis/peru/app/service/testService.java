package jose.rodriguez.everis.peru.app.service;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import jose.rodriguez.everis.peru.app.models.dao.CourseDao;
import jose.rodriguez.everis.peru.app.models.document.Course;
import jose.rodriguez.everis.peru.app.service.implement.CourseServiceImplement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)

public class testService {



  @Mock
  private CourseDao courseDao;

  @InjectMocks
  private CourseServiceImplement courseService;

  


  @SuppressWarnings("unused")
  private void assertResults(Publisher<Course> publisher, Course... expectedCourse) {
    StepVerifier.create(publisher).expectNext(expectedCourse).verifyComplete();
  }


  @Test
  public void findAll() {
    Course p = new Course();
    
    p.setName("Html5");
    when(courseDao.findAll()).thenReturn(Flux.just(p));
    Flux<Course> actual = courseService.findAll();
    assertResults(actual, p);
  }


  @Test
  public void idexisting() {
    Course p = new Course();

    p.setName("Java");
  
    when(courseDao.findById(p.getId())).thenReturn(Mono.just(p));
    Mono<Course> actual = courseService.findById(p.getId());
    assertResults(actual, p);
  }


  @Test
  public void idInvalid() {
    Course p = new Course();
   
    p.setName("ILot");
    
    when(courseDao.findById(p.getId())).thenReturn(Mono.empty());
    Mono<Course> actual = courseService.findById(p.getId());
    assertResults(actual);
  }



  @Test
  public void save() {
    Course p = new Course();
  
    p.setName("Perl");
  
    when(courseDao.save(p)).thenReturn(Mono.just(p));
    Mono<Course> actual = courseService.save(p);
    assertResults(actual, p);
  }



  @Test
  public void delete() {
    Course p = new Course();
    p.setId("123");
    p.setName("ILot");
    when(courseDao.delete(p)).thenReturn(Mono.empty());
  }


  
  
  
}

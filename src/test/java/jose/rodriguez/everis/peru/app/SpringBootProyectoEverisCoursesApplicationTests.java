package jose.rodriguez.everis.peru.app;

import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import jose.rodriguez.everis.peru.app.models.dao.CourseDao;
import jose.rodriguez.everis.peru.app.models.document.Course;
import reactor.core.publisher.Flux;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringBootProyectoEverisCoursesApplicationTests {

 
  @Autowired
  private ApplicationContext applicationContext;
  
  private CourseDao courseRepo;
  private WebTestClient client;
  private List <Course> expectedCourse;
  
  /*
  @BeforeEach
  void setUp() {
    client = WebTestClient
      .bindToApplicationContext(applicationContext)
      .configureClient()
      .baseUrl("/api/everis/courses")
      .build();

    Flux<Course> initData = courseRepo.deleteAll()
      .thenMany(Flux.just(
          Course.builder().id("12345").fullName("omar").gender("male").birthday(LocalDate.of(1993, 2, 3)).academicPeriod("2").address("1").typeDocument("dni").document("73674232").build(),
          Course.builder().id("s1234").fullName("jose").gender("male").birthday(LocalDate.of(1997, 2, 3)).academicPeriod("2").address("1").typeDocument("dni").document("76786787").build())
        .flatMap(courseRepo::save))
      .thenMany(courseRepo.findAll());

    expectedCourse = initData.collectList().block();
  }

  */
  
  
  @Test
  public void contextLoads() {
  }
  
}

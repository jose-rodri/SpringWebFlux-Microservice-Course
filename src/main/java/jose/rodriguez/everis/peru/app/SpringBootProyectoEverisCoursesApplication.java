package jose.rodriguez.everis.peru.app;

import java.util.Date;
import jose.rodriguez.everis.peru.app.models.document.Course;
import jose.rodriguez.everis.peru.app.models.document.Modality;
import jose.rodriguez.everis.peru.app.service.CourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import reactor.core.publisher.Flux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;


@EnableSwagger2WebFlux
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootProyectoEverisCoursesApplication implements CommandLineRunner {


  private static final Logger log =
      LoggerFactory.getLogger(SpringBootProyectoEverisCoursesApplication.class);

  @Autowired
  private ReactiveMongoTemplate mongoTemplate;

  @Autowired
  private CourseService service;


  public static void main(String[] args) {
    SpringApplication.run(SpringBootProyectoEverisCoursesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    mongoTemplate.dropCollection("courses").subscribe();
    mongoTemplate.dropCollection("modalities").subscribe();

   
    Modality student = new Modality("student");
    Modality listeningFamily = new Modality("listeningFamily");
    Modality listeningTeacher = new Modality("listeningTeacher");
    Flux.just(student, listeningFamily, listeningTeacher).flatMap(c -> service.savemodality(c))
  
        .doOnNext(c -> {
          log.info("Modalidad  : " + c.getStudentModality());

        }).thenMany(

            Flux.just(new Course("Java","Arturo", new Date(), new Date(), student),
                new Course("C#","Leonela", new Date(), new Date(), listeningFamily),
                new Course("Angular","Nestor", new Date(), new Date(), student),
                new Course("Java","Oscar", new Date(), new Date(), listeningTeacher),
                new Course("Ruby","Kenyo", new Date(), new Date(), student)).flatMap(op -> {
                  return service.save(op);
                }))
        .subscribe(op -> log.info("insert : " + op.getCourseName()));



  }

}

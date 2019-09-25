package jose.rodriguez.everis.peru.app.controllers;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import jose.rodriguez.everis.peru.app.models.document.Course;
import jose.rodriguez.everis.peru.app.service.CourseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/everis/courses")
public class CourseController {
  
  
  @Autowired
  private CourseService service;
  
  
  /**
   * . Método listar coment
   */
  @GetMapping
  public Mono<ResponseEntity<Flux<Course>>> findAll() {
    return Mono.just(
        ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(service.findAll()));
    
   
   
  }
  
  /**
   * . a Método crear
   */

  @PostMapping
  public Mono<ResponseEntity<Course>> save(@RequestBody Course course) {
      return service.save(course)
        .map(p -> ResponseEntity.created(URI.create("/api/everis/courses/".concat(p.getId())))
            .contentType(MediaType.APPLICATION_JSON_UTF8).body(p));

  }
  
  /**
   * . Método filtrar por codigo
   * 
   * @return
   */
  
  
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Course>> findById(@PathVariable String id) {
    return service.findById(id)
        .map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
        .defaultIfEmpty(ResponseEntity.notFound().build());
   
 
  }
  

  
  
  /**
   * . Método actualizar
   * 
   * @return
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Course>> update(@RequestBody Course course,
      @PathVariable String id) {
    return service.findById(id).flatMap(t -> {
      t.setNombre(course.getNombre());
      t.setStartDate(course.getStartDate());
      t.setEndDate(course.getEndDate());
      t.setModality(course.getModality());
      return service.save(t);
    }).map(
        p -> ResponseEntity.created(URI.create("/api/everis/openings/".concat(p.getId()))).body(p))
        .defaultIfEmpty(ResponseEntity.notFound().build());


  }
  
  /**
   * .
   * 
   * @return
   */
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    return service.findById(id).flatMap(p -> {
      return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));

    }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
  }

  

}

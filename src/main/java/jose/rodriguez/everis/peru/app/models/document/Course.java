package jose.rodriguez.everis.peru.app.models.document;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "courses")
public class Course {

  @Id
  private String id;
  private String nombre;
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  private Date startDate;
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  private Date endDate;

  private Modality modality;

  
  /**.
   *Modali
   */
  public Course(String nombre, Date startDate, Date endDate, Modality modality) {

    this.nombre = nombre;
    this.startDate = startDate;
    this.endDate = endDate;
    this.modality = modality;
  }



}

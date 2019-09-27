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
//@Builder

public class Course {

  @Id
  private String id;
  private String courseName;
  private String name;
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  private Date startDate;
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  private Date endDate;

  private Modality modality;

  public Course(String courseName, String name, Date startDate, Date endDate, Modality modality) {

    this.courseName = courseName;
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.modality = modality;
  }

  public Course() {
   
  }

 





}

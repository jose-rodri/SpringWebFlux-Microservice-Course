package jose.rodriguez.everis.peru.app.models.document;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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
  
  public Course() {
   
  }


  public Course(String nombre, Date startDate, Date endDate) {
   
    this.nombre = nombre;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  
  



  public Course(String nombre, Date startDate, Date endDate, Modality modality) {
   
    this(nombre,startDate,endDate);
    this.modality = modality;
  }

  
  

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public String getNombre() {
    return nombre;
  }


  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public Date getStartDate() {
    return startDate;
  }


  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }


  public Date getEndDate() {
    return endDate;
  }


  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }


  public Modality getModality() {
    return modality;
  }


  public void setModality(Modality modality) {
    this.modality = modality;
  }


 

  
  
  
  
}

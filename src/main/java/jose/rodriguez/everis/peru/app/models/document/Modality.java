package jose.rodriguez.everis.peru.app.models.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "modalities")
public class Modality {

  
  private String id;
  
  private String StudentModality;
  
  
  
  public Modality() {
    
  }

  public Modality(String studentModality) {
    StudentModality = studentModality;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStudentModality() {
    return StudentModality;
  }

  public void setStudentModality(String studentModality) {
    StudentModality = studentModality;
  }
  
  
  
  
}
